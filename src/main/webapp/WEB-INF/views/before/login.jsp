<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="head.jsp"%>

<div class="content content-nav-base  login-content">
	<div class="main-nav">
		<div class="inner-cont0">
			<div class="inner-cont1 w1200">
				<div class="inner-cont2">
					<a href="/store/search" class="active">所有商品</a>
					<a href="/store/buyToday">今日团购</a>
					<a href="/store/information">母婴资讯</a>
					<a href="/store/about">关于我们</a>
				</div>
			</div>
		</div>
	</div>
	<div class="login-bg">
		<div class="login-cont w1200">

			<div class="form-box layui-tab layui-tab-card">
				<ul class="layui-tab-title" style="width: 360px;position: absolute;left: 0">
					<li class="layui-this" style="width: 152px">登录</li>
					<li style="width: 152px">注册</li>
				</ul>
				<div class="layui-tab-content" style="height: 100px;">
					<form class="layui-form layui-tab-item layui-show" action="" style="position: relative;top: 100px">
						<div class="layui-form-item">
							<div class="layui-inline iphone">
								<div class="layui-input-inline">
									<i class="layui-icon layui-icon-cellphone iphone-icon"></i>
									<input type="tel" name="userName" id="userName" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-inline iphone">
								<div class="layui-input-inline">
									<i class="layui-icon layui-icon-password iphone-icon"></i>
									<input id="userPassword" type="password" name="userPassword" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>
						<div class="layui-form-item login-btn">
							<div class="layui-input-block">
								<button class="layui-btn" lay-submit="" type="submit" lay-filter="login">登录</button>
							</div>
						</div>
					</form>

					<form class="layui-form layui-tab-item" style="position: relative;top: 100px">
						<div class="layui-form-item">
							<div class="layui-inline iphone" style="top: -20px;">
								<div class="layui-input-inline">
									<i class="layui-icon layui-icon-cellphone iphone-icon"></i>
									<input type="tel" name="userName" id="userName" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-inline iphone" style="top: -20px;">
								<div class="layui-input-inline">
									<i class="layui-icon layui-icon-password iphone-icon"></i>
									<input id="userPassword" type="password" name="userPassword" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-inline iphone" style="top: -20px;">
								<div class="layui-input-inline">
									<i class="layui-icon layui-icon-password iphone-icon"></i>
									<input id="check" type="password"  lay-verify="required" placeholder="请确认密码" autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>
						<div class="layui-form-item login-btn">
							<div class="layui-input-block" style="top: -20px;">
								<button class="layui-btn" lay-submit="" lay-filter="register">注册</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="foot.jsp"%>

<script type="text/javascript">
    layui.use(['jquery', 'form', 'element'], function(){
        var $ = layui.jquery, form = layui.form, element = layui.element;

        form.on('submit(register)', function(obj){
            var usernamePattern = /^[a-zA-Z0-9_-]{4,16}$/;
            var passwordPattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*?.]).*$/;
            var data = obj.field;
            var check = $('#check').val()
            if (!usernamePattern.test(data.userName)){
                layer.msg("用户名不符合规范", {icon: 5, time: 1000});
            }else if(!passwordPattern.test(data.userPassword)){
                layer.msg("密码最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符", {icon: 5, time: 2000});
            }else if(check != data.userPassword){
                layer.msg("密码不一致", {icon: 5, time: 1000});
            }else {
                $.ajax({
                    type: "POST",
                    url: "/store/register",
                    data: data,
                    success: function(data){
                        if (data.status) {
                            layer.msg(data.msg, {icon: 1, time: 1000});
                        }else {
                            layer.msg(data.msg, {icon: 5, time: 1000});
                        }
                    }
                })
            }
            return false;
        });

        form.on('submit(login)', function(obj){
            $.ajax({
                type: "POST",
                url: "/store/checkLogin",
                data: obj.field,
                success: function(data){
                    if (data.status) {
                        layer.msg(data.msg, {icon: 1, time: 1000}, function(){
                            window.location.href="/store/index";
                        });
                    }else {
                        layer.msg(data.msg, {icon: 5, time: 1000});
                    }
                }
            });
            return false;
        });
    })
</script>

</body>
</html>