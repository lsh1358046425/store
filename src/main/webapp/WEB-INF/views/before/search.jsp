<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="head.jsp"%>

<div class="content content-nav-base commodity-content">
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
    <div class="commod-cont-wrap">
        <div class="commod-cont w1200 layui-clear">
            <div class="left-nav">
                <div class="title">所有分类</div>
                <div class="list-box">
                    <dl>
                        <dt>展开</dt>
                        <c:forEach items="${requestScope.categories}" var="category">
                        <dd><a href="/store/category?categoryId=${category.categoryId}">${category.categoryName}</a></dd>
                        </c:forEach>
                    </dl>
                </div>
            </div>
            <div class="right-cont-wrap">
                <div class="right-cont">
                    <div class="cont-list layui-clear" id="list-cont">
                        <c:forEach items="${requestScope.goods.list}" var="good">
                        <div class="item">
                            <div class="img">
                                <a href="/store/details?goodId=${good.goodId}">
                                    <img src="/store/images/${good.goodPicture}" width="280" height="280">
                                </a>
                            </div>
                            <div class="text">
                                <p class="title">${good.goodName}</p>
                                <p class="price">
                                    <span class="pri">${good.goodPrice}</span>
                                </p>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
                <style>
                    .layui-laypage a:hover {
                        color: #CEB1F3;
                    }
                    .layui-laypage .layui-laypage-curr .layui-laypage-em {
                        position: absolute;
                        left: -1px;
                        top: -1px;
                        padding: 1px;
                        width: 100%;
                        height: 100%;
                        background-color: #CEB1F3;
                    }
                </style>
                <div id="demo0" style="text-align: center;"></div>
            </div>
        </div>
    </div>
</div>
<%@include file="foot.jsp"%>
<script>
    layui.use(['laypage','jquery'], function(){
        var laypage = layui.laypage,
            $ = layui.$;

        laypage.render({
            elem: 'demo0'
            , count: ${requestScope.goods.total} //数据总数
            , limit: 9
            , curr: ${requestScope.goods.pageNum}
            , jump: function(obj, first){
                if(!first){
                     var url = '/store/search?keyword=${requestScope.keyword}&page=' + obj.curr;
                     window.location.href = url;
                }
            }
        });

        $('.sort a').on('click',function(){
            $(this).addClass('active').siblings().removeClass('active');
        })
        $('.list-box dt').on('click',function(){
            if($(this).attr('off')){
                $(this).removeClass('active').siblings('dd').show()
                $(this).attr('off','')
            }else{
                $(this).addClass('active').siblings('dd').hide()
                $(this).attr('off',true)
            }
        })

    });
</script>


</body>
</html>