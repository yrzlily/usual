<@override name="title"></@override>
<@override name="head">

</@override>
<@override name="body">
    <div class="layui-fluid">
        <div class="layui-breadcrumb" style="margin: 10px 0;">
            <a href="/admin/cate/index">帖子管理</a>
        </div>
        <form class="layui-form layui-inline">
            <div class="layui-inline">
                <input type="number" name="id"  placeholder="请输入帖子id" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-inline">
                <input type="text" name="content"  placeholder="请输入内容" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-inline">
                <select name="status" lay-verify="required">
                    <option value="">状态</option>
                    <option value="0">未审核</option>
                    <option value="1">已审核</option>
                    <option value="2">举报</option>
                </select>
            </div>
            <div class="layui-inline">
                <button type="button" id="search" class="layui-btn">搜索</button>
            </div>
        </form>
        <table class="layui-hide" id="table" lay-filter="table"></table>
    </div>
</@override>
<@override name="script">
    <script type="text/html" id="classify">
        <a>{{d.classify.name}}</a>
    </script>
    <script type="text/html" id="user">
        <a>{{d.user.nickname}}</a>
    </script>
    <script type="text/html" id="status">
        {{# if(d.status == 0){ }}
        未审核
        {{# }else if(d.status == 1){ }}
        审核通过
        {{# }else if(d.status == 2){ }}
        被举报
        {{# } }}
    </script>
    <script type="text/html" id="tool">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script>
        layui.use(['table','jquery'], function() {
            var table = layui.table,
                $ = layui.jquery;
            //第一个实例
            var tableIns = table.render({
                elem: '#table'
                , height: 'auto'
                , url: 'list'
                , method: 'post'
                , id: 'table'
                , page: true //开启分页
                , cols: [[ //表头
                    {field: 'id', title: 'ID', width: 80, sort: true}
                    , {field: 'user', title: '发布者', width: 120, templet:'#user'}
                    , {field: 'classify', title: '分类名称', width: 120, templet:'#classify'}
                    , {field: 'content', title: '内容', width: 200, sort: true}
                    , {field: 'status', title: '状态', width: 120, templet:'#status'}
                    , {field: 'create_time', title: '创建时间', width: 180, sort: true}
                    , {width: 170, align: 'center', toolbar: '#tool'}
                ]]
            });

            //监听工具条
            table.on('tool(table)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象
                if(layEvent === 'detail'){ //查看
                    //do somehing
                } else if(layEvent === 'del'){ //删除
                    layer.confirm('真的删除行么', function(index){
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        $.ajax({
                            url:'delete',
                            data:{
                                id:obj.data.id
                            },
                            type: 'post',
                            success:function (data) {
                                
                            }
                            
                        });
                    });
                }
            });


            //额外事件
            $(document).on('click' , '#search' , function () {
                tableIns.reload({
                    where: {
                        id: $('[name="id"]').val(),
                        status: $('[name="status"]').val(),
                        content: $('[name="content"]').val()
                    }
                });
            });

        });
    </script>
</@override>
<@extends name="/admin/common/base.ftl" />