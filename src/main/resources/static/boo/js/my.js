layui.use('layer', function () { //独立版的layer无需执行这一句
    var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

    //触发事件
    var active = {
        setTop: function () {
            var that = this;
            //多窗口模式，层叠置顶
            layer.open({
                type: 2 //此处以iframe举例
                , title: '当你选择该窗体时，即会在最顶端'
                , area: ['390px', '260px']
                , shade: 0
                , maxmin: true
                , offset: [ //为了演示，随机坐标
                    Math.random() * ($(window).height() - 300)
                    , Math.random() * ($(window).width() - 390)
                ]
                , content: '//layer.layui.com/test/settop.html'
                , btn: ['继续弹出', '全部关闭'] //只是为了演示
                , yes: function () {
                    $(that).click();
                }
                , btn2: function () {
                    layer.closeAll();
                }

                , zIndex: layer.zIndex //重点1
                , success: function (layero) {
                    layer.setTop(layero); //重点2
                }
            });
        }
        , offset: function (othis) {
            var type = othis.data('type')
                , text = othis.text();

            layer.open({
                type: 1
                , offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                , id: 'layerDemo' + type //防止重复弹出
                , content: '<div style="padding: 20px 100px;">' + text + '</div>'
                , btn: '关闭全部'
                , btnAlign: 'c' //按钮居中
                , shade: 0 //不显示遮罩
                , yes: function () {
                    layer.closeAll();
                }
            });
        }
    };

    $('.my').on('click', function () {
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });

});