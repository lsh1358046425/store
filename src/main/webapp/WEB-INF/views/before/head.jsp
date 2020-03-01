<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商城</title>
    <link rel="stylesheet" type="text/css" href="/store/css/main.css">
    <link rel="stylesheet" type="text/css" href="/store/lib/layui/css/layui.css">
    <script src="/store/lib/layui/layui.js" charset="utf-8"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

<div class="site-nav-bg">
    <div class="site-nav w1200">
        <p class="sn-back-home">
            <i class="layui-icon layui-icon-home"></i>
            <a href="/store/">首页</a>
        </p>
        <div class="sn-quick-menu">
            <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <div class="login"><a href="javascript:;" style="position: relative;right: 20px;">欢迎，${sessionScope.user.userName}!</a></div>
                    <div class="sp-cart"><a href="/store/orders" style="position: relative;right: 30px;">我的订单&emsp;</a></div>
                    <div class="sp-cart"><a href="/store/logout" style="position: relative;right: 15px;">注销&emsp;</a></div>
                    <div class="sp-cart"><a href="/store/cart">购物车</a><span id="cartNum">${sessionScope.cartNum}</span></div>
                </c:when>
                <c:otherwise>
                    <div class="login"><a href="/store/login">登录</a></div>
                    <div class="sp-cart"><a href="/store/cart">购物车</a><span id="cartNum">0</span></div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>



<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="/store/" title="母婴商城">
                    <img src="/store/images/logo.png">
                </a>
            </h1>
            <div class="mallSearch">
                <form action="/store/search" class="layui-form" novalidate>
                    <input type="text" name="keyword" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">
                        <i class="layui-icon layui-icon-search"></i>
                    </button>
                    <input type="hidden" name="" value="">
                </form>
            </div>
        </div>
    </div>
</div>
