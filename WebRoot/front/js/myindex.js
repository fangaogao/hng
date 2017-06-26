/*myindex页面的触发事件*/
$(document).ready(function(){
	var userPic = init.userPic;
	var size = "!60x60";
	var defalue = "_60x60";
	if(userPic!="" && userPic.length > 0 && userPic.indexOf(".") > 0 && userPic.indexOf("group") > 0){
		$("#userPic").prop("src",init.imgUrl+userPic.substring(0,userPic.lastIndexOf("."))+size+userPic.substring(userPic.lastIndexOf(".")));
	}else{
		$("#userPic").prop("src",init.imgUrl+userPic.substring(0,userPic.lastIndexOf("."))+defalue+userPic.substring(userPic.lastIndexOf(".")));
	}
	
	$("#replying").click(function(){
		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc6112b-d8e9-11e4-8026-40167e2206a7&state=1";
	});
 	$("#puring").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc5c991-d8e9-11e4-8026-40167e2206a7&state=1";
 	});
 	$("#waitpay").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc614db-d8e9-11e4-8026-40167e2206a7&state=0";
 	});
 	$("#waitconsignment").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc614db-d8e9-11e4-8026-40167e2206a7&state=1";
 	});
 	$("#waitconsignee").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc614db-d8e9-11e4-8026-40167e2206a7&state=2";
 	});
 	$("#backing").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc614db-d8e9-11e4-8026-40167e2206a7&backFlag=1";
 	});
 	$("#waitcomment").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc614db-d8e9-11e4-8026-40167e2206a7&state=3&commentFlag=0";
 	});
 	$("#waitquote").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc5ef7e-d8e9-11e4-8026-40167e2206a7&state=1";
 	});
 	$("#waitbuypay").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc6181b-d8e9-11e4-8026-40167e2206a7&state=0";
 	});
 	$("#waitbuyconsignment").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc6181b-d8e9-11e4-8026-40167e2206a7&state=1";
 	});
 	$("#waitbuyconsignee").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc6181b-d8e9-11e4-8026-40167e2206a7&state=2";
 	});
 	$("#evaluate").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=5fc61a6a-d8e9-11e4-8026-40167e2206a7";
 	});
 	$("#pointPic").click(function(){
 		window.parent.location.href=init.userWebUrl+"myhn/index?menuId=69f8cab3-89ce-11e5-84c4-0050569376e1";
 	});
 	
});

function cer(){
	window.parent.location.href=init.userWebUrl+"myhn/index?menuId=2d68b903-1e28-11e5-8f1a-005056932f69";
}
//异步加载其他统计数据start
$(function(){
	$.ajax({
		type: "POST",
		url: init.userWebUrl+"myhn/getStatusNum",
		dataType:"json",
		success: function(result){
			if(result!=null && typeof(result)!="undefined"){
				$("#noreply").text(result.noreply || 0);
				$("#purchase").text(result.purchase || 0);
				$("#sellpay").text(result.sellpay || 0);
				$("#buypay").text(result.buypay || 0);
				$("#sellconsignment").text(result.sellconsignment || 0);
				$("#buyconsignment").text(result.buyconsignment || 0);
				$("#sellconsignee").text(result.sellconsignee || 0);
				$("#buyconsignee").text(result.buyconsignee || 0);
				$("#back").text(result.back || 0);
				$("#comment").text(result.comment || 0);
				$("#quote").text(result.quote || 0);
				$("#commentCount").text(result.commentCount || 0);
			}
		}
	});
});
//异步加载其他统计数据end

function phone(value){
	var regPartton=/^((13|14|15|17|18)\d{9})$/;
	if(!regPartton.test(value)){
		return false;
	}
	return true;
}

function emial(value){
	 var regPartton = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	 if(!regPartton.test(value)){
		return false;
	}
	return true;
}

function zhLinkMan(value){
	var reg = /^[\u4E00-\u9FA5]+$/; 
	if(!reg.test(value)){
		return false;
	} 
	return true;
}

var waitEmail=60;
function timeEmail(dom) {
        if (waitEmail > 0) {
            $(dom).addClass("aaa");
        	$(dom).attr("disabled",true);
            $(dom).text("重新发送("+waitEmail+")");
            waitEmail--;
            setTimeout(function() {
            	timeEmail(dom)
            },1000)
        } else{
            $(dom).text("重新发送");
        	$(dom).removeClass("aaa");
        	$(dom).attr("disabled",false);
        	waitEmail=60;
        }
    }
