<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
    <!--页面默认用极速核-->
    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>襄阳市惠农谷</title>
    <!--网站关键字和描述，利于百度搜录和网站优化-->
    <meta name="keywords" content="农产品,农产品信息,农产品交易,农产品价格,农产品大全,惠农谷">
    <meta name="description" content="襄阳市农产品供求信息发布平台">
    <!--智能Agent-->
    <meta http-equiv="mobile-agent" content="format=html5; url=">
    <link rel="alternate" media="only screen and(max-width: 640px)" href="">
    <!--下面代码表明网站加入了qq登录接口-->
    <meta property="qc:admins" content="154233125446360632636">
    <meta property="qc:admins" content="154233117063606263757">
    <!--下面代码表明网站加入了微博登录接口-->
    <meta property="wb:webmaster" content="97be2c15235e9734">
    <script type="text/javascript" src="front/js/jquery-1.7.2.min.js"></script>

    <!--主页面的样式-->
    <link rel="stylesheet" type="text/css" href="front/css/public.css" media="all">
    <link rel="stylesheet" type="text/css" href="front/css/index.css" media="all">
    <script type="text/javascript" src="front/js/topbg.js"></script>
    <link rel="stylesheet" type="text/css" href="front/css/topbg.css" media="all">
    <link rel="stylesheet" type="text/css" href="front/css/foot.css" media="all">
</head>
<body>
<div class="">
<!--顶栏-->
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
           <!--  </li>
            <li class="tp-nj"><a href="#" title="价格行情">价格行情</a>
            </li> -->
        </ul>
    </div>
</div>
<!--顶栏结束-->
<script type="text/javascript">
    openType = "_self";//设置搜索打开方式_self当前，_blank新窗口
</script>
<!--首部搜索-->
<div class="head clear">
    <div class="logo"><a href="/hng/front/index/index.action"><img src="front/images/hng-logo.jpg" alt="襄阳惠农谷" width="388" height="123"></a></div>
    <div class="search">
        <ul class="sear-top">
            <li id="search01" searchurl="/product/list" searchtype="1" class="current" msg="输入产品名称">供应</li>
            <li id="search02" searchurl="/company/list" searchtype="2" msg="输入产品名称">求购</li>
            <li id="search05" searchurl="/supply/list" searchtype="5" msg="输入主营产品、企业名、地区">企业</li>
            <li id="search03" searchurl="/purchase/list" searchtype="3" msg="输入发布人姓名、发布的产品名、地区">发布人</li>
            <!-- <li id="search04" searchurl="/information/list" searchtype="4" msg="输入产品名称">价格行情</li> -->
        </ul>
        <form id="searchForm" method="get" target="_self" action="">
            <div class="sear-area">
                <div class="autoComplete" style="z-index: 15;">
                    <input value="" name="keyword" id="keyword" autocomplete="off" class="sear-inpt broder_r_no"
                           placeholder="输入产品名称" type="text">
                    <ul style="display: none;" class="org">
                        <li></li>
                    </ul>
                </div>
                <input id="category" name="cateId3" type="hidden">
                <input id="breed" name="breed" type="hidden">
                <input class="sear-btn" value="搜索" type="submit">
            </div>
        </form>
        <ul id="idkeyList" class="keylist" style="display: block;">
            <li><a href="javascript:hotKeyWordSearch('%E7%8E%89%E7%B1%B3');" title="玉米">玉米</a></li>
            <li><a href="javascript:hotKeyWordSearch('%E5%B0%8F%E9%BA%A6');" title="小麦">小麦</a></li>
            <li><a href="javascript:hotKeyWordSearch('%E8%8B%B9%E6%9E%9C');" title="苹果">苹果</a></li>
            <li><a href="javascript:hotKeyWordSearch('%E8%8A%B1%E7%94%9F');" title="花生">花生</a></li>
            <li><a href="javascript:hotKeyWordSearch('%E7%AB%B9%E9%BC%A0');" title="竹鼠">竹鼠</a></li>
            <li><a href="javascript:hotKeyWordSearch('%E9%B8%A1');" title="鸡">鸡</a></li>
            <li><a href="javascript:hotKeyWordSearch('%E5%B1%B1%E6%A5%82');" title="山楂">山楂</a></li>
            <li><a href="javascript:hotKeyWordSearch('%E8%91%A1%E8%90%84');" title="葡萄">葡萄</a></li>
            <li><a href="javascript:hotKeyWordSearch('%E7%8C%AA');" title="猪">猪</a></li>
            <li><a href="javascript:hotKeyWordSearch('%E7%BA%A2%E6%9E%A3');" title="红枣">红枣</a></li>
        </ul>
        <input id="webBase" value="" type="hidden">
        <input id="searchDef" value="" type="hidden">
    </div>
