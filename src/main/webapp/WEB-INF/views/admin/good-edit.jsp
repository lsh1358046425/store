<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="/store/css/font.css">
    <link rel="stylesheet" href="/store/css/xadmin.css">
    <script src="/store/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/store/js/jquery.min.js"></script>
    <script type="text/javascript" src="/store/js/jquery.serializejson.min.js"></script>
    <title>编辑商品</title>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-card">
            <form class="layui-form layui-card-body" id="myForm" onsubmit="return editGood()">
                <input type="hidden" name="goodId" value="${requestScope.good.goodId}" required lay-verify="required" id="goodId">
                <div class="layui-form-item">
                    <label class="layui-form-label">商品名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="goodName" required lay-verify="required" autocomplete="off"
                               class="layui-input" value="${requestScope.good.goodName}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">价格</label>
                    <div class="layui-input-inline">
                        <input type="text" min="0" name="goodPrice" required lay-verify="number" autocomplete="off"
                               class="layui-input" value="${requestScope.good.goodPrice}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">分类</label>
                    <div class="layui-input-block">
                        <select name="categoryId" lay-verify="required">
                            <c:forEach items="${requestScope.categories}" var="category">
                                <c:choose>
                                    <c:when test="${requestScope.good.categoryId == category.categoryId}">
                                        <option value="${category.categoryId}" selected>${category.categoryName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${category.categoryId}">${category.categoryName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="top:42px;">商品图片</label>
                    <input type="hidden" name="goodPicture" value="${requestScope.good.goodPicture}"
                           required lay-verify="required" id="goodPicture">
                    <div class="layui-input-inline" style="top:42px;">
                        <button type="button" class="layui-btn" id="upload">
                            <i class="layui-icon">&#xe67c;</i>更改图片
                        </button>
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <img class="layui-upload-img" id="demo1" height="100" width="100"
                             src="/store/images/${requestScope.good.goodPicture}">
                        <span id="demoText"></span>
                    </div>
                </div>
                <div class="layui-input-block">
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即更新</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    layui.use(['table', 'layer', 'upload'], function() {
        var table = layui.table,
            layer = layui.layer,
            upload = layui.upload;

        //创建一个上传组件
        var uploadInst = upload.render({
            elem: '#upload'
            , url: '/store/admin/uploadPicture'
            , accept: 'images'
            , acceptMime: 'image/*'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (data) {
                if (data.status) {
                    $('#goodPicture').val(data.data);
                    return layer.msg(data.msg);
                } else {
                    return layer.msg(data.msg);
                }
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });

        window.editGood = function() {
            var index = parent.layer.getFrameIndex(window.name);

            $.ajax({
                type: "POST",
                url: "/store/admin/goodEdit",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify($('#myForm').serializeJSON()),
                success: function (data) {
                    if (data.status) {
                        parent.layer.close(index);
                        parent.layer.msg(data.msg);
                    } else {
                        parent.layer.close(index);
                        parent.layer.msg(data.msg);
                    }
                },
                error: function () {
                    parent.layer.close(index);
                    parent.layer.msg("编辑失败");
                }
            });
            return false;
        }
    });
</script>
</body>
</html>