$('#w3').click(function(){
	windows_custom_open('发送验证邮件','<div class="sada"><input placeholder="请您输入邮箱地址" type="text" name="email" id="email" value="'+init.email+'"><button type="button" name="sendEmail" id="sendEmail">发送验证邮件</button></div><div class="sada"><input type="text" placeholder="请您输入验证码" name="emailCode" id="emailCode"><button type="button" name="vailEmail" id="vailEmail">验证邮件</button></div>','400','200');
	$("#sendEmail",window.parent.document).click(function(){
		var _bodys= $(window.parent.document).find('body');
		var _email= _bodys.find("input[name='email']").val();
		if(_email.length > 0){
			if(!emial(_email)){
				alert("请输入正确的邮箱");
				return;
			}
			$.ajax({
				type: "POST",
				url: init.userWebUrl+"myhn/sendEmailValidateCode",
				data: {email:_email},
				dataType:"json",
				success: function(result){
					if(result.msg==3){
						alert("输入的邮箱和之前的一样");
						return;
					}else if(result.msg==2){
						alert("输入的邮箱已存在");
						return;
					}else if(result.msg==1){
						timeEmail($(window.parent.document).find('body').find("button[name='sendEmail']"));
						return;
					}else{
						alert("邮箱验证码发送失败");
						return;
					}
				}
			}); 
		}else{
			alert("请填写邮箱");
			return
		}
	});
	
	
	$("#vailEmail",window.parent.document).click(function(){
		var _bodys = $(window.parent.document).find('body');
		var _email = _bodys.find("input[name='email']").val();
		var _code = _bodys.find("input[name='emailCode']").val();
		if(_code.length > 0 && _email.length >0){
			if(!emial(_email)){
				alert("请输入正确的邮箱");
				return;
			}
			$.ajax({
				type: "POST",
				url: init.userWebUrl+"myhn/validateEmailCode",
				data: {email:_email,emailCode:_code},
				dataType:"json",
				success: function(result){
					if(result.msg==1){
						alert("邮箱绑定成功");
						windows_close();
						var thisIframe = $(window.parent.document).find("#content-iframe");
						var src = thisIframe.attr("src");
						thisIframe.attr("src",src);
					}else{
						alert("输入验证码错误");
						return;
					}
				}
			}); 
		}else{
			alert("请填写验证码或者邮箱");
			return;
		}
	});
	
});

var wait=60;
function time(dom) {
        if (wait > 0) {
            $(dom).addClass("aaa");
        	$(dom).attr("disabled",true);
            $(dom).text("重新发送("+wait+")");
            wait--;
            setTimeout(function() {
                time(dom)
            },1000)
        } else{
            $(dom).text("重新发送");
        	$(dom).removeClass("aaa");
        	$(dom).attr("disabled",false);
        	wait=60;
        }
    }
    
	$('#w3-2').click(function(){
		windows_custom_open('发送手机验证码','<div class="sada"><input type="text" placeholder="请您输入手机号码" name="mobile" id="mobile" maxlength="11" value="'+init.mobile+'"><button type="button" name="sendMobile" id="sendMobile" >发送手机验证码</button></div><div class="sada"><input type="text" placeholder="请您输入验证码" name="phoneCode" id="phoneCode" maxlength="6"><button type="button" name="vailMobile" id="vailMobile" onclick="time(this);">验证手机</button></div>','400','200');
		$("#sendMobile",window.parent.document).click(function(){
			sendSms();
	});
	function sendSms(){
		var _bodys = $(window.parent.document).find('body');
		var _mobile = _bodys.find("input[name='mobile']").val();
		if(_mobile.length > 0){
			if(!phone(_mobile)){
				alert("请输入（13|14|15|17|18）开头的手机号码");
				return;
			}
			$.ajax({
				type: "POST",
				url: init.userWebUrl+"myhn/sendMobileCode",
				data: {mobile:_mobile},
				dataType:"json",
				success: function(result){
					if(result.msg==3){
						alert("输入的手机和之前的一样");
						return;
					}else if(result.msg==2){
						alert("输入的手机已存在");
						return;
					}else if(result.msg==1){
						time($(window.parent.document).find('body').find("button[name='sendMobile']"));
						//alert("手机验证码发送，请查收");
						return;
					}else{
						alert("手机验证码发送失败");
						return;
					}
				}
			});
		}else{
			alert("请填写手机号码");
			return;
		}
	}
	
	
	$("#vailMobile",window.parent.document).click(function(){
		var _bodys = $(window.parent.document).find('body');
		var _mobile = _bodys.find("input[name='mobile']").val();
		var _code = _bodys.find("input[name='phoneCode']").val();
		if(_code.length > 0 && _mobile.length >0){
			if(!phone(_mobile)){
				alert("请输入（13|14|15|17|18）开头的手机号码");
				return;
			}
			$.ajax({
				type: "POST",
				url: init.userWebUrl+"myhn/validateMobileCode",
				data: {phoneNo:_mobile,phoneCode:_code},
				dataType:"json",
				success: function(result){
					if(result.msg==1){
						alert("手机绑定成功");
						windows_close();
						var thisIframe = $(window.parent.document).find("#content-iframe");
						var src = thisIframe.attr("src");
						thisIframe.attr("src",src);
					}else{
						alert("输入验证码错误");
						return;
					}
				}
			}); 
		}else{
			alert("请填写验证码或者手机号");
			return;
		}
	});
});

