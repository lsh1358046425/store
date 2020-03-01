<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="/store/css/font.css">
    <link rel="stylesheet" href="/store/css/login.css">
    <script src="/store/lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">管理员登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form" >
        <input name="adminName" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <input name="adminPassword" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >
    </form>
</div>

<script>
    layui.use(['form', 'jquery'], function(){
        var form = layui.form
        $ = layui.jquery;
        //监听提交
        form.on('submit(login)', function(obj){
            $.ajax({
                type: "POST",
                url: "/store/admin/checkLogin",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify(obj.field),
                success: function(data){
                    if (data.status) {
                        layer.msg(data.msg, {icon: 1, time: 1000}, function(){
                            location.href='/store/admin/index'
                        });
                    }else {
                        layer.msg(data.msg, {icon: 5, time: 1000});
                    }
                }
            })
            return false;
        });
    });
</script>
<!-- 底部结束 -->
</body>
</html>