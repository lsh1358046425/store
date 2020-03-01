<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="head.jsp"%>


<div class="content content-nav-base datails-content">
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
  <div class="data-cont-wrap w1200">
    <div class="crumb">
      <a href="/store/">首页</a>
      <span>></span>
      <a href="/store/search">所有商品</a>
      <span>></span>
      <a href="javascript:;">产品详情</a>
    </div>
    <div class="product-intro layui-clear">
      <div class="preview-wrap">
        <a href="javascript:;"><img src="/store/images/${requestScope.good.goodPicture}" width="400" height="400"></a>
      </div>
      <div class="itemInfo-wrap">
        <div class="itemInfo">
          <div class="title">
            <h4>${requestScope.good.goodName} </h4>
            <span><i class="layui-icon layui-icon-rate-solid"></i>收藏</span>
          </div>
          <div class="summary">
            <br><br>
            <p class="activity"><span>价&nbsp;&nbsp;&nbsp;格</span><strong class="price"><i>￥</i>${requestScope.good.goodPrice}</strong></p>
          </div>
          <div class="choose-attrs">
            <div class="number layui-clear"><span class="title">数&nbsp;&nbsp;&nbsp;&nbsp;量</span><div class="number-cont"><span class="cut btn">-</span><input onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" maxlength="4" type="" name="" value="1" id="goodNum"><span class="add btn">+</span></div></div>
          </div>
          <div class="choose-btns">
            <button class="layui-btn  layui-btn-danger car-btn" id="addCart"><i class="layui-icon layui-icon-cart-simple"></i>加入购物车</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<%@include file="foot.jsp"%>
<script type="text/javascript">
    layui.use(['jquery', 'layer'], function(){
        var $ = layui.$,
            layer = layui.layer;
        var cur = $('.number-cont input').val();
        $('.number-cont .btn').on('click',function(){
            if($(this).hasClass('add')){
                cur++;
            }else{
                if(cur > 1){
                    cur--;
                }
            }
            $('.number-cont input').val(cur)
        })

        $('#addCart').click(function () {
            var goodNum = Number($('#goodNum').val());
            var cartNum = Number($('#cartNum').html());

            $.ajax({
                type: "GET",
                url: "/store/cartAdd?goodId=${requestScope.good.goodId}&cartNum=" + goodNum,
                success: function(data){
                    if (data.status) {
                        layer.msg(data.msg, {icon: 1, time: 1000});
                        $('#cartNum').html(cartNum + goodNum);
                    }else {
                        layer.msg("请登录", {icon: 5, time: 1000});
                    }
                }
            })
        })
    });
</script>


</body>
</html>