<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    <title>我的惠农首页</title>
    <script type="text/javascript" src="front/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="front/js/iframe.js"></script>
    <!--公用弹窗JS-->
    <script type="text/javascript">
        var init = {
            userWebUrl: "",
            email: "",
            mobile: "13098455884",
            account: "",
            type: "",
            name: "",
            userPic: "",
            imgUrl: ""
        }
    </script>
    <!--页面事件-->
    <script type="text/javascript" src="front/js/myindex.js"></script>

    <link rel="stylesheet" type="text/css" href="front/css/myindex.css" media="all">
</head>
<body>
<!-- Content Start -->
<div class="content">
    <div class="con-top">
        <div class="ct_l">
            <a href="">
            	<c:if test="${empty member.headImg  }"><img src="front/images/myhn-sclogo.jpg" alt="上传logo" width="66" height="66"></c:if>
                <c:if test="${!empty member.headImg }"><img src="${member.headImg }" alt="上传logo" width="66" height="66"></c:if>
            </a>
            <div class="ct-l-r mt_10">
                <p>欢迎您： <b class="fr_r">${user.loginName }</b></p>
                <p><span>账户状态：</span>
                	<c:choose>
                		<c:when test="${member.certificationStatus==0 }">未认证</c:when>
                		<c:when test="${member.certificationStatus==1 }">
                			<i class="identity email" title="邮箱认证"></i>
                		</c:when>
                		<c:when test="${member.certificationStatus==2 }">
	                		 <i class="identity email" title="邮箱认证"></i>
	                    	 <i class="identity realName" title="实名认证"></i>
                		</c:when>
                		<c:when test="${member.certificationStatus==3 }">
	                		<i class="identity email" title="邮箱认证"></i>
	                    	<i class="identity realName" title="实名认证"></i>
	                    	<i class="identity company" title="企业认证"></i>
                		</c:when>
                		<c:otherwise>未认证</c:otherwise>
                	</c:choose>
                    
                </p>
            </div>
            <div class="clear"></div>
        </div>
        <div class="ct_r">
            <p class="fs_14">
                <span class="home-name">注意：您的账户尚未绑定邮箱，可能存在账户安全隐患</span>
                <a id="w3" href="javascript:void(0);">立即绑定邮箱</a>
            </p>
            <p class="fs_14">
                <span class="home-name">注意：您的账户尚未个人实名认证，可能会降低搜索排名</span>
                <a id="w3-2" href="javascript:void(0);">立即个人认证</a>
            </p>
            <p class="fs_14">
                <span class="home-name">注意：您的账户尚未企业实名认证，可能会降低搜索排名</span>
                <a id="w3-3" href="javascript:void(0);">立即企业认证</a>
            </p>
        </div>
    </div>
    <div class="con-left">
        <div class="con-left-label">
            <ul>
                <li class="con-left-label-item">审核前</li>
                <li class="con-left-label-item">审核中</li>
                <li class="con-left-label-item">审核后</li>
            </ul>
        </div>
        <div class="con-left-content">
            <ul class="con-left-content-purchase">
                <a href="#"><li class="con-left-content-purchase-icon1">采购</li></a>
                <li class="con-left-content-purchase-start">
                    <ul>
                        <li><a href="javascript:void(0);" id="replying">草稿箱(<span id="noreply">0</span>)</a></li>
                     </ul>
                </li>
                <li class="con-left-content-purchase-doing">
                    <ul>
                        <li><a href="javascript:void(0);" id="waitpay">审核中(<span id="sellpay">0</span>)</a></li>
                        <li><a href="javascript:void(0);" id="waitconsignment">审核不通过(<span id="sellconsignment">0</span>)</a>
                        </li>
                    </ul>
                </li>
                <li class="con-left-content-purchase-end">
                    <ul>
                        <li><a href="javascript:void(0);" id="waitconsignee">报价中(<span
                                id="sellconsignee">0</span>)</a></li>
                        <li><a href="javascript:void(0);" id="backing">已结束(<span id="back">0</span>)</a></li>
                    </ul>
                </li>
            </ul>


        </div>

        <div class="con-left-label">
            <ul>
                <li class="con-left-label-item">审核前</li>
                <li class="con-left-label-item">审核中</li>
                <li class="con-left-label-item">审核后</li>
            </ul>
        </div>
        <div class="con-left-content">
            <ul class="con-left-content-purchase">
                <a href="#"><li class="con-left-content-purchase-icon2">供应</li></a>
                <li class="con-left-content-purchase-start">
                    <ul>
                        <li><a href="javascript:void(0);">草稿箱(<span>0</span>)</a></li>
                    </ul>
                </li>
                <li class="con-left-content-purchase-doing">
                    <ul>
                        <li><a href="javascript:void(0);">审核中(<span >0</span>)</a></li>
                        <li><a href="javascript:void(0);" >审核不通过(<span>0</span>)</a>
                        </li>
                    </ul>
                </li>
                <li class="con-left-content-purchase-end">
                    <ul>
                        <li><a href="javascript:void(0);">询价中(<span
                                >0</span>)</a></li>
                        <li><a href="javascript:void(0);">已结束(<span >0</span>)</a></li>
                    </ul>
                </li>
            </ul>

        </div>
    </div>

    <div class="con-right">
        <div class="con-right-header">
            <div class="con-right-header-title">公告</div>
            <div class="con-right-header-op"><span class="con-right-date">1-28 星期四</span></div>
        </div>
        <div class="con-right block">
            <ul class="con-right-list">

                <li><a target="_top" href="http://hnuser.cnhnb.com/message/notice/59" class="con-right-list-item"
                       title="2015年惠农网农业电商评选获奖名单">

                    2015年惠农网农业电商评选获奖名...


                </a>
                </li>

                <li><a target="_top" href="http://hnuser.cnhnb.com/message/notice/58" class="con-right-list-item"
                       title="年终苹果盛宴，颗颗精选！">


                    年终苹果盛宴，颗颗精选！

                </a>
                </li>

                <li><a target="_top" href="http://hnuser.cnhnb.com/message/notice/57" class="con-right-list-item"
                       title="囤货过大年，年货专题火热上线！">


                    囤货过大年，年货专题火热上线！

                </a>
                </li>

                <li><a target="_top" href="http://hnuser.cnhnb.com/message/notice/56" class="con-right-list-item"
                       title="声明:不法分子冒充主办方刷票">


                    声明:不法分子冒充主办方刷票

                </a>
                </li>

                <li><a target="_top" href="http://hnuser.cnhnb.com/message/notice/55" class="con-right-list-item"
                       title="2015惠农电商评选盛典正式开启！">


                    2015惠农电商评选盛典正式开启！

                </a>
                </li>

                <li><a target="_top" href="http://hnuser.cnhnb.com/message/notice/54" class="con-right-list-item"
                       title="辣椒专题，实力商家火辣来袭！">


                    辣椒专题，实力商家火辣来袭！

                </a>
                </li>

            </ul>
        </div>
    </div>
</div>
<!-- Content End -->

</body>
</html>