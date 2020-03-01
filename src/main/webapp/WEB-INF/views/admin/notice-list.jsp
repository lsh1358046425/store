<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>公告列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="/store/css/font.css">
    <link rel="stylesheet" href="/store/css/xadmin.css">
    <script src="/store/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/store/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                    <div class="layui-input-inline layui-show-xs-block">
                        <button class="layui-btn" id="addNotice"><i class="layui-icon"></i>增加</button>
                    </div>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form" id="noticeTable" lay-filter="noticeTable"></table>
                    <script type="text/html" id="bar">
                        <a title="编辑"  lay-event="edit">
                            <i class="layui-icon">&#xe642;</i>
                        </a>
                        <a title="删除" lay-event="del">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </script>
                    <script type="text/html" id="statusCheckbox">
                        {{#  if(d.noticeStatus){ }}
                        <input type="checkbox" value="{{ d.noticeId }}" lay-filter="noticeStatus" lay-skin="switch" lay-text="发布|未发布" checked>
                        {{# } else { }}
                        <input type="checkbox" value="{{ d.noticeId }}" lay-filter="noticeStatus" lay-skin="switch" lay-text="发布|未发布">
                        {{# } }}
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    layui.use(['form', 'jquery', 'table'], function(){
        var form = layui.form,
            $ = layui.jquery,
            table = layui.table;

        //执行一个 table 实例
        table.render({
            elem: '#noticeTable'
            ,url: '/store/admin/getNoticeByPage' //数据接口
            ,title: '分类表'
            ,page: true //开启分页
            ,limit: 10
            ,limits: [3,5,10]
            ,cols: [[
                {field: 'noticeId', title: 'ID', sort: true, width: 80, fixed: 'left'}
                ,{field: 'noticeTitle', title: '标题'}
                ,{field: 'noticeContent', title: '内容'}
                ,{field: 'noticeTime', title: '时间'}
                ,{field: 'noticeStatus', title: '状态', templet:'#statusCheckbox'}
                ,{fixed: 'right', title: '操作', align:'center', width: 100, toolbar: '#bar'}
            ]]
        });

        // 监听状态
        form.on('switch(noticeStatus)', function(data){
            var noticeStatus = data.elem.checked
            var noticeId = data.value

            $.ajax({
                type: "GET",
                url: "/store/admin/noticeStatusUpdate?noticeId=" + noticeId + "&noticeStatus=" + noticeStatus,
                success: function(data){
                    if (data.status) {
                        layer.msg(data.msg, {icon: 1, time: 1000});
                        $(".layui-laypage-btn").click();
                    }else {
                        layer.msg(data.msg, {icon: 5, time: 1000});
                    }
                },
                error: function () {
                    layer.msg("发布失败", {icon: 5, time: 1000});
                }
            })
            return false;
        });

        //增加
        $('#addNotice').click(function () {
            layer.open({
                type: 2,
                area: ["50%", "50%"],
                fix: false, //不固定
                maxmin: true,
                shadeClose: true,
                shade:0.4,
                title: "添加公告",
                content: '/store/admin/toNoticeAdd',
                end: function () {
                    $(".layui-laypage-btn").click();
                }
            });
        })

        //监听行工具事件
        table.on('tool(noticeTable)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'del'){
                layer.confirm('确定删除公告', function(index){
                    //向服务端发送删除指令
                    $.ajax({
                        type: "GET",
                        url: "/store/admin/deleteNotice?noticeId=" + data.noticeId,
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
                    area: ["50%", "50%"],
                    fix: false, //不固定
                    maxmin: true,
                    shadeClose: true,
                    shade:0.4,
                    title: "编辑公告",
                    content: '/store/admin/toNoticeEdit?noticeId=' +  data.noticeId,
                    end: function () {
                        $(".layui-laypage-btn").click();
                    }
                });
            }
        });
    });
</script>
</body>
</html>
