<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="/store/css/font.css">
    <link rel="stylesheet" href="/store/css/xadmin.css">
    <script src="/store/lib/layui/layui.js" charset="utf-8"></script>
    <title>增加公告</title>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-card">
            <form class="layui-form layui-card-body" id="myForm" onsubmit="return addNotice()">
                <div class="layui-form-item">
                    <label class="layui-form-label">标题</label>
                    <div class="layui-input-block">
                        <input type="text" name="noticeTitle" required lay-verify="required" autocomplete="off"
                               class="layui-input" value="${requestScope.notice.noticeTitle}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">内容</label>
                    <div class="layui-input-block">
                        <textarea name="noticeContent" placeholder="" class="layui-textarea">${requestScope.notice.noticeContent}</textarea>
                    </div>
                </div>
                <input type="hidden" name="noticeId" value="${requestScope.notice.noticeId}">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">更新</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    layui.use(['table', 'layer', 'jquery'], function() {
        var table = layui.table,
            layer = layui.layer,
            $ = layui.jquery;

        window.addNotice = function() {
            var index = parent.layer.getFrameIndex(window.name);

            $.ajax({
                type: "POST",
                url: "/store/admin/noticeUpdate",
                data: $('#myForm').serialize(),
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
                    parent.layer.msg("更新失败");
                }
            });
            return false;
        }
    });
</script>
</body>
</html>