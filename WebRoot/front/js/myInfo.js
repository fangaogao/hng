/*
 * 验证个人信息页面信息
 * */
var webUrl = $("#webUrl").val();
$(document).ready(function () {
    //初始化省
    getProvice(1);

    //设置默认
    var proviceId = $("#proviceCode").val();
    var cityId = $("#cityCode").val();
    var areaId = $("#areaCode").val();
    setDefaultValue(proviceId, cityId, areaId);

    $.metadata.setType("attr", "validate");
    $("form").validate({
        groups:{
            pca:"province city area"
        },
        errorPlacement: function (lable, element) {
            if(element.attr("name")=="province"||element.attr("name")=="city"||element.attr("name")=="area"){
                $("#pcav").prev().prev(".reg-ico-1").css("display", "none");
                $("#pcav").prev().css("display", "block");
                $("#pcav").html(lable.html());
            }
            $("#" + element.attr("id") + "v").prev().prev(".reg-ico-1").css("display", "none");
            $("#" + element.attr("id") + "v").prev().css("display", "block");
            $("#" + element.attr("id") + "v").html(lable.html());
        },
        //一条信息通过验证后,去掉错误信息标识(回调函数只有一个参数)
        success: function (lable) {
            var element = $("#" + lable.attr("for"));
            //内容不为空时，显示正确的符号
            if (!element.val() == "") {
                $("#" + lable.attr("for") + "v").prev(".reg-ico-2").css("display", "none");
                $("#" + lable.attr("for") + "v").prev(".reg-ico-2").prev(".reg-ico-1").css("display", "block");
            }else{
                $("#" + lable.attr("for") + "v").prev(".reg-ico-2").css("display", "none");
            }

        },
        submitHandler: function (from) {
            //from.submit();
        },

        rules: {
            userName: {
                required: true,
                isUserName: true
            },
            realName: {
                required: true,
                isRealName: true
            },
            qq: {
                isqq: true
            },
            email: {
                email: true
            },
            mobile: {
                required:true,
                isMobile: true
            },
            phone:{
                isPhone:true
            },
            fax:{
                isFax:true
            },
            province: {required: true},
            city: {required: true},
            area: {required: true}
        },
        messages: {
            userName: {
                required: "用户名不能为空！"
            },
            realName: {
                required: "真实姓名不能为空！"
            },
            email: {
                email: "请输入正确格式的邮箱！"
            },
            mobile:{required: "手机号码不能为空！"},
            province: {required: "省不能为空！"},
            city: {required: "市不能为空！"},
            area: {required: "区不能为空！"}
        }

    });

    $(".submit").click(function () {

        var obj = $("#forms").serializeArray();
        $.ajax({
            type: "POST",
            url: webUrl + "person/updateInfo",
            dataType: "json",
            data: obj,
            success: function (result) {
                if (result.msg == 1) {
                    alert("恭喜您，修改成功");
                    var thisIframe = $(window.parent.document).find("#content-iframe");
                    var src = thisIframe.attr("src");
                    thisIframe.attr("src", src);
                } else {
                    alert("修改失败!");
                }
            }
        });

        //$("form").submit();
    });
});

$.validator.addMethod("isUserName", function (value) {
    var regPartton = /^[\u4E00-\u9FA5A-Za-z0-9_]+$/;
    if (!lengthCN(value, 4, 20) || !regPartton.test(value)) {
        return false;
    }
    return true;
}, "用户名必须由2-10个中文字符或4-20个英文字符或下划线_组成！");

$.validator.addMethod("isRealName", function (value) {
    var regPartton = /^[\u4E00-\u9FA5]+$/;
    if (!lengthCN(value, 4, 20) || !regPartton.test(value)) {
        return false;
    }
    return true;
}, "真实姓名必须由2-10个中文字符组成！");

