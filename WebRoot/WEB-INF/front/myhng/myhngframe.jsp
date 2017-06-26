<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
    <!--检查是否登录
    <script src="http://authority.cnhnb.com/menu/listMenus?callback=initMenuCallback&amp;_=1453983511889"
            async=""></script>
    <script src="http://passport.cnhnb.com/loginInfo?callback=getLoginUserInfo&amp;_=1453983511885" async=""></script>-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>我的惠农</title>
    <script type="text/javascript" src="front/js/jquery-1.7.2.min.js"></script>
    <!--左边展开伸缩效果-->
    <script type="text/javascript" src="front/js/left.js"></script>
    <script type="text/javascript" src="front/js/topbg.js"></script>
    <!--window.js必须放在下面，因为必须等DOM加载完成-->

    <link rel="stylesheet" type="text/css" href="front/css/topbg.css" media="all">
    <link rel="stylesheet" type="text/css" href="front/css/myhngframe.css" media="all">
    <link rel="stylesheet" type="text/css" href="front/css/foot.css" media="all">
    <link rel="stylesheet" type="text/css" href="front/css/public.css" media="all">

</head>
<body class="index">
<div class="topbg">
    <div class="topbar clear">
        <ul style="display: none;" class="topbar-name" id="topmenu_wel">
            <li class="tp-nj">您好，</li>
            <li class="tp-tit">
                <a href="" target="_top" class="userName">13098455884</a>
                <div style="display: none;" class="tp-cont myhn">
                    <dl class="manage-buy">
                        <dt><a href=""
                               target="_top">帐号管理</a></dt>
                        <dd>
                            <a href="">退出登录</a>
                        </dd>
                    </dl>
                </div>
            </li>

            <li class="tp-nj">&nbsp;&nbsp;消息&nbsp;<a
                    href="" target="_top"
                    class="msgnum">13</a></li>
        </ul>
        <ul style="display: block;" class="topbar-login">
            <li class="tp-wel">您好，欢迎来到襄阳市惠农谷</li>
            <li class="tp-log"><a title="马上登录，享受更多会员专享服务"
                                  href="front/user/login.action"
                                  rel="nofollow">请登录</a></li>
            <li class="tp-reg"><a title="马上注册，共享无限农业商机" href="front/user/register.action" target="_top"
                                  rel="nofollow">免费注册</a></li>
        </ul>

        <ul class="topbar-menu" id="topmenu">
            <li id="hnIndex" class="tp-nj" style="display: none;"><a href="" target="_top">惠农首页</a>
            </li>
            <li class="tp-tit">
                <a href="front/myhng/getMyIndex.action" target="_top" title="点击进入个人中心"
                                  rel="nofollow">我的惠农</a>

                <div style="display: none;" class="tp-cont myhn">
                    <dl class="manage-buy">
                        <dt><a href="javascript:void(0);" target="_top">采购管理</a></dt>
                        <dd><a href=""
                               target="_top">已发布的采购</a></dd>
                        <dd><a href=""
                               target="_top">已买到的商品</a></dd>
                        <dd><a href=""
                               target="_top">发出的询价单</a></dd>
                    </dl>
                    <dl class="manage-sell">
                        <dt><a href="javascript:void(0);" target="_top">供应管理</a></dt>
                        <dd><a href=""
                               target="_top">已发布的产品</a></dd>
                        <dd><a href=""
                               target="_top">已卖出的产品</a></dd>
                        <dd><a href=""
                               target="_top">收到的询价单</a></dd>
                    </dl>
                </div>
            </li>

            <li class="tp-nj">
            	<a href="../show/show.html" target="_top" title="供应大厅" rel="nofollow">供应大厅</a>
            </li>
            <li class="tp-nj"><a href="../show/show.html" target="_top" title="采购大厅" rel="nofollow">采购大厅</a>
            </li>
            <li class="tp-nj"><a href="#" title="价格行情">价格行情</a>
            </li>
        </ul>
    </div>
</div>

<div class="logobar">
    <div class="wrap-1190">
        <div class="logo"><a href="/hng/front/index/index.action"><img src="front/images/hng-logo.jpg" alt="襄阳惠农谷" width="388" height="123"></a></div>
        <div class="myhn-txt">我的惠农</div>
    </div>
</div>


<div class="nav">
    <div class="wrap-1190">
        <a href="myindex.html" target="content-iframe" class="backhome">返回我的惠农</a>

        <div class="wanted">
            <a href="../buy/pubInfo.html" class="release-wanted" id="purches">发布求购</a>
        </div>

        <a href="javascript:void(0);" class="earn-points" id="integral">发布供应</a>
    </div>
</div>


