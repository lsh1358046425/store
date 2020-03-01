<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="/store/css/font.css">
    <link rel="stylesheet" href="/store/css/xadmin.css">
    <script src="/store/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/store/js/xadmin.js"></script>
</head>

<body>
<div class="x-nav">
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-input-inline layui-show-xs-block">
                            <input class="layui-input" placeholder="开始日" name="start" id="start"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <input class="layui-input" placeholder="截止日" name="end" id="end"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <input type="text" name="keyword" placeholder="请输入订单号" autocomplete="off" class="layui-input"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                <i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-body ">
                    <script type="text/html" id="bar">
                        <a title="详情" lay-event="detail">
                            <i class="layui-icon">&#xe60a;</i>
                        </a>
                    </script>
                    <script type="text/html" id="orderStatus">
                        {{#  if(d.orderStatus == 0){ }}
                        未发货
                        {{# } else if(d.orderStatus == 1) { }}
                        已发货
                        {{# } }}
                    </script>
                    <table class="layui-table layui-form" id="orderTable" lay-filter="orderTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    layui.use(['form', 'table', 'laydate'], function() {
        var form = layui.form,
            table = layui.table,
            laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });

        //执行一个 table 实例
        table.render({
            elem: '#orderTable'
            ,url: '/store/admin/getOrderByPage' //数据接口
            ,title: '商品表'
            ,page: true //开启分页
            ,limit: 10
            ,limits: [3,5,10]
            ,cols: [[
                {field: 'orderId', title: '订单编号', sort: true}
                ,{field: 'userName', title: '用户名'}
                ,{field: 'orderAmount', title: '金额', sort: true}
                ,{templet:'#orderStatus', title: '订单状态'}
                ,{field: 'orderDate', title: '下单时间', sort: true}
                ,{field: 'orderAddress',title: '收货地址'}
                ,{fixed: 'right', title: '操作', align:'center', width: 100, toolbar: '#bar'}
            ]]
        });

        table.on('tool(orderTable)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'detail') {
                layer.open({
                    type: 2,
                    area: ["70%", "70%"],
                    fix: false, //不固定
                    maxmin: true,
                    shadeClose: true,
                    shade:0.4,
                    title: "订单详情",
                    content: '/store/admin/orderDetail?orderId=' +  data.orderId,
                });
            }
        });

        //搜索
        form.on('submit(sreach)', function(obj) {
            var data = obj.field;
            var start = new Date(data.start.replace(/-/,"/"));
            var end = new Date(data.end.replace(/-/,"/"));

            table.reload('orderTable', {
                where: {
                    //设定异步数据接口的额外参数
                    keyword: data.keyword,
                    start: start,
                    end: end
                },
                page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
            return false;
        });
    });
</script>
</html>