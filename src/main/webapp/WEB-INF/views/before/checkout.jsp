<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="head.jsp"%>
<div class="content content-nav-base shopcart-content">
    <form class="layui-form" action="">
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
                <a href="/store/cart">购物车</a>
                <span>></span>
                <a href="javascript:;">结算页面</a>
            </div>
        </div>

        <div class="w1200 layui-bg-gray" style="padding: 20px 20px 20px 0;width: 1180px;">
            <div class="layui-form-item">
                <label class="layui-form-label">收货人</label>
                <div class="layui-input-block">
                    <input type="text" name="name" required  lay-verify="required" autocomplete="off" class="layui-input" style="width: 150px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">联系方式</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone" required lay-verify="phone" autocomplete="off" class="layui-input" style="width: 150px">
                </div>
                <div class="layui-form-mid layui-word-aux">(手机号或者固话)</div>
            </div>
            <div class="layui-form-item">
                <div class="layui-form-item x-city" id="end">
                    <label class="layui-form-label">地址</label>
                    <div class="layui-input-inline">
                        <select name="province" lay-filter="province">
                            <option value="">请选择省</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="city" lay-filter="city">
                            <option value="">请选择市</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="area" lay-filter="area">
                            <option value="">请选择县/区</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">详细地址</label>
                <div class="layui-input-block">
                    <textarea name="desc" placeholder="" class="layui-textarea" style="width: 980px;"></textarea>
                </div>
            </div>
        </div>
        <br>
        <div class="cart w1200">
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="120">
                    <col width="480">
                    <col width="200">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th></th>
                    <th>商品</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>小计</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="good" items="${requestScope.goods}">
                    <tr>
                        <td><img src="/store/images/${good.goodPicture}"/></td>
                        <td>${good.goodName}</td>
                        <td><fmt:formatNumber pattern="#.00" value="${good.goodPrice}" /></td>
                        <td>${good.cartNum}</td>
                        <td class="cartAmount"><fmt:formatNumber pattern="#.00" value="${good.cartAmount}" /></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="w1200" style="text-align: right;height: 100px;color: #fc6608">
            合计:<span id="allPrice" style="font-size: 22px;font-weight: bold"></span>元&emsp;&emsp;
            <button class="layui-btn layui-btn-danger layui-btn-lg" lay-submit="" lay-filter="orderSubmit" style="width:130px;height: 60px ;font-size: 22px">提交订单</button>
        </div>
    </form>
</div>
<%@include file="foot.jsp"%>
<script type="text/javascript" src="/store/js/jquery.min.js"></script>
<script type="text/javascript" src="/store/js/xcity.js"></script>
<script>
    layui.use(['form','code'], function(){
        form = layui.form,

        layui.code();
        $('#start').xcity();
        $('#end').xcity('广东','广州市','从化市');

        cartAmount = $('.cartAmount')
        allPrice = 0;
        for (var i = 0; i < cartAmount.length; i++) {
            allPrice += parseFloat(cartAmount[i].innerHTML)
        }
        $('#allPrice').html(allPrice.toFixed(2))

        form.on('submit(orderSubmit)', function(obj){
            var data = obj.field;
            var address = data.name + '  ' + data.phone + '  ' + data.province + data.city + data.area +
                    data.desc;
            var goodIds = new Array();
            <c:forEach var="good" items="${requestScope.goods}">
                goodIds.push(${good.goodId})
            </c:forEach>

            $.ajax({
                type: "POST",
                url: "/store/ordersSubmit",
                traditional:true,
                data: {address: address,goodIds:goodIds},
                success: function(data){
                    if (data.status) {
                        layer.msg("下单成功", {icon: 1, time: 1000}, function(){
                            window.location.href="/store/orders";
                        });
                    }else {
                        layer.msg("系统错误", {icon: 5, time: 1000});
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