<div class="main wrap-1190">

    <div class="side-nav side-line">
        <div class="side-title">我的惠农</div>
        <div class="side-list">
            <h2 class="is-sub"><a href="javascript:void(0);" class="show" id="c5a0">个人设置</a></h2>
            <ul style="display: block;" class="show">
                <li></li>
                <li><h3><a href="/myInfo.html"
                           id="" targetmet="1" level="2"
                           target="content-iframe">我的个人信息</a></h3></li>
                <li></li>
                <li><h3><a href="usercertification.html"
                           id="menu_5fc5d25a-d8e9-11e4-8026-40167e2206a7" targetmet="1" level="2"
                           target="content-iframe">个人实名认证</a></h3></li>
                <li></li>
                <li><h3><a href="companycertification.html"
                           id="menu_5fc5d37c-d8e9-11e4-8026-40167e2206a7" targetmet="1" level="2"
                           target="content-iframe">企业实名认证</a></h3></li>
                <li></li>
                <li><h3><a href="sysmsg.html"
                           id="menu_5fc5e4eb-d8e9-11e4-8026-40167e2206a7" targetmet="1" level="2"
                           target="content-iframe">系统消息通知</a></h3></li>
                <li></li>
                <li><h3><a href="pwd.html"
                           id="menu_5fc5e71a-d8e9-11e4-8026-40167e2206a7" targetmet="1" level="2"
                           target="content-iframe">修改个人密码</a></h3></li>
                <li></li>
                <li><h3></h3></li>
                <li></li>
                <li><h3></h3></li>
                <li><h3><a href="collection.html" id="d4bda9a7-d8e8-11e4-8026-40167e2206a7" targetmet="1" level="2"
                           target="content-iframe">收藏夹管理</a></h3>
                </li>
            </ul>
            <h2 class="is-sub"><a href="javascript:void(0);" class="hide"
                                  id="51eefbcc-d8e6-11e4-8026-40167e2206a7">买家中心</a></h2>
            <ul style="display: none;" class="hidden">
                <li></li>
                <li><h3><a href="front/buyInfo/index.action"
                           id="menu_5fc61008-d8e9-11e4-8026-40167e2206a7" targetmet="1" level="2"
                           target="content-iframe">我要发布求购</a></h3></li>
                <li>
                    <h3><a href="front/buyInfo/getBuyInfoByMember.action" targetmet="1" level="2"
                           target="content-iframe" id="73f9f5d6-11e4-8026-40167e2206a7">求购信息管理</a></h3>
                    <h3><a href="../buy/buy_inquiry.html" targetmet="1" level="2"
                           target="content-iframe"   id="73f9f5d6-11e4-8026-40167206a7">发出的询价单</a></h3>
                    <h3><a href="../buy/buy_quote.html" targetmet="1" level="2"
                           target="content-iframe"  id="73f9f5d6-11e4-8026-401e2206a7">收到的报价单</a></h3>
                   <!-- <ul style="display: none;" class="hidden">
                        <li><a href="../buy/mybuy.html"
                               id="ddd" targetmet="1" level="3"
                               target="content-iframe">求购信息管理</a></li>
                        <li><a href="2"
                               id="menu_5fc6112b-d8e9-11e4-8026-40167e2206a7" targetmet="1" level="3"
                               target="content-iframe">我的询价信息</a></li>
                        <li><a href=""
                               id="menu_5fc61349-d8e9-11e4-8026-40167e2206a7" targetmet="1" level="3"
                               target="content-iframe">收到的报价单</a></li>
                    </ul>-->
                </li>

            </ul>
            <h2 class="is-sub" style="border-bottom: 1px solid rgb(229, 229, 229);"><a href="javascript:void(0);" class="hide"
                                  id="49bfaf10-d8e8-11e4-8026-40167e2206a7">卖家中心</a></h2>
            <ul style="display: none;" class="hidden">
                <li></li>
                <li><h3><a href="323f5"
                           id="menu_3dc4f192-5de0-11e5-96dc-0050569323f5" targetmet="1" level="2"
                           target="content-iframe">我要发布供应</a></h3></li>
                <li></li>
                <li><h3><a href="323f5"
                           id="menu_3dc4f19211e5-96dc-0050569323f5" targetmet="1" level="2"
                           target="content-iframe">供应信息管理</a></h3>
                    <h3><a href="323f5"
                           id="menu_92-5de0-11e5-96dc-0050569323f5" targetmet="1" level="2"
                           target="content-iframe">我的报价信息</a></h3>
                    <h3><a href="323f5"
                           id="menu_3dc4f1e5-96dc-0050569323f5" targetmet="1" level="2"
                           target="content-iframe">收到的询价单</a></h3>
                </li>
            </ul>
        </div>

        <!--//客户服务及投诉-->
        <div class="side-customer">
            <h2>惠农客户服务</h2>

            <p>
                客服热线：400-008-xxxx<br>
                客服邮箱：service@hng.com<br>
                市场推广：0731-88189999-xxxx<br>
                商务合作：0731-88189999-xxxx<br>
                <span>
                	<strong>企业客服：</strong>
                    <a target="_top"
                       href=""
                       class="dp_but_qq" title="请点击这里给和我交谈"></a>
                </span>
            </p>
        </div>
    </div>

    <div class="iframe-content">
        <iframe style="min-height:300px;" src="front/myhng/getMyIndexInfo.action" id="content-iframe" name="content-iframe" scrolling="no"
                marginwidth="0" marginheight="0" width="980" frameborder="0" height="100%"></iframe>
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
<script type="text/javascript" src="front/js/windows.js"></script>
</body>
</html>
