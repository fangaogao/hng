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
<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新用户注册页面</title>
    <script type="text/javascript" src="front/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="front/js/common.js" charset="gbk"></script>
    <script type="text/javascript" src="front/js/msg.js" charset="gbk"></script>
    <script type="text/javascript" src="front/js/validator.js" charset="gbk"></script>
    <script type="text/javascript" src="front/js/reg.js" charset="gbk"></script>
    <script type="text/javascript" src="front/js/topbg.js"></script>

    <link rel="stylesheet" type="text/css" href="front/css/public.css" media="all">
    <link rel="stylesheet" type="text/css" href="front/css/reg.css" media="all">
    <link rel="stylesheet" type="text/css" href="front/css/topbg.css" media="all">
    <link rel="stylesheet" type="text/css" href="front/css/foot.css" media="all">
</head>

<body>

<!--公共头部-->


<!--公共头部-->
<form name="regForm" action="front/user/register.action"  onSubmit="return regSubmit('regForm');" method="post">
<div id="header" class="win1000">
    <a href="front/index/index.action"><img src="front/images/hng-logo.jpg" alt="襄阳惠农谷" width="288" height="93"/></a>

    <div id="cityname">用户注册</div>
</div>
<div class="wraper-border"></div>

<div class="reg-top">
    <ul>
        <li class="cur"><i>1</i>设置登录名</li>
        <li><i>2</i>注册成功</li>

    </ul>
</div>

<div id="reg">
    <ul id="frame" class="frame">
        <li class="tr">
            <ul class="content">
                <li class="label data_number">用&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;名</li>
                <li class="td data_char">
                    <input type="text" name="user.loginName" value="${user.loginName }" class="reg_txt" id="txtRegName"
                           onfocus="selectTr(0,INFO_MSG_REGNAME);"
                           onblur="validateRegName(0);"/>
                </li>
                <img class="okimg" src="front/images/oneok.png">
                <li class="msg data_char info_msg"></li>
                <li class="msg data_char err_msg"></li>
                <span class="msg action_po_bot"></span>
            </ul>
        </li>
        <li class="tr">
            <ul class="content">
                <li class="label data_number">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</li>
                <li class="td data_char">
                    <input type="text" id="txtMail" name="user.email" value="${user.email }" class="reg_txt"
                           onfocus="selectTr(5,INFO_MSG_EMAIL);"
                           onblur="validateMail(5);"/>
                </li>
                <img class="okimg" src="front/images/oneok.png">
                <li class="msg data_char info_msg"></li>
                <li class="msg data_char err_msg"></li>
                <span class="msg action_po_bot"></span>
            </ul>
        </li>
        <li class="tr">
            <ul class="content">
                <li class="label data_number">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</li>
                <li class="td data_char">
                    <input type="password" id="txtPassword"
                           name="user.password" class="reg_txt"
                           onfocus="selectTr(10,INFO_MSG_PWD);"
                           onblur="validatePassword(10)"/>
                </li>
                <img class="okimg" src="front/images/oneok.png">
                <li class="msg data_char info_msg"></li>
                <li class="msg data_char err_msg"></li>
                <span class="msg action_po_bot"></span>
            </ul>
        </li>
        <li class="tr">
            <ul class="content">
                <li class="label data_number">确&nbsp;认&nbsp;密&nbsp;码</li>
                <li class="td data_char">
                    <input type="password" id="txtRePassword"
                           name="repassword" class="reg_txt"
                           onfocus="selectTr(15,INFO_MSG_REPWD);"
                           onblur="validateRePassword(15)"/>
                </li>
                <img class="okimg" src="front/images/oneok.png">
                <li class="msg data_char info_msg"></li>
                <li class="msg data_char err_msg"></li>
                <span class="msg action_po_bot"></span>
            </ul>
        </li>
       <!--  <li class="tr">
            <ul class="content">
                <li class="label data_number">验&nbsp;&nbsp;&nbsp;证&nbsp;&nbsp;&nbsp;码</li>
                <li class="td data_char">
                    <input type="text" name="code" class="reg_txt" id="txtCode"
                           style="width:60px;" onfocus="selectTr(20,INFO_MSG_CODE);"
                           onblur="validateCode(20);"/>
                    <img onclick="refreshCode();" id="imgCode"
                         title="看不清楚?点我换一张" src="/ImageServlet"
                         width="80px" height="20px"/><a style="font-size: 12px;color: darkgray;">看不清?换一张</a>
                </li>
                <img class="okimg" src="front/images/oneok.png">
                <li class="msg data_char info_msg"></li>
                <li class="msg data_char err_msg"></li>
                <span class="msg action_po_bot"></span>
            </ul>
        </li> -->
        <li class="tr">
            <ul class="content">
                <li class="regmsg">${regMsg }</li>
                <li class="td data_char">
                    <input type="submit" class="reg_txt btn_reg" value="立即注册"/>
                </li>
                <span id="loginOpt">已有账号？<a href="">去登录</a></span>
            </ul>
        </li>
        <li class="tr">
				<span class="agree">
                <input id="agree" type="checkbox" checked="checked" name="agree"/>
                <label for="agree">我已阅读并同意《交易条款》和《社区条款》</label>
                </span>
        </li>
    </ul>
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



</form>
</body>
</html>