/**
 * 个人实名认证验证
 */
/*自定义提示窗口调用方式*/
var openText = "注意事项：<br>";
openText += "1.我们保证您提供的信息将被予以保护，不挪作他用。<br>";
openText += "2.第二代身份证正面照：需要能看清姓名、地址、身份证号码等信息。<br>";
openText += "3.第二代身份证反面照：需要能看清签发机关、有效日期等信息。";

$(document).ready(function(){
	$.metadata.setType("attr", "validate");
    $("form").validate({
    	 errorPlacement: function (lable, element) {
             $("#" + element.attr("id") + "v").prev().prev(".reg-ico-1").css("display", "none");
             $("#" + element.attr("id") + "v").prev().css("display", "block");
             $("#" + element.attr("id") + "v").html(lable.html());
         },
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
         rules:{
             linkMan:{
                 required:true,
                 existslinkMan:true
             },
             code:{
                 required:true,
                 existsidCardv:true
             }
         },
        messages:{
            linkMan:{
                required: "请输入姓名"
            },
            code:{
                required:"请输入身份证号码"
            }
        }

    });

    $(".btn-2").click(function (){
        //判断是否上传了两张照片(此处后期再做修改)
        if($("input[name='pictureUrl']").length <2){
            windows_open(1,"请上传身份证正反两张照片!");
            return;
        };
		fx_confirm_window("确认提交当前认证资料吗？",subMitClick);
	});
    //身份证模板展示(大图)
    $('#w3').click(function(){
        windows_custom_open('身份证模板展示','<div class="mode-tc mode-font"><div class="title" style="color: #333;font-size: 14px;">请参照以下形式上传您的身份证照片：</div><div class="img"><img src="../../images/sfz.png" alt=""></div><div style="color: #ff0000">'+openText+'</div></div>','580','500');
    });

});
$.validator.addMethod("existslinkMan", existslinkMan, "姓名请输入中文");
$.validator.addMethod("existsidCardv", existsidCardv, "请输入正确的身份证号码");

function subMitClick(){
		var obj = $("#ifroms").serializeArray();
    	$.ajax({
			type: "POST",
			url: init.webUrl+"person/savePersonalCertification",
			dataType : "json",
			data:obj,
			success: function(result){
				if(result.msg==1){
                    windows_open(1,"恭喜您！您的认证资料已经提交审核，请耐心等待。");
					var thisIframe = $(window.parent.document).find("#content-iframe");
 					var src = thisIframe.attr("src");
 					thisIframe.attr("src",src);
				}else if(result.msg==2){
                    windows_open(1,"提交的认证资料数据错误");
					return;
				}else if(result.msg==3){
                    windows_open(1,"该证件号码已经超过认证次数限制，请更换证件号重新进行提交！");
					return;
				}else{
                    windows_open(1,"保存失败!");
 				}
			}
		}); 
}

//联系人名称验证
function existslinkMan(linkMan){
	var reg = /^[\u4E00-\u9FA5\·]+$/; 
	if(!reg.test(linkMan)) 
		return false;
	return true;
}
//身份证号验证
function existsidCardv(code){
	if(!/^\d{17}(\d|x)$/i.test(code)) {
		 return false; 
	}
	return true;
}



