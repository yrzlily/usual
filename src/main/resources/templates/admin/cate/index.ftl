<@override name="title"></@override>
<@override name="head">
<style>

</style>
</@override>
<@override name="body">
<div class="layui-fluid">
    <div class="layui-breadcrumb" style="margin: 10px 0;">
        <a href="/admin/cate/index">分类</a>
        <#list cateInfo as c>
        <span lay-separator="">/</span>
        <a href="/admin/cate/index?parentId=${c.id}">${c.name}</a>
        </#list>
    </div>
    <div class="layui-inline">
        <button class="layui-btn" id="add">添加</button>
    </div>
    <table class="layui-hide" id="table" lay-filter="table"></table>
</div>
</@override>
<@override name="script">
<script type="text/html" id="topTool">

</script>
<script type="text/html" id="tool">
    <a href="?parentId={{d.id}}" class="layui-btn layui-btn-xs layui-btn-primary">进入</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use(['table','jquery'], function() {
        var table = layui.table,
                $ = layui.jquery;

        //第一个实例
        table.render({
            elem: '#table'
            , height: 'auto'
            , url: 'index'
            , method: 'post'
            , where:{
                parentId:${parentId}
            }
            , id: 'table'
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true}
                , {field: 'name', title: '标题名称', width: 120}
                , {field: 'sort', title: '排序', width: 100 , sort: true}
                , {width: 170, align: 'center', toolbar: '#tool'}
            ]]
        });

        table.on('tool(table)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'detail'){ //查看
                //do somehing
            } else if(layEvent === 'del'){ //删除
                layer.confirm('真的删除行么', function(index){

                    $.ajax({
                        url:'del/'+obj.data.id,
                        type:'get',
                        success:function (data) {

                        }
                    });

                    obj.del();
                    layer.close(index);

                });
            } else if(layEvent === 'edit'){ //编辑
                layer.open({
                    type: 2,
                    area: ['600px', '400px'],
                    shadeClose: true,
                    content: 'edit/'+obj.data.id,
                    end:function () {
                        table.reload('table');
                    }
                });
            }
        });

        $(document).on('click','#add',function () {
            layer.open({
                type: 2,
                area: ['600px', '400px'],
                title:'添加',
                shadeClose: true,
                content: 'add?parentId=${parentId}',
                end:function () {
                    table.reload('table');
                }
            });
        });

    });
</script>
</@override>
<@extends name="/admin/common/base.ftl" />