</div>

<!--导航-->
<div class="navbg">
    <div class="navbar clear">
        <ul class="navbar-home">
            <li class="current"><a href="front/index/index.action" title="点击访问襄阳市惠农谷首页">首页</a></li>
            <li><a href="front/html/show/show.html" target="_top" title="海量农产品供应信息">供应大厅</a><i class="hot"></i></li>
            <li><a href="" target="_top" title="海量农产品采购信息">采购大厅</a></li>
            <!-- <li><a href="" target="_top" title="海量农产品价格行情"><i
                    class="icon"></i>价格行情</a></li> -->
        </ul>
    </div>
</div>

<!--品种-->
<div id="wrapper">
	<div class="leftlinebox">
	<c:forEach items="${threeClas}" var="firstClas"  varStatus="status">
		<div class="linebox clear">
		    <div class="floor-left">
		        <div class="floor-tit blackbg">
		            <span class="floor-num">${status.index+1 }F</span>
		            <span class="floor-txt">${firstClas.clasName }</span>
		        </div>
		       <ul><a href="#"><img class="clasImg" src="${firstClas.clasImage }"></a></ul>
		    </div>	   
		    
			<div class="floor-box">
			   	 <c:forEach items="${firstClas.agriculClases}" var="secondClas">
			        <dl class="clas">
			            <dt style="background:transparent ${secondClas.clasIcom } no-repeat scroll;" ><a href="" target="_top">${secondClas.clasName }</a></dt>    
			                <c:forEach items="${secondClas.agriculClases}" var="thirdClas">
			                	 <dd><a href="" target="_top" title="${thirdClas.clasName}">${thirdClas.clasName}</a></dd>
			                </c:forEach>
			            <dd><a class="org" href="" target="_top" title="更多农产品详情">更多&gt;&gt;</a></dd>
			        </dl>     
		        </c:forEach>  
		    </div>
		    
		</div>
	</c:forEach>
	</div>
<div class="right">
    <div class="notice" id="notice_panel">
        <ul class="notice-tabs">
            <li id="ntab-01" class="current">惠农公告</li>
            <li id="ntab-02">常见问题</li>
        </ul>
        <ul style="display: block;" id="ncon-01" class="notice-area">
            <li><a href="" target="_top" title="2015惠农电商评选盛典正式开启！">【公告】2015惠农电商评选盛典正式开启！</a>
            </li>
            <li><a href="" target="_top" title="辣椒专题，实力商家火辣来袭！">【公告】辣椒专题，实力商家火辣来袭！</a>
            </li>
            <li><a href="" target="_top" title="百果之冠 枣来到！">【公告】百果之冠 枣来到！</a>
            </li>
            <li><a href="" target="_top" title="全民总动员，惠农网积分上线啦！">【公告】全民总动员，惠农网积分上线啦！</a>
            </li>
        </ul>
        <ul style="display: none;" id="ncon-02" class="notice-area">
            <li><a href="" target="_top" title="简单几步，轻松注册">【常见问题】注册新用户</a></li>
            <li><a href="" target="_top" title="点击查看找回密码流程">【常见问题】忘记密码</a></li>
            <li><a href="" target="_top" title="发布产品，轻松实现在线交易">【常见问题】发布产品</a>
            </li>
            <li><a href="" target="_top" title="向买家发布报价，把握精准客户">【常见问题】发布报价</a>
            </li>
        </ul>
    </div>
    <script type="text/javascript">
        //切换“公告”和“问题”
        $("#ntab-01").hover(function(){
            $("#ntab-02").removeClass("current");
            $("#ncon-02").hide();
            $(this).addClass("current");
            $("#ncon-01").show();
        },function(){
        });
        $("#ntab-02").hover(function(){
            $("#ntab-01").removeClass("current");
            $("#ncon-01").hide();
            $(this).addClass("current");
            $("#ncon-02").show();
        },function(){
        });
    </script>

    <!-- 已登陆 -->
    <div class="ct-l-r" style="display: none;" id="userinfo_panel">
        <p><span>欢迎您！</span><span class="name"></span></p>

        <p id="logos"><span>账户状态：</span>
        </p>

        <p class="c-grey">本次登录时间:<font id="logonTime"></font></p>

        <p class="button-box">
            <input class="button" value="进入我的惠农" onclick="document.location.href= 'http://hnuser.cnhnb.com/myhn/index' "
                   type="button">
        </p>
    </div>
    <!--未登录-->
    <div id="welcome_panel" class="ct-l-r">
        <p><span class="welcome">襄阳市惠农谷欢迎您！</span></p>
    </div>
    <ul id="releaseNoLogin" class="release">
        <li class="twNoLogin"><a href="front/user/register.action" title="马上注册，共享无限农业商机">免费注册</a>
        </li>
        <li class="phoneNoLogin"><a href="front/user/login.action"
                                    title="马上登录，享受更多会员专享服务">登&nbsp;&nbsp;&nbsp;&nbsp;录</a></li>
        <li class="cp"><a href=""
                          target="_top" title="点击免费发布农产品供应信息" rel="nofollow">发布产品</a></li>
        <li class="qg"><a href=""
                          target="_top" title="点击发布农产品求购信息" rel="nofollow">发布求购</a></li>
    </ul>


