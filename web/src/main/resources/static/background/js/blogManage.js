
layui.define(['laypage', 'layer', 'form', 'pagesize'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form(),
        laypage = layui.laypage;
    var laypageId = 'pageNav';


    initilData(1, 8);
    //页数据初始化
    //currentIndex：当前页面
    //pageSize：页容量（每页显示的条数）
    function initilData(currentIndex, pageSize) {
        var index = layer.load(1);
        //模拟数据加载
        setTimeout(function () {
            layer.close(index);
            $.ajax({
                url:"/admin/blogManage/list/"+currentIndex,
                type:"GET",
                data:{
                    pageSize:pageSize
                },
                success:function(blogList){
                    var html = '';
                    html += '<table style="table-layout: fixed" class="layui-table" lay-even>';
                    html += '<colgroup><col width="40"><col width="150"><col width="180"><col width="120"><col width="90"><col width="90"><col width="40"><col width="40"></colgroup>';
                    html += '<thead><tr><th>编号</th><th>博客标题</th><th>博客摘要</th><th>发布日期</th><th>所属类别</th><th>所属标签</th><th colspan="2">操作</th></tr></thead>';
                    html += '<tbody>';
                    for(var i in blogList){
                        var item=blogList[i];
                        html+='<tr>';
                        html+='<td>'+item.id+'</td>';
                        html+='<td>'+item.title+'</td>';
                        html+='<td>'+item.summary+'</td>';
                        html+='<td>'+item.publishTime+'</td>';
                        html+='<td>'+item.blogTypePO.typeName+'</td>';
                        html+='<td>'+item.blogTagPO.tagName+'</td>';
                        html+='<td><button class="layui-btn layui-btn-small layui-btn-normal"><i class="layui-icon">&#xe642;</i></button></td>';
                        html+='<td><button class="layui-btn layui-btn-small layui-btn-danger"><i class="layui-icon">&#xe640;</i></button></td>';
                        html+='</tr>';
                    }
                    html+='</tbody></table>';
                    $('#dataContent').html(html);

                }
            });

            form.render('checkbox');  //重新渲染CheckBox，编辑和添加的时候
            $('#dataConsole,#dataList').attr('style', 'display:block'); //显示FiledBox
            laypage({
                cont: laypageId,
                pages: blogNum/pageSize==0?blogNum/pageSize:blogNum/pageSize+1,
                groups: 5,
                skip: true,
                curr: currentIndex,
                jump: function (obj, first) {
                    var currentIndex = obj.curr;
                    if (!first) {
                        initilData(currentIndex, pageSize);
                    }
                }
            });
            //该模块是我定义的拓展laypage，增加置页容量功设能
            //laypageId:laypage对象的id同laypage({})里面的cont属性
            //pagesize当前页容量，用于显示当前页容量
            //callback用于设置pagesize确定按钮点击时的回掉函数，返回新的页容量
            layui.pagesize(laypageId, pageSize).callback(function (newPageSize) {
                //这里不能传当前页，，因为改变页容量后当前页很可能没有数据
                initilData(1, newPageSize);
            });

        }, 500);
    }


    //添加数据
    $('#addArticle').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            layer.msg('打开添加窗口');
        }, 500);
    });

    //输出接口，主要是两个函数，一个删除一个编辑
    var datalist = {
        deleteData: function (id) {
            layer.confirm('确定删除？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                layer.msg('删除Id为【' + id + '】的数据');
            }, function () {

            });
        },
        editData: function (id) {
            layer.msg('编辑Id为【' + id + '】的数据');
        }
    };


    exports('datalist', datalist);
});