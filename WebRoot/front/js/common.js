function show(type) {
	window.document.getElementById("mainPane").style.visibility = type;
	window.document.getElementById("msg").style.visibility = type;
}
function doSubmit(formName) {
	window.document.forms[formName].submit();
}
function refreshCode() {
	var refreshIndex = Math.random();
	window.document.getElementById("imgCode").src = "/DangDang/enter/code.action?"
			+ refreshIndex;
	window.document.getElementById("code").value = "";
	$(".errorinfo").html("");
}

//验证登录
function vL() {
	if ($("#uid").val() == "") {
		$(".errorinfo").html("用户名不能为空");
		return false;
	}
	if ($("#pwd").val()=="") {
		$(".errorinfo").html("密码不能为空");
		return false;
	}
	if ($("#code").val()=="") {
		$(".errorinfo").html("验证码不能为空");
		return false;
	}
	if ($(".errorinfo").html() == "输入的验证码不正确") 
		return false;
	return true;
}
function validateLogin() {
	if(vL())
		doSubmit('loginForm');
}

function doHref(url) {
	window.location.href = url;
}


function myFloatParse(val) {

	var ret = parseFloat(val);

	if (isNaN(ret))
		return 0.0;

	return ret;
}
//图片错误时
function err() {
		$("#photo").attr("src", "img/heads/img_big.bmp");

}