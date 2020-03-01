<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="head.jsp"%>
<style>
    .layer .layui-layer-title{background-color: #cdb0f0;color: white;}
    .layer .layui-layer-btn0{background-color: #cdb0f0; border-color: white;}
</style>
<div class="content">
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
    <div class="category-con">
        <div class="category-inner-con w1200">
            <div class="category-type">
                <style>
                    .layui-nav .layui-this:after, .layui-nav-bar, .layui-nav-tree .layui-nav-itemed:after {
                        background-color: #fcf5f8;
                    }
                    .content .category-con .category-type {
                        line-height: 25px;
                        background: #cfb2f6;
                        margin-top: -45px;
                    }
                    .layui-nav .layui-nav-item {
                        line-height: 45px;
                    }
                    .layui-nav-child {
                        top: 50px;
                        line-height: 36px;
                    }
                    .layui-nav {
                        background-color: #ceb1f3;
                    }
                </style>
                <ul class="layui-nav" lay-filter="">
                    <li class="layui-nav-item">
                        <a href="javascript:;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全部分类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                        <dl class="layui-nav-child"> <!-- 二级菜单 -->
                            <c:forEach items="${requestScope.categories}" var="category">
                                <dd><a href="/store/category?categoryId=${category.categoryId}">${category.categoryName}</a></dd>
                            </c:forEach>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>
        <div class="category-banner">
            <div class="w1200">
                <img src="/store/images/banner1.jpg">
            </div>
        </div>
    </div>
    <div class="floors">
        <div class="sk">
            <div class="sk_inner w1200">
                <div class="sk_hd">
                    <a href="javascript:;">
                        <img src="/store/images/s_img1.jpg">
                    </a>
                </div>
                <div class="sk_bd">
                    <div class="layui-carousel" id="test1">
                        <div carousel-item>
                            <c:forEach items="${requestScope.todayGoods}" var="good" varStatus="status">
                                <c:choose>
                                    <c:when test="${status.index % 4 == 0}">
                                        <div class="item-box">
                                        <div class="item">
                                            <a href="/store/details?goodId=${good.goodId}"><img src="/store/images/${good.goodPicture}"></a>
                                            <div class="title">${good.goodName}</div>
                                            <div class="price">
                                                <span>￥${good.goodPrice}</span>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:when test="${status.index % 4 == 3}">
                                        <div class="item">
                                            <a href="/store/details?goodId=${good.goodId}"><img src="/store/images/${good.goodPicture}"></a>
                                            <div class="title">${good.goodName}</div>
                                            <div class="price">
                                                <span>￥${good.goodPrice}</span>
                                            </div>
                                        </div>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="item-box">
                                            <div class="item">
                                                <a href="/store/details?goodId=${good.goodId}"><img src="/store/images/${good.goodPicture}"></a>
                                                <div class="title">${good.goodName}</div>
                                                <div class="price">
                                                    <span>￥${good.goodPrice}</span>
                                                </div>
                                            </div>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="product-cont w1200" id="product-cont">
        <c:forEach var="hotCategoriesGood" items="${requestScope.hotCategoriesGoods}" varStatus="status">
            <div class="product-item product-item${(status.index % 3) + 1} layui-clear">
                <div class="left-title">
                    <h4><i>${status.index + 1}F</i></h4>
                    <img src="/store/images/icon_gou.png">
                    <h5>${hotCategoriesGood.categoryName}</h5>
                </div>
                <div class="right-cont">
                    <a href="javascript:;" class="top-img"><img src="/store/images/img12.jpg" alt=""></a>
                    <div class="img-box">
                        <c:forEach var="good" items="${hotCategoriesGood.goods}">
                            <a href="/store/details?goodId=${good.goodId}"><img src="/store/images/${good.goodPicture}"></a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%@include file="foot.jsp"%>
<script type="text/javascript">
    layui.use(['carousel', 'element', 'layer', 'jquery'], function(){
        var carousel = layui.carousel,
            element = layui.element,
            layer = layui.layer,
            $ = layui.jquery;

        var option = {
            elem: '#test1'
            ,width: '100%' //设置容器宽度
            ,arrow: 'always'
            ,height:'298'
            ,indicator:'none'
        }
        carousel.render(option);

        <c:if test="${requestScope.notice != null}">
        layer.open({
            type: 1
            ,skin: 'layer'
            ,title: '${requestScope.notice.noticeTitle}' //不显示标题栏
            ,closeBtn: false
            ,time: 5000
            ,area: '400px;'
            ,shade: 0.6
            ,btn: '关闭'
            ,btnAlign: 'c'
            ,content: '<div style="word-break:break-all;padding: 50px; line-height: 22px; color: #747474; font-weight: 300;">${requestScope.notice.noticeContent}</div>'
        });
        </c:if>
    });
</script>
</body>
</html>