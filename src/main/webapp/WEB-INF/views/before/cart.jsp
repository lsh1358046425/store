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
    <div class="banner-bg w1200">
        <h3>夏季清仓</h3>
        <p>宝宝被子、宝宝衣服3折起</p>
    </div>
    <div class="data-cont-wrap w1200">
        <div class="crumb">
            <a href="/store/">首页</a>
            <span>></span>
            <a href="javascript:;">购物车</a>
        </div>
        <br>
    </div>
    <div class="cart w1200">
        <div class="cart-table-th">
            <div class="th th-chk">
                <div class="select-all">
                    <div class="cart-checkbox">
                        <input class="check-all check" id="allCheckked" type="checkbox" value="true">
                    </div>
                    <label>&nbsp;&nbsp;全选</label>
                </div>
            </div>
            <div class="th th-item">
                <div class="th-inner">
                    商品
                </div>
            </div>
            <div class="th th-price">
                <div class="th-inner">
                    单价
                </div>
            </div>
            <div class="th th-amount">
                <div class="th-inner">
                    数量
                </div>
            </div>
            <div class="th th-sum">
                <div class="th-inner">
                    小计
                </div>
            </div>
            <div class="th th-op">
                <div class="th-inner">
                    操作
                </div>
            </div>
        </div>
        <form method="post" id="myForm" action="/store/checkout">
            <div class="OrderList">
                <div class="order-content" id="list-cont">
                    <c:forEach items="${requestScope.goods}" var="good">
                        <ul class="item-content layui-clear">
                            <li class="th th-chk">
                                <div class="select-all">
                                    <div class="cart-checkbox">
                                        <input class="CheckBoxShop check" id="" type="checkbox" num="all" value="true">
                                    </div>
                                </div>
                            </li>
                            <li class="th th-item">
                                <div class="item-cont">
                                    <a href="javascript:;"><img src="/store/images/${good.goodPicture}" alt=""></a>
                                    <div class="text">
                                        <div class="title">${good.goodName}</div>
                                    </div>
                                </div>
                            </li>
                            <li class="th th-price">
                                <span class="th-su"><fmt:formatNumber pattern="#.00" value="${good.goodPrice}" /></span>
                            </li>
                            <li class="th th-amount">
                                <div class="box-btn layui-clear">
                                    <div class="less layui-btn">-</div>
                                    <input class="Quantity-input" type="" value="${good.cartNum}" disabled="disabled">
                                    <div class="add layui-btn">+</div>
                                </div>
                            </li>
                            <li class="th th-sum">
                                <span class="sum"><fmt:formatNumber pattern="#.00" value="${good.cartAmount}" /></span>
                            </li>
                            <li class="th th-op">
                                <span class="dele-btn">删除</span>
                            </li>
                            <input type="hidden" class="id" name="goodIds" value="${good.goodId}"/>
                        </ul>
                    </c:forEach>
                </div>
            </div>

            <div class="FloatBarHolder layui-clear">
                <div class="th th-chk">
                    <div class="select-all">
                        <div class="cart-checkbox">
                            <input class="check-all check" type="checkbox"  value="true">
                        </div>
                        <label>&nbsp;&nbsp;已选<span class="Selected-pieces">0</span>件</label>
                    </div>
                </div>
                <div class="th batch-deletion">
                    <span class="batch-dele-btn">批量删除</span>
                </div>
                <div class="th Settlement">
                    <button class="layui-btn" type="submit">结算</button>
                </div>
                <div class="th total">
                    <p>应付：<span class="pieces-total">0</span></p>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="foot.jsp"%>
<script type="text/javascript">
    layui.config({
        base: '/store/js/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm','jquery','element','car'],function(){
        var mm = layui.mm,$ = layui.$,element = layui.element,car = layui.car;

        car.init();
    });
</script>
</body>
</html>