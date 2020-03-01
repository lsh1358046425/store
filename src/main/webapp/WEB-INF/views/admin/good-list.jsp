<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="/store/css/font.css">
    <link rel="stylesheet" href="/store/css/xadmin.css">
    <script src="/store/lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .layui-table-cell{height:28px;line-height:28px;padding:0 15px;position:relative;box-sizing:border-box;height:auto!important;white-space:normal}
        .layui-table-cell .layui-form-checkbox[lay-skin=primary]{top:0;padding:0;transform: translateY(0);}
    </style>
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
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="keyword"  placeholder="请输入商品名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">
                    <button class="layui-btn layui-btn-danger" onclick="delChecked()"><i class="layui-icon"></i>批量删除</button>
                    <button class="layui-btn" onclick="toAddGood()"><i class="layui-icon"></i>添加</button>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form" id="goodTable" lay-filter="goodTable"></table>
                    <script type="text/html" id="bar">
                        <a title="编辑"  lay-event="edit">
                            <i class="layui-icon">&#xe642;</i>
                        </a>
                        <a title="删除" lay-event="del">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </script>
                    <script type="text/html" id="goodImg">
                        <img src="/store/images/{{ d.goodPicture }}" height="100">
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    layui.use(['table', 'jquery', 'form'], function(){
        var table = layui.table,
            $ = layui.jquery,
            form = layui.form;

        //执行一个 table 实例
        table.render({
            elem: '#goodTable'
            ,url: '/store/admin/getGoodByPage' //数据接口
            ,title: '商品表'
            ,page: true //开启分页
            ,limit: 10
            ,limits: [3,5,10]
            ,cols: [[
                {type: 'checkbox', align:'center', width: 50}
                ,{field: 'goodId', title: 'ID', sort: true, width: 80}
                ,{field: 'goodName', title: '商品'}
                ,{field: 'goodPrice', title: '价格', sort: true}
                ,{field: 'goodPicture', title: '图片', templet:'#goodImg'}
                ,{field: 'categoryName', title: '分类', sort: true}
                ,{title: '操作', align:'center', width: 100, toolbar: '#bar'}
            ]]
        });

        //监听行工具事件
        table.on('tool(goodTable)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'del'){
                layer.confirm('确定删除商品', function(index){
                    //向服务端发送删除指令
                    $.ajax({
                        type: "GET",
                        url: "/store/admin/deleteGood?goodId=" + data.goodId,
                        success: function(data){
                            if (data.status) {
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.close(index);
                                layer.msg(data.msg, {icon: 1, time: 1000});
                            }else {
                                layer.close(index);
                                layer.msg(data.msg, {icon: 5, time: 1000});
                            }
                        },
                        error: function () {
                            layer.close(index);
                            layer.msg("删除失败", {icon: 5, time: 1000});
                        }
                    });
                });
            } else if(layEvent === 'edit'){
                layer.open({
                    type: 2,
                    area: ["70%", "70%"],
                    fix: false, //不固定
                    maxmin: true,
                    shadeClose: true,
                    shade:0.4,
                    title: "编辑商品",
                    content: '/store/admin/toGoodEdit?goodId=' +  data.goodId,
                    end: function () {
                        $(".layui-laypage-btn").click();
                    }
                });
            }
        });

        window.toAddGood = function(){
            layer.open({
                type: 2,
                area: ["70%", "70%"],
                fix: false, //不固定
                maxmin: true,
                shadeClose: true,
                shade:0.4,
                title: "添加商品",
                content: '/store/admin/toGoodAdd',
                end: function () {
                    $(".layui-laypage-btn").click();
                }
            });
        };

        //搜索
        form.on('submit(sreach)', function(obj) {
            var data = obj.field;

            table.reload('goodTable', {
                where: {
                    //设定异步数据接口的额外参数
                    keyword: data.keyword
                },
                page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
            return false;
        })

        //删除选中
        window.delChecked = function() {
            var data = table.checkStatus('goodTable').data,
                delList=[];

            data.forEach(function(obj, index){
                delList.push(obj.goodId);
            });

            layer.confirm('确认要删除吗', function(index){
                $.ajax({
                    type: "POST",
                    url: "/store/admin/deleteGoods",
                    contentType: "application/json;charset=utf-8",
                    data: JSON.stringify(delList),
                    success: function(data){
                        if (data.status) {
                            $(".layui-form-checked").not('.header').parents('tr').remove();
                            layer.close(index);
                            layer.msg(data.msg, {icon: 1, time: 1000});
                        }else {
                            layer.close(index);
                            layer.msg(data.msg, {icon: 5, time: 1000});
                        }
                    },
                    error: function () {
                        layer.close(index);
                        layer.msg("删除失败", {icon: 5, time: 1000});
                    }
                });
            });
        }
    });
</script>
</html>