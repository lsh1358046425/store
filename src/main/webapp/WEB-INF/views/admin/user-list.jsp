<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
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
                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="keyword"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-body ">
                    <script type="text/html" id="userStatus">
                        {{#  if(d.userStatus){ }}
                        <input type="checkbox" value="{{ d.userId }}" lay-filter="userStatus" lay-skin="switch" lay-text="启用|禁用" checked>
                        {{# } else { }}
                        <input type="checkbox" value="{{ d.userId }}" lay-filter="userStatus" lay-skin="switch" lay-text="启用|禁用">
                        {{# } }}
                    </script>
                    <table class="layui-table layui-form" id="userTable" lay-filter="userTable"></table>
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
            elem: '#userTable'
            ,url: '/store/admin/getUserByPage' //数据接口
            ,title: '分类表'
            ,page: true //开启分页
            ,limit: 10
            ,limits: [3,5,10]
            ,cols: [[
                {field: 'userId', title: 'ID', sort: true, width: 80, fixed: 'left'}
                ,{field: 'userName', title: '用户名'}
                ,{field: 'userPassword', title: '密码'}
                ,{fixed: 'right', title: '用户状态', align:'center', width: 100, templet:'#userStatus'}
            ]]
        });

        //搜索
        form.on('submit(sreach)', function(obj) {
            var data = obj.field;

            table.reload('userTable', {
                where: {
                    //设定异步数据接口的额外参数
                    keyword: data.keyword
                },
                page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
            return false;
        });

        // 监听用户状态
        form.on('switch(userStatus)', function(data){
            var userStatus = data.elem.checked
            var userId = data.value

            $.ajax({
                type: "GET",
                url: "/store/admin/userStatusUpdate?userId=" + userId + "&userStatus=" + userStatus,
                success: function(data){
                    if (data.status) {
                        layer.msg(data.msg, {icon: 1, time: 1000});
                        $(".layui-laypage-btn").click();
                    }else {
                        layer.msg("状态更新失败", {icon: 5, time: 1000});
                    }
                },
                error: function () {
                    layer.msg("状态更新失败", {icon: 5, time: 1000});
                }
            })
            return false;
        });
    });
</script>
</body>
</html>
