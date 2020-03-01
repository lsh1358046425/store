<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="head.jsp"%>
<div class="content content-nav-base shopcart-content">
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
    <br><br><br>

    <div class="data-cont-wrap w1200">
        <div class="crumb">
            <a href="/store/">首页</a>
            <span>></span>
            <a href="javascript:;">我的订单</a>
        </div>
    </div>
    <div class="cart w1200">
        <table class="layui-table" lay-skin="line" >
            <colgroup>
                <col width="400">
                <col width="100">
                <col width="100">
                <col width="500">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>订单信息</th>
                <th>订单金额</th>
                <th>订单状态</th>
                <th>收货地址</th>
                <th>订单详情</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${requestScope.orders}">
                <tr>
                    <td>
                        订单号：${order.orderId}<br>
                        交易时间：${order.orderDate}
                    </td>
                    <td>￥<fmt:formatNumber pattern="#.00" value="${order.orderAmount}" /></td>
                    <td>
                        <c:choose>
                            <c:when test="${order.orderStatus == 0}">
                                未发货
                            </c:when>
                            <c:when test="${order.orderStatus == 1}">
                                已发货
                            </c:when>
                        </c:choose>
                    </td>
                    <td>${order.orderAddress}</td>
                    <td>
                        <a title="详情" onclick="orderDetail('${order.orderId}')">
                            <i class="layui-icon">&#xe60a;</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@include file="foot.jsp"%>
<script>
    layui.use(['jquery', 'layer'], function(){
        var $ = layui.jquery,
            layer = layui.layer;

        window.orderDetail = function (orderId) {
            layer.open({
                type: 2,
                area: ["70%", "70%"],
                fix: false, //不固定
                maxmin: true,
                shadeClose: true,
                shade:0.4,
                title: "订单详情",
                content: '/store/orderDetail?orderId=' +  orderId,
            });
        }
    });
</script>
</body>
</html>