$.validator.addMethod("isqq", function (value) {
    var regPartton = /^[1-9]\d{5,14}$/;
    if (value == "" || parseInt(value) == 0) {
        return true;
    }
    if (!regPartton.test(value)) {
        return false;
    }
    return true;
}, "请输入正确格式的qq！");

$.validator.addMethod("isMobile", function (value) {
    return isNumber(value);
}, "请输入正确格式的手机号码！");

$.validator.addMethod("isPhone", function (value) {
    return isNumber(value);
}, "请输入正确格式的固定电话(加区号)！");

$.validator.addMethod("isFax", function (value) {
    return isNumber(value);
}, "请输入正确格式的传真号码(加区号)！");


//检验号码
function isNumber(value) {
    var regPartton = /^[1-11]\d{11}$/;
    if (value == "" ||parseInt(value) == 0) {
        return true;
    }
    if (!regPartton.test(value)) {
        return false;
    }
    return true;
}
//限制中英混合字符串长度在一定范围内
function lengthCN(str, minLength, maxLength) {
    var len = 0;
    for (var i = 0; i < str.length; i++) {
        var c = str.charCodeAt(i);
        //单字节加1（英文单字节，中文双字节）
        if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
            len++;
        }
        else {
            len += 2;
        }
    }
    if (len >= minLength && len <= maxLength) {
        return true;
    } else {
        return false;
    }
}

//点击省触发市事件 */
$("#proviceId").change(function () {
    getCity();
});
//点击市触发区事件
$("#cityId").change(function () {
    getArea();
});

function getProvice(lev) {
    var html = "<option value=''>待选择</option>";
    var _data = {level: lev};
    $.ajax({
        type: "post",
        async: false,
        url: webUrl + "area/getAreaByLevel",
        data: _data,
        dataType: "json",
        success: function (data) {
            if (data != 0) {
                var temp = eval(data);
                for (var i = 0; i < temp.length; i++) {
                    html += "<option value='" + temp[i].id + "'>" + temp[i].areaName + "</option>";
                }
                $("#proviceId").html(html);
            }
        }
    });
}

function getCity() {
    var parentId = $("#proviceId option:selected").val();
    if (parentId == "") {
        $("#cityId option").remove();
        $("#cityId").append("<option value=''>待选择</option>");
        return false;
    }
    var html = "<option value=''>待选择</option>";
    var _data = {parentId: parentId};
    $.ajax({
        type: "post",
        async: false,
        url: webUrl + "area/getChildArea",
        data: _data,
        dataType: "json",
        success: function (data) {
            if (data != 0) {
                var temp = eval(data);
                for (var i = 0; i < temp.length; i++) {
                    html += "<option value='" + temp[i].id + "'>" + temp[i].areaName + "</option>";
                }
            }
            $("#cityId option").remove();
            $("#areaId option").html("<option value=''>待选择</option>");
            $("#cityId").html(html);
        }
    });


}
function getArea() {
    var parentId = $("#cityId option:selected").val();
    if (parentId == "") {
        $("#areaId option").remove();
        $("#areaId").append("<option value=''>待选择</option>");
        return false;
    }
    var html = "<option value=''>待选择</option>";
    var _data = {parentId: parentId};
    $.ajax({
        type: "post",
        async: false,
        url: webUrl + "area/getChildArea",
        data: _data,
        dataType: "json",
        success: function (data) {
            if (data != 0) {
                $("#areaId").show();
                var temp = eval(data);
                for (var i = 0; i < temp.length; i++) {
                    html += "<option value='" + temp[i].id + "'>" + temp[i].areaName + "</option>";
                }
            } else {
                $("#areaId").hide();
            }
            $("#areaId option").remove();
            $("#areaId").html(html);
        }
    });

}

function setDefaultValue(proviceId, cityId, areaId) {
    $("#proviceId option[value='" + proviceId + "'] ").attr("selected", true);
    getCity();
    $("#cityId option[value='" + cityId + "'] ").attr("selected", true);
    getArea();
    $("#areaId option[value='" + areaId + "'] ").attr("selected", true);

}