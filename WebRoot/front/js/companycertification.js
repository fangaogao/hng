$(document).ready(function(){
	
	newCertificationInfo();
	
	$.metadata.setType("attr", "validate");
    $("form").validate({
    	 errorPlacement: function (lable, element) {
    		 $("#" + element.attr("id") + "v").prev().css("display","block");
             $("#" + element.attr("id") + "v").html(lable.html());
         },
         success: function (lable) {
        	 $("#" + lable.attr("for") + "v").prev(".reg-ico-2").css("display","none");
         },
         submitHandler: function (from) {
        	 //from.submit();
         }
    });
    
    $(".btn-2").click(function (){
     	/* var mainBusiness=""; 
		$("[id='mainBusiness']:checked").each(function(i){
			ids += $(this).val() + ",";
		}); */
        subMitClick(fx_confirm_window("确认提交当前认证资料吗？"));

	});
    //因为打开是在html文件中打开所以图片路径应该是从html所在的位置往上找（后期考虑用别的方式实现）
    $('#w3').click(function(){
    	windows_custom_open('营业执照模板展示','<div class="mode-tc"><div class="img"><img src="../../images/yyzz.jpg" width="400" height="300" alt=""></div></div>','440','400');
    });
    $('#w3-1').click(function(){
    	windows_custom_open('组织机构代码照模板展示','<div class="mode-tc"><div class="img"><img src="../../images/yyzz2.jpg" width="400" height="300" alt=""></div></div>','440','400');
    });
    $('#w3-2').click(function(){
    	windows_custom_open('统一社会信用代码模板展示','<div class="mode-tc"><div class="img tc"><img src="../../images/license.jpg" height="300" alt=""></div></div>','440','400');
    });
}); 

