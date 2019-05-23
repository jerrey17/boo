layui.use('element', function () {

    var $ = layui.jquery;
    var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

    var show = true;
    $('#animation-left-nav').click(function(){
        if (show) {
            $(".layui-side").animate({width : 'toggle'});
            $(".layui-body").animate({left : '0px'});
            $(".layui-footer").animate({left : '0px'});

            // $('#animation-left-nav').toggleClass("layui-icon-shrink-left");
            // $('#animation-left-nav').removeClass("layui-icon-shrink-right");
            show = false;
        } else {
            $(".layui-side").animate({width : 'toggle'});
            $(".layui-body").animate({left : '200px'});
            $(".layui-footer").animate({left : '200px'});
            show = true;
        }
    });

    /**
     * 触发事件
     */
    var active = {
        tabAdd: function (url, id, name) {
            //url：tab页面的地址，对应页面标签data-url
            //id: layui-tab的唯一标识，对应页面标签data-id
            //name：tab页标题，对应页面标签data-name
            //新增Tab
            element.tabAdd('main_tab', {
                title: name,
                content: '<iframe data-frameid="' + id + '" scrolling="auto" frameborder="0" src="' + url + '" style="width:100%; height:99%;"></iframe>',
                id: id
            })
            // CustomRightClick(id); //给tab绑定右击事件
            FrameWH();  //计算ifram层的大小
        },
        tabChange: function (id) {
            //根据id切换到指定Tab项
            element.tabChange('main_tab', id);
        },
        tabDelete: function (id) {
            //根据id删除tab
            element.tabDelete("main_tab", id);
        },
        tabDeleteAll: function (ids) {
            //ids：id的数组列表
            //遍历删除所有tab
            $.each(ids, function (i, item) {
                element.tabDelete("main_tab", item);
            })
        }
    };

    /**
     * 单击事件：点击左边菜单栏
     */
    $('.menu-active').on('click', function () {
        var dataId = $(this);
        //判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
        if ($(".layui-tab-title li[lay-id]").length <= 0) {
            //如果比零小，则直接打开新的tab项
            active.tabAdd(dataId.attr("data-url"), dataId.attr("data-id"), dataId.attr("data-title"));
        } else {
            //否则判断该tab项是否已经存在
            var isOpen = false; //tab是否已经打开。false:未打开；true：已打开。
            $.each($(".layui-tab-title li[lay-id]"), function () {
                //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                if ($(this).attr("lay-id") == dataId.attr("data-id")) {
                    isOpen = true;
                }
            })
            if (isOpen == false) {
                //未打开，新增一个tab项
                active.tabAdd(dataId.attr("data-url"), dataId.attr("data-id"), dataId.attr("data-title"));
            }
        }
        //激活选中tab页。
        active.tabChange(dataId.attr("data-id"));
    });

    function FrameWH() {
        var h = $(window).height() - 41 - 10 - 60 - 10 - 44 - 10;
        $("iframe").css("height", h + "px");
    }

    $(window).resize(function () {
        FrameWH();
    })
})