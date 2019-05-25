layui.use(['form'], function () {

    var $ = layui.jquery;
    var form = layui.form,
        layer = layui.layer;

    //监听提交
    form.on('submit(login)', function (data) {
        var field = data.field;
        var username = field.username;
        var password = field.password;
        if(username == "" || username == null) {
            $("#msgTxt").html("用户名不能为空");
            return false;
        }
        if(username.length < 5 || username.length > 24) {
            $("#msgTxt").html("用户名为5~24位字符");
            return false;
        }
        if(password == "" || password == null) {
            $("#msgTxt").html("密码不能为空");
            return false;
        }
        if(password.length < 6 || password.length > 24) {
            $("#msgTxt").html("密码为6~24位字符");
            return false;
        }
        return true;
    });
});