function subMitClick(){
	var type = $("input[name='type']:checked").val();
		
		if(type==null || type==""){
            windows_open(1,"请选择一种执照方式");
			 return;
		 }
		 var obj;
		 if(parseInt(type)==1){
			 var company = $.trim($("#companyName").val());
			 var laywer = $("#laywer").val();
			 var businessLicense = $.trim($("#businessLicense").val());
			 var orgCode = $.trim($("#orgCode").val());
			 if(company==null || company==""){
                 windows_open(1,"请输入企业名称");
				 return;
			 }
			 if(!existslinkMan(company)){
                 windows_open(1,"企业名称请输入中文");
					return;
			 }
			 if(laywer==null || $.trim(laywer)==""){
                 windows_open(1,"请填写企业法人");
				 return
			 }
			 if(!existslinkMan(laywer)){
                 windows_open(1,"企业法人请输入中文");
					return;
			 }
			if(businessLicense==null || businessLicense==""){
                windows_open(1,"请输入营业执照号码");
				 return;
			 }
			 if(businessLicense!=null || $.trim(businessLicense)!=""){
				 var reg = new RegExp("^[0-9A-Za-z]*$");
				 if(!reg.test(businessLicense)){
                     windows_open(1,"请输入正确的营业执照");
						return;
				 }
				 if(businessLicense.length<15 || businessLicense.length>18){
                     windows_open(1,"营业执照号码长度不能小于15位数");
					 return;
				 }
			 }
			 
			 if(orgCode==null || orgCode==""){
                 windows_open(1,"请输入组织机构代码证号码");
				 return;
			 }
			 if(orgCode!=null || $.trim(orgCode)!=""){
				 if(!CheckOrgCode(orgCode)){
                     windows_open(1,"请输入有效的组织机构代码");
					 return;
				 }
				 if(orgCode.length>10){
                     windows_open(1,"组织机构代码长度不能大于10位数");
					 return;
				 }
			 }
			 
			 if($("input[name='pictureUrl']").length < 1){
                 windows_open(1,"请上传1张营业执照图片");
				 return;
			 }
			 
			 if($("input[name='orgPictureUrl']").length < 1){
                 windows_open(1,"请上传1张组织机构图片");
				 return;
			 }
			 $("#type").val(parseInt(type));
			 obj = $("#iforms").serializeArray();
		 }
		 
		if(parseInt(type)==2){
			 var tickCode = $.trim($("#tickCode").val());
			 var company = $.trim($("#companyNameNew").val());
			 var laywer = $("#laywerNew").val();
			 if(company==null || company==""){
                 windows_open(1,"请输入企业名称");
				 return;
			 }
			 if(!existslinkMan(company)){
                 windows_open(1,"企业名称请输入中文");
					return;
			 }
			 if(laywer==null || $.trim(laywer)==""){
                 windows_open(1,"请填写企业法人");
				 return
			 }
			 if(!existslinkMan(laywer)){
                 windows_open(1,"企业法人请输入中文");
					return;
			 }
			 if(tickCode==null || tickCode==""){
                 windows_open(1,"请输入统一社会信用号码");
				 return;
			 }
			 if(tickCode!=null || $.trime(tickCode)!=""){
				 var reg = new RegExp("^[0-9A-Za-z]*$");
				 if(!reg.test(tickCode)){
                     windows_open(1,"请输入正确的统一社会信用号码");
						return;
				 }
				 if(tickCode.length!=18){
                     windows_open(1,"请输入18位的统一社会信用号码");
					 return;
				 }
			 }
			 if($("input[name='tickPictureUrl']").length < 1){
                 windows_open(1,"请上传1张统一社会信用执照图片");
				 return;
			 }
			 $("#typeNew").val(parseInt(type));
			 obj = $("#licence").serializeArray();
		 }
    	 
    	 
    	 //var obj = $("#"+_forms).serializeArray();
    	 $.ajax({
 			type: "POST",
 			url: init.webUrl+"person/saveComapanyCertification",
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

function newCertificationInfo(){
	var type = init.type;
	var isdisable = init.certification;
	var typeNew = init.typeNew;
	var isdisableNew = init.newcertification;
	var status = init.status;
	var statusNew = init.statusNew;
	if(parseInt(isdisable)==0 && parseInt(type)==1){
		if(parseInt(statusNew)!=2){
			$("#licenceOld").attr("checked","checked");
			$("#licenceOldWrap").css("display","block");
			$("#licenceMergeWrap").css("display","none");
			$("#licenceMerge").attr("disabled","disabled");
		}
		else if(parseInt(status)!=2){
			$("#licenceMerge").attr("checked","checked");
			$("#licenceMergeWrap").css("display","block");
			$("#licenceOldWrap").css("display","none");
			$("#licenceOld").attr("disabled","disabled");
		}
	}else{
		if(parseInt(isdisableNew)==0 && parseInt(typeNew)==2){
			if(parseInt(status)!=2){
				$("#licenceMerge").attr("checked","checked");
				$("#licenceMergeWrap").css("display","block");
				$("#licenceOldWrap").css("display","none");
				$("#licenceOld").attr("disabled","disabled");
			}
		}
	}
	
	$('#licenceOld, #licenceMerge').change(function(){
		if($('#licenceOld').prop('checked')) {
			$('#licenceOldWrap').show();
			$('#licenceMergeWrap').hide();
		}
		else {
			$('#licenceMergeWrap').show();
			$('#licenceOldWrap').hide();
		}
	});
}


function CheckOrgCode(code) {
	var flag = true;
    var reg = /^([0-9A-Z]){8}-?[0-9A-Z]{1,2}$/;
    if (!reg.test(code)) {
    	flag = false;
    }
    return flag;
}

function isValidBusCode(busCode){
    var ret=true;
    if(busCode.length==15){
        var sum=0;
        var s=[];
        var p=[];
        var a=[];
        var m=10;
        p[0]=m;
        for(var i=0;i<busCode.length;i++){
           a[i]=parseInt(busCode.substring(i,i+1),m);
           s[i]=(p[i]%(m+1))+a[i];
           if(0==s[i]%m){
             p[i+1]=10*2;
           }else{
             p[i+1]=(s[i]%m)*2;
            }    
        }                                       
        if(1==(s[14]%m)){
           //营业执照编号正确!
            ret=true;
        }else{
           //营业执照编号错误!
            ret=false;
         }
    }
    return ret;
}

//联系人名称验证
function existslinkMan(linkMan){
	var reg = /^[\u4E00-\u9FA5\·]+$/; 
	if(!reg.test(linkMan)){
		return false;
	}
	return true;
}