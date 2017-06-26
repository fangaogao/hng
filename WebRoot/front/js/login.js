// JavaScript Document
$(document).ready(function(){
	//set mainNav hover event
	
	$(function(){
		$("#forget-check").click(function(){

			if($("#forget-check").hasClass('cur')){
				$("#forget-check").removeClass('cur');
			}else{
				$("#forget-check").addClass('cur');
			}
		});		
	})
	
});

var webUrl = $("#webUrl").val();
var remberAccount = $("#isRemberPwd").val();
var art;
$(document).ready(function(){
    var returnUrl = $("#returnUrl").val();
    var type = $("#type").val();
    function setCookie(ssoUrl) {
        $.ajax({
            type : "get",
            async : false,
            url : ssoUrl,
            dataType : "jsonp",//数据类型为jsonp
            jsonp : "jsonpCallback",//服务端用于接收callback调用的function名的参数
            success : function(result) {
                //$.unblockUI();
                if (returnUrl == null || "" == returnUrl) {
                    //默认
                    window.location.href = $("#homeWebUrl").val();
                } else {
                    window.location.href = decodeURIComponent(returnUrl);
                }
            }
        });
    }
    if (type == "logout") {
        $.ajax({
            type : "get",
            async : false,
            url : $("#ssoexitUrl").val(),
            dataType : "jsonp",//数据类型为jsonp
            jsonp : "jsonpCallback",//服务端用于接收callback调用的function名的参数
            success : function(result) {

            }
        });

        $.ajax({
            type : "get",
            async : false,
            url : webUrl+'myinfo/localcookie',
            data : {
                f:'r'
            },
            dataType : "json",//数据类型为jsonp
            success : function(result) {

            }
        });
    }

    function checkLogin(form){
    	var account = $("#userAccount").val();
        if(account == "邮箱/用户名"){
            $("#userAccount").focus();
            return false;
        }
        if($("#forget-check").attr("class")==="cur"){
            $("#isRememberPwd").val("y");
        } else {
            $("#isRememberPwd").val("");
        }
        return true;
       
    }
//    $("#userlogin").click(function(){
//        var account = $("#userAccount").val();
//        if(account == "邮箱/手机号/用户名"){
//            $("#userAccount").focus();
//        }
//        if($("#forget-check").attr("class")==="cur"){
//            $("#isRememberPwd").val("y");
//        } else {
//            $("#isRememberPwd").val("");
//        }
//        alert($("form").action);
//        $("form").submit();
//    });

    function login(){
        $.ajax({
            type: "POST",
            url: webUrl+"myinfo/login",
            data: $("form").formSerialize(),
            dataType:"json",
            success: function(result){
                if(result != null) {
                    if(parseInt(result.failCount) >= 2) {
                        $("#liValiCode").css("display","block");
                        $("#imgValidate").attr("src",webUrl+"validateCode/randCode?time="+new Date());
                        $("#valCode").rules("add",{required:true,trim:true,minlength:4,maxlength:4,messages:{required:'验证码不能为空'}});
                    }
                    if(result.status == 2){
                        $("#userAccountv").html("您的账号因异常行为已经被禁用，请联系客服");
                        return;
                    }
                    if(result.status == 3){
                        $("#userAccountv").html("您的账号因安全问题已被锁定,请在24小时候再尝试登陆");
                        return;
                    }
                    if(result.status == 4){
                        $("#userAccountv").html("您的账号存在异常,暂时无法登陆,请联系客服");
                        return;
                    }
                    if(result.status == 5){
                        $("#userAccountv").html("请使用第三方关联账号登陆");
                        return;
                    }
                    if(result.errorAccount == "1") {
                        $("#valCode").val("");
                        $("#passwordv").html("验证码错误");
                        return;
                    } else if(result.errorAccount == "2") {
                        $("#userAccountv").html("错误登录5次，10分钟内禁止登录!");
                        return;
                    } else if(result.errorAccount == "3") {
                        $("#passwordv").html("密码错误");
                        return;
                    } else if(result.errorAccount == "4") {
                        $("#userAccountv").html("用户名不存在！");
                        return
                    } else if(result.errorAccount == "5") {
                        alert("系统异常！");
                    } else{
                        setCookie(result.ssoUrls[0]);
                    }
                }
            }
        });
    }

    $("#userAccount").focus(function(){
        $("#userAccountv").html("");
        $(".userinput").css('border-color','#f47a11');
    });

    $("#userAccount").blur(function (){
        $(".userinput").css('border-color','#ccc');
    });

    $("#password").focus(function(){
        $("#passwordv").html("");
        $(".passwordinput").css('border-color','#f47a11');
    });

    $("#password").blur(function (){
        $(".passwordinput").css('border-color','#ccc');
    });

    if(remberAccount!=0 && remberAccount==1){
        $("#userAccount").val($("#remberUserAccount").val());
        $("#forget-check").attr("class","cur");
    }

    $("#img").click( function () {
        $("#imgValidate").attr("src",webUrl+"validateCode/randCode?time="+new Date());
    });

    $.metadata.setType("attr", "validate");
    $("form").validate({
        errorPlacement: function (lable, element) {
            $("#" + element.attr("id") + "v").html(lable.html());
        },
        success: function (lable) {
            $("#" + lable.attr("for") + "v").html("");
        },
        submitHandler: function (from) {
            login();
        }
    });

    $("form").keydown(function (event) {
        if(event.keyCode==13) $("form").submit();
    });
});

jQuery.validator.addMethod("valCode", function(value, element) {
    var bool = true
    $.ajax({
        type : "post",
        async : false,
        url : webUrl+"myinfo/getValCode",
        dataType : "json",
        success : function(result) {
            if(result.code != value)
                bool = false;
        }
    });
    return bool;
}, "验证码错误");


jQuery.validator.addMethod("trim", function(value, element) {
    $(element).val(IgnoreSpaces(value));
    return true;
}, "不能包含空格");

function IgnoreSpaces(Str){
    var ResultStr = "";
    Temp=Str.split(" "); //双引号之间是个空格；
    for(var i = 0; i < Temp.length; i++)
        ResultStr +=Temp[i];
    return ResultStr;
}