<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="/store/css/font.css">
    <link rel="stylesheet" href="/store/css/xadmin.css">
    <script src="/store/lib/layui/layui.js" charset="utf-8"></script>
    <title>订单详情</title>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-card">
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col>
                    <col>
                    <col>
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>商品</th>
                    <th>商品名称</th>
                    <th>现价</th>
                    <th>数量</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="orderDetail" items="${requestScope.orderDetails}">
                    <tr>
                        <td><img src="/store/images/${orderDetail.goodPicture}"/></td>
                        <td>${orderDetail.goodName}</td>
                        <td><fmt:formatNumber pattern="#.00" value="${orderDetail.goodPrice}" /></td>
                        <td>${orderDetail.orderDetailNum}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    layui.use(['table', 'layer', 'jquery'], function() {
        var table = layui.table,
            layer = layui.layer,
            $ = layui.jquery;

    });
</script>
</body>
</html>