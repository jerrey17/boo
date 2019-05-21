layui.use(['form'], function () {
    var $ = layui.jquery;
    var form = layui.form,
        layer = layui.layer;

    //自定义验证规则
    form.verify({
        pwd: [
            /^[\S]{6,12}$/,
            '密码必须6~12位，且不能出现空格'
        ]
    });

    //监听提交
    form.on('submit(login)', function (data) {
        
        layer.alert(JSON.stringify(data.field), {
            title: '最终的提交信息'
        })
        return false;
    });
});