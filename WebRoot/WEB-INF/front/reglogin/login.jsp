<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">

<title>登录</title>

<link rel="stylesheet" type="text/css" href="front/css/login.css" media="all">
    <link rel="stylesheet" type="text/css" href="front/css/foot.css" media="all">
</head>
<body>
<!--//topbar-->


<div class="header clearfix">
        <div class="logo-box fl">
            <div class="logo fl">
                <a href="/front/index/index.action"><img src="front/images/hng-logo.jpg" alt="襄阳惠农谷" width="288" height="93"></a>
            </div>
            <div class="logotext lh22 fl ml10">
                <div class="fs18">用户登录</div>
                <div class="">客服热线：400-008-xxxx</div>
            </div>
        </div>  
        <div class="links fr">
            <span>
                <i class="fl"><img src="front/images/top_ico_01.jpg"></i>
                <div class="lh22 fs14 fl ml10">
                   <p>海量供应</p> 
                   <p>实时更新</p> 
                </div>
            </span>
            <span>
                <i class="fl"><img src="front/images/top_ico_02.jpg"></i>
                <div class="lh22 fs14 fl ml10">
                   <p>采购信息</p> 
                   <p>免费发布</p> 
                </div>
            </span>
            <span>
                <i class="fl"><img src="front/images/top_ico_03.jpg"></i>
                <div class="lh22 fs14 fl ml10">
                   <p>知名产地 </p> 
                   <p>源头好货</p> 
                </div>
            </span>
        </div>
    </div>

<div class="main wrap-1000">
	<div class="fl">
    	<a href="#"><img class="login-ad"  src="front/images/login-ad.jpg"></a>
    </div>
    <div class="login-form">
    	<h1>用户登录</h1>
        <form id="loginform" action="front/user/login.action" method="post" onsubmit="return checkLogin(this);" enctype=”multipart/form-data>
	        <input value="" name="isRememberPwd" id="isRememberPwd" type="hidden">
	        <div class="usertxt">
	            <span class="reg-hint">
	                <span class="red" id="userAccountv">${loginMsg}</span>
	            </span>
	        </div>
	        <div class="userinput">
	        	<input placeholder="邮箱/用户名" name="user.loginName" id="userAccount" value="邮箱/用户名" onfocus="this.value=this.value=='邮箱/用户名'?'':this.value;" onblur="this.value=this.value==''?'邮箱/用户名':this.value" validate="{required:true,trim:true,messages:{required:'登录名不能为空'}}" autocomplete="off" type="text">
	        </div>
	        <div class="passwordtxt">
	            <span class="reg-hint">
	                <span class="red" id="passwordv"></span>
	            </span>
	        </div>
	        <div class="passwordinput">
	        	<input value="" placeholder="请输入密码" name="user.password" id="password" validate="{required:true,trim:true,messages:{required:'密码不能为空'}}" autocomplete="off" type="password">
	        </div>
	       <div id="liValiCode" style="display: none;">
		      	<div class="codetxt">验证码：</div>
		        <div class="codeinput">
		        	<input value="" name="valCode" id="valCode" type="text">
		            <div class="verify"><img src="gologin" id="imgValidate" height="30" width="60"></div>
		            <span>看不清，<a href="javascript:void(0);" id="img">换一张</a></span>
		        </div>
		        <span class="reg-hint">
		        	<span class="red" id="valCodev"></span>
		        </span>
	        </div>
	        <div class="forget">
	        	<em id="forget-check"></em>
	            <span>下次自动登录</span>
	        </div>
	      <!--   <a href="javascript:void(0);" class="userloginbut but" id="userlogin">会员登录</a> -->
	        <input type="submit" class="userloginbut but" value="会员登录"></input>
	        <p class="mt_10"></p>
	        <a href="#" class="forget-word">忘记登录密码?</a>
	        <a href="front/user/register.action" class="regin" id="free_goReg">免费注册</a>
        </form>
        <div class="login-qq">
        	<div class="login-g"><b>—————</b>&nbsp;&nbsp;使用合作伙伴账号登录&nbsp;&nbsp;<b>—————</b></div>
        	<div class="clear"></div>
        	<div class="login-h clearfix">
	            <a href="javascript:turn('qq')" target="_self" class="qqico" id="qqlogin"><img src="front/images/kj_dl_01.png" id="login_qq"></a>
	            <a href="javascript:turn('wb')" target="_self" class="qqico" id="wblogin"><img src="front/images/kj_dl_04.png" id="login_wb"></a>
	            <a href="javascript:turn('wx')" target="_self" class="qqico" id="wxlogin"><img src="front/images/kj_dl_02.png" id="login_wx"></a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="front/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="front/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="front/js/jquery.metadata.js"></script>
<script type="text/javascript" src="front/js/messages_cn.js"></script>
<script type="text/javascript" src="front/js/login.js"></script>


<div class="mt20" id="footer_wrapper">
    <div id="footer003">
        <div id="footer">

            <div class="web_list">
                <a style="border-left: 0px none;" target="_top" href="#">关于我们</a>

                <a target="_top" href="#">法律声明</a>

                <a target="_top" href="#">使用协议</a>

                <a target="_top" href="#">版权隐私</a>

                <a target="_top" href="#">友情链接</a>

                <a target="_top" href="#">成功案例</a>

                <a target="_top" href="#">惠农大事记</a>

                <a target="_top" href="#">产品库</a>
                <a target="_top" href="#">企业大全</a>
                <a target="_top" href=#>网站地图</a>

            </div>
            <div class="f_text">
            ©2015-2016 hng B2B

                SYSTEM All Rights Reserved
            </div>


        </div>
    </div>
</div>


</body>
</html>
    