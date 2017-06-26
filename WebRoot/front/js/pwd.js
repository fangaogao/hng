
$(document).ready(function(){
    $("#updatePasswordBtn").click(function (){

		//$("form").submit();
		var ordpassword = $("#oldPwd").val();
		var password = $("#password").val();
		var newPwd1 = $("#newPwd1").val();
		if(ordpassword==null || $.trim(ordpassword)==""){
			windows_open(1,"原始密码不能为空");
			return;
		}

		if(password==null || $.trim(password)==""){
			windows_open(1,"新密码不能为空");
			return;
		}
		if(password==ordpassword){
			windows_open(1,"新密码不能和原始密码一致");
			return;
		}
		if(!validatPwd(password)){
			windows_open(1,"密码为6-16个字母、数字或标点符号，区分大小写");
			return;
		}
		if(newPwd1==null || $.trim(newPwd1)==""){
			windows_open(1,"请确认新密码");
			return;
		}
		if(!validatPwd(newPwd1)){
			windows_open(1,"密码为6-16个字母、数字或标点符号，区分大小写");
			return;
		}
		if(newPwd1!=password){
			windows_open(1,"两次输入的密码不一致");
			return;
		}

        if(!eqPwd(ordpassword)){
            windows_open(1,"原始密码不正确");
            return;
        }
		
    	var obj = $("#iforms").serializeArray();
    	$.ajax({
			type: "POST",
			url: webUrl+"person/updatePwd",
			dataType : "json",
			data:obj,
			success: function(result){
				if(result.msg==1){
					alert("恭喜您，修改成功");
					window.location.reload();
				}else{
					alert("修改失败!");
				}
			}
		}); 
	});
});

function eqPwd(ordpassword){
	var bool = false;
	$.ajax({
		type : "post",
		async : false,
		url : webUrl+"person/eqpwd",
		data :{
			password : ordpassword,
			hnUserId : $("#hnUserId").val()
			
		},
		dataType : "json",
		success : function(result) {
			if(result.msg)
				bool = true;
		}
	});
	return bool;
}

function validatPwd(newpass){
	var patrn=/^([a-zA-Z0-9]|[._]){6,16}$/;
	if (!patrn.test(newpass)){
		return false;
	}
	return true;
}