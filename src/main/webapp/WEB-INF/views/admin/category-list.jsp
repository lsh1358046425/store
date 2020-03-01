<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>分类列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="/store/css/font.css">
    <link rel="stylesheet" href="/store/css/xadmin.css">
    <script src="/store/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/store/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5" type="post">
                        <div class="layui-input-inline layui-show-xs-block">
                            <input class="layui-input" placeholder="分类名" name="categoryName" lay-verify="required"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <button class="layui-btn"  lay-submit lay-filter="addCategory" type="submit"><i class="layui-icon"></i>增加</button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form" id="categoryTable" lay-filter="categoryTable"></table>
                    <script type="text/html" id="bar">
                        <a title="编辑"  lay-event="edit">
                            <i class="layui-icon">&#xe642;</i>
                        </a>
                        <a title="删除" lay-event="del">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </script>
                    <script type="text/html" id="hotCheckbox">
                        {{#  if(d.categoryHot){ }}
                        <input type="checkbox" value="{{ d.categoryId }}" lay-filter="categoryHot" lay-skin="switch" lay-text="开启|关闭" checked>
                        {{# } else { }}
                        <input type="checkbox" value="{{ d.categoryId }}" lay-filter="categoryHot" lay-skin="switch" lay-text="开启|关闭">
                        {{# } }}
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    layui.use(['form', 'jquery', 'table'], function(){
        var form = layui.form,
            $ = layui.jquery,
            table = layui.table;

        //执行一个 table 实例
        table.render({
            elem: '#categoryTable'
            ,url: '/store/admin/getCategoryByPage' //数据接口
            ,title: '分类表'
            ,page: true //开启分页
            ,limit: 10
            ,limits: [3,5,10]
            ,cols: [[
                {field: 'categoryId', title: 'ID', sort: true, width: 80, fixed: 'left'}
                ,{field: 'categoryName', title: '分类名'}
                ,{field: 'categoryHot', title: '热门分类', templet:'#hotCheckbox'}
                ,{fixed: 'right', title: '操作', align:'center', width: 100, toolbar: '#bar'}
            ]]
        });

        // 监听热门分类
        form.on('switch(categoryHot)', function(data){
            var isCategoryHot = data.elem.checked
            var categoryId = data.value

            $.ajax({
                type: "GET",
                url: "/store/admin/updateCategoryHot?categoryId=" + categoryId + "&categoryHot=" + isCategoryHot,
                success: function(data){
                    if (data.status) {
                        layer.msg(data.msg, {icon: 1, time: 1000});
                        $(".layui-laypage-btn").click();
                    }else {
                        layer.msg(data.msg, {icon: 5, time: 1000});
                    }
                },
                error: function () {
                    layer.msg("状态更新失败", {icon: 5, time: 1000});
                }
            })
            return false;
        });

        //监听增加
        form.on('submit(addCategory)', function(obj){
            var data = obj.field;
            $.ajax({
                type: "GET",
                url: "/store/admin/addCategory?categoryName=" + data.categoryName,
                success: function(data){
                    if (data.status) {
                        layer.msg(data.msg, {icon: 1, time: 1000});
                        $(".layui-laypage-btn").click();
                    }else {
                        layer.msg(data.msg, {icon: 5, time: 1000});
                    }
                },
                error: function () {
                    layer.msg("添加失败", {icon: 5, time: 1000});
                }
            })
            return false;
        });

        //监听行工具事件
        table.on('tool(categoryTable)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'del'){
                layer.confirm('确定删除分类', function(index){
                    //向服务端发送删除指令
                    $.ajax({
                        type: "GET",
                        url: "/store/admin/deleteCategory?categoryId=" + data.categoryId,
                        success: function(data){
                            if (data.status) {
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.close(index);
                                layer.msg(data.msg, {icon: 1, time: 1000});
                            }else {
                                layer.close(index);
                                layer.msg(data.msg, {icon: 5, time: 1000});
                            }
                        },
                        error: function () {
                            layer.close(index);
                            layer.msg("删除失败", {icon: 5, time: 1000});
                        }
                    });
                });
            } else if(layEvent === 'edit'){
                layer.prompt({
                    value: data.categoryName,
                    title: '编辑分类'
                }, function(value, index, elem){
                    $.ajax({
                        type: "POST",
                        url: "/store/admin/updateCategory",
                        contentType: "application/json;charset=utf-8",
                        data: JSON.stringify({"categoryId": data.categoryId, "categoryName": value}),
                        success: function(data){
                            if (data.status) {
                                layer.close(index);
                                layer.msg(data.msg, {icon: 1, time: 1000});
                                $(".layui-laypage-btn").click();
                            }else {
                                layer.close(index);
                                layer.msg(data.msg, {icon: 5, time: 1000});
                            }
                        },
                        error: function () {
                            layer.close(index);
                            layer.msg("更新失败", {icon: 5, time: 1000});
                        }
                    })
                });
            }
        });
    });
</script>
</body>
</html>
