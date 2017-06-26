<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>注册成功</title>
    <script type="text/javascript" src="front/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="front/js/topbg.js"></script>

    <link rel="stylesheet" type="text/css" href="front/css/public.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="front/css/reg.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="front/css/topbg.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="front/css/foot.css" media="all"/>
</head>

<body>

<!--公共头部-->

<!--公共头部-->

<div id="header" class="win1000">
    <a id="logo" href=""><img alt="" src="">此处是logo</a>

    <div id="cityname">用户注册</div>
</div>
<div class="wraper-border"></div>

<div class="reg-top">
    <ul>
        <li><i>1</i>设置登录名</li>
        <li class="cur"><i>2</i>注册成功</li>

    </ul>
</div>

<div id="reg">
    <div class="frame">
        <div class="reg-ok-img">
            <img src="front/images/regok.png" alt="注册成功"/>
        </div>
        <div class="reg-ok-msg">
            <span class="reg-ok-msg1">恭喜您注册成功！</span>
            <span class="reg-ok-msg2">2秒后页面将自动跳转。如果没有跳转，请<a target="_self" href="front/user/login.action">点击这里</a></span>
        </div>
    </div>
</div>
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