</div>
<!--底部友情链接-->
<div class="txtScroll-top">
    <h3 class="txtScroll-nav">友情链接：</h3>
    <div class="bd">
        <div class="tempWrap" style="overflow: hidden; position: relative; height: 24px;">
            <ul style="top: 0px; position: relative; padding: 0px; margin: 0px;" class="infoList">
                <li style="height: 24px;">
                    <a target="_top" title="水果批发网" href="http://www.114guoshu.com/">水果批发网</a>
                    <a target="_top" title="茶叶网" href="http://www.sumcl.com/">茶叶网</a>
                    <a target="_top" title="兔毛论坛" href="http://www.tumao.com.cn/">兔毛论坛</a>
                    <a target="_top" title="中国养殖网" href="http://yangzhi.huangye88.com/">中国养殖网</a>
                    <a target="_top" title="苗木网" href="http://www.cx987.cn/">苗木网</a>
                    <a target="_top" title="养猪网" href="http://www.pigol.cn/">养猪网</a>
                    <a target="_top" title="苗木网" href="http://www.miaomuzhan.com/">苗木网</a>
                    <a target="_top" title="大蒜价格行情网" href="http://www.51garlic.com/">大蒜价格行情网</a>
                    <a target="_top" title="中国畜牧网" href="http://www.ppxmw.com/">中国畜牧网</a>
                    <a target="_top" title="生猪价格行情预测" href="http://www.shengzhujiage.com/">生猪价格行情预测</a>
                </li>
                <li style="height: 24px;">
                    <a target="_top" title="土地流转网" href="http://www.tuliu.com/">土地流转网</a>
                    <a target="_top" title="生猪价格网" href="http://www.pig66.com/">生猪价格网</a>
                    <a target="_top" title="养殖网" href="http://www.qnong.com.cn/">养殖网</a>
                    <a target="_top" title="土地流转网" href="http://www.tdzyw.com/">土地流转网</a>
                    <a target="_top" title="康美中药网" href="http://www.kmzyw.com.cn/">康美中药网</a>
                    <a target="_top" title="中国茶网" href="http://www.zgchawang.com/">中国茶网</a>
                    <a target="_top" title="农村网" href="http://www.cuncunle.com/">农村网</a>
                    <a target="_top" title="中国农药第一网" href="http://www.nongyao001.com/">中国农药第一网</a>
                </li>
            </ul>
        </div>
    </div>
    <p class="txtScroll-more"><a href="" target="_bank">更多&gt;&gt;</a></p>
</div>

</div>
</div>
<!--版权声明-->
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