$('#w3-3').click(function(){
	windows_custom_open(
			'绑定账号',
			'<h3>请填写您的收款帐号信息，用于收取货款所用</h3><div class="usename_boxs clearfix"><span class="name">收款账户类型：</span><select name="type"><option value="">请选择收款账户类型</option><option value="1">支付宝</option></select></div><div class="usename_boxs clearfix"><span class="name">收款帐号姓名：</span><input type="text" name="name" id="name" value="'+init.name+'"></div><div class="usename_boxs clearfix"><span class="name">收款帐号：</span><input type="text" name="account" id="account" value="'+init.account+'"></div><div class="usename_boxs clearfix"><span class="name">确认收款帐号：</span><input type="text" name="newaccount" id="newaccount" value="'+init.account+'"></div><div class="usename_boxs clearfix"><span class="name"></span><button name="" type="button" id="subtj">提交</button></div><div class="text"><h4>绑定须知：</h4><p>1.以上所填收款账户信息必须同绑定的账户类型已认证姓名、收款帐号一致。</p><p>2.收款人姓名、收款帐号必须准确填写无误，否则无法进行在线正常收款操作。</p><p>3.支付宝帐号仅支持邮箱或者手机号，请不要填写其他形式的帐号信息。</p></div>',
			'605','575');
	if(init.type==1){
		$(window.parent.document).find('body').find("select option[value='"+init.type+"']").attr("selected",true);
	}
	$("#subtj",window.parent.document).click(function(){
		var _bodys = $(window.parent.document).find('body');
		var _types = _bodys.find("select[name=type] option:selected").val();
		var _name = _bodys.find("input[name='name']").val();
		var _account = _bodys.find("input[name='account']").val();
		var _newaccount = _bodys.find("input[name='newaccount']").val();
		if(_types==null || _types==""){
			alert("请选择收款账号类型");
			return;
		}
		if(_name==null || _name==""){
			alert("请输入收款账号姓名");
			return;
		}
		if(!zhLinkMan(_name)){
			alert("请输入正确的收款账号姓名");
			return;
		}
		if(_account==null || _account==""){
			alert("请填入收款账号");
			return
		}
		if(_newaccount==null || _newaccount==""){
			alert("请输入确认收款账号");
			return;
		}
		if(_newaccount!=_account){
			alert("两次输入的收款账号不一致");
			return;
		}
		
		$.ajax({
			type: "POST",
			url: init.userWebUrl+"person/operationPay",
			data: {type:_types,name:_name,account:_account},
			dataType:"json",
			success: function(result){
				if(result.msg==1){
					alert("修改成功");
					windows_close();
					var thisIframe = $(window.parent.document).find("#content-iframe");
					var src = thisIframe.attr("src");
					thisIframe.attr("src",src);
				}else{
					alert("修改失败");
					return;
				}
			}
		});
		
	});
});