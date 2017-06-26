<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的采购</title>

    <link rel="stylesheet" type="text/css" href="front/css/mybuy.css" media="all">
</head>
<body myhncode="MyPurchase">


<div class="main wrap">
    <!-- frame-container -->
    <div class="frame-container">

        <form action="" method="post" id="myPurchaseAction">
            <input name="pageNumber" id="pageNumber" value="1" type="hidden">
            <input id="recordCount" value="1" type="hidden">
            <input id="basePath" value="http://buy.cnhnb.com:80/" type="hidden">
            <!-- 	<input type="hidden" id="state" name="state"/> -->
            <div class="content">
                <div class="titlebar">
                    <div class="titlebar-name">我的采购</div>
                </div>
             
                <div class="my-s-a">
                    <div class="my-s-a-a">
                        <input class="my-s-a-a-s" name="title" value="" onkeypress="keypress();" placeholder="输入产品标题"
                               type="text">
                        <input class="my-s-a-a-b" value="查找" onclick="javascript:$('#myPurchaseAction').submit();"
                               type="button">
                    </div>
                 
                </div>
                <div class="my-s-b">
                    <div class="my-s-b-a">
                        <a class="cur" href="javascript:changeStatus('')" data="" id="allCount">全部(2)</a>
                        <a href="javascript:changeStatus(1)" data="1" id="">草稿箱(0)</a>
                        <a href="javascript:changeStatus(1)" data="1" id="purchaseing">采购中(1)</a>
                        <a href="javascript:changeStatus(0)" data="0" id="checking">审核中(1)</a>
                        <a href="javascript:changeStatus(2)" data="2" id="unpass">审核不通过(0)</a>
                        <a href="javascript:changeStatus(5)" data="5" id="end">已结束(0)</a>
                    </div>
                    <div class="my-s-b-b">
                        <span class="l1">&nbsp;</span>
                        <span class="l2">信息标题</span>
                        <span class="l3">发布时间</span>
                        <span class="l3">到期时间</span>
                        <span class="l4">已收到报价</span>
		                <span class="l5">
		                    <select name="status" id="status" onchange="selectStatus();">
                                <option value="" selected="selected">状态</option>
                                <option value="1">采购中</option>
                                <option value="0">审核中</option>
                                <option value="2">审核不通过</option>
                                <option value="5">已结束</option>
                            </select>
		                </span>
                        <span class="l6">操作</span>
                    </div>
                    <div class="tab1">
                        <div class="list list-inquiry">
                            <div class="list-ul">
								<c:forEach var="info" items="${buyList }" varStatus="status">
								
							
                                <ul>
                                    <li class="l1">${status.index+1 }</li>
                                    <li class="l2"><a href="front/buyInfo/getBuyInfoById.action?buyId=${info.buyId }" target="_top">${info.buyTitle }</a>
                                    </li>
                                    <li class="l3">
                                    	${info.publishDate }
										
                                    </li>
                                    <li class="l3">
										${info.expiryDate }
                                    </li>
                                    <li class="l4"><a>0</a></li>
                                    <li class="l5 msg-pop">
                                    <c:choose>
                                    	<c:when test="${info.status=='1' }">
                                    		草稿箱
                                    	</c:when>
                                    	<c:when test="${info.status=='2' }">
                                    		审核中
                                    	</c:when>
                                    	<c:when test="${info.status=='3' }">
                                    		审核不通过
                                    	</c:when>
                                    	<c:when test="${info.status=='4' }">
                                    		发布中
                                    	</c:when>
                                    	<c:when test="${info.status=='5' }">
                                    		已结束
                                    	</c:when>
                                    	<c:otherwise></c:otherwise>
                                    </c:choose>
                                       
                                    </li>

                                    <li class="l6">

                                        <a href="../show/buyInfo.html" target="_top" class="btn">删除</a>
                                        <c:if test="${info.status=='4' }">
                                        <a href="../show/buyInfo.html" target="_top" class="btn">停止</a>
                                        </c:if>
                                    </li>
                                </ul>
                              
								</c:forEach>
							
                                <!--<div class="error-box">
                                    <p class="info">未找到相关采购信息，你可以<a href="http://buy.cnhnb.com/purchase/release" style="color: rgb(244, 114, 17);" target="_top">发布采购</a></p>
                                </div>-->

                            </div>
                        </div>
                    </div>
                </div>


                <div class="cyd_page">
                    <div class="page-bottom">
                        <a href="javascript:goTOPage(1);">第一页</a>
                        <a href="javascript:goTOPage(0)" class="noselect">上一页</a>
                        <a href="javascript:goTOPage(1)" class="page_but1hover">1</a>
                         <a href="javascript:goTOPage(2)" class="last">下一页</a>
                        <a href="javascript:goTOPage(1);">最后页</a>
                    </div>
                    <div class="page-op">跳到
                        <input value="" class="page_input" id="autoNum"
                                                  onkeyup="this.value=this.value.replace(/\D/g,'')" data-max="100"
                                                  autocomplete="off" type="text">页&nbsp; <a
                            href="javascript:goTOPage($('#autoNum').val());" class="page_but2">GO</a></div>
                </div>
                <script src="hm.js"></script>
                <script>
                    function goTOPage(num) {
                        var reg = /^[0-9]*[1-9][0-9]*$/;
                        //输入的页数必须是正整数
                        if (reg.test(num)) {
                            if (num >= 1 && num <= parseInt($("#recordCount").val())) {
                                $("#pageNumber").val(num);
                                $("form:eq(0)").submit();
                            }
                        }
                    }
                </script>


                <script>
                    function goTOPage(num) {
                        var reg = /^[0-9]*[1-9][0-9]*$/;
                        //输入的页数必须是正整数
                        if (reg.test(num)) {
                            if (num >= 1 && num <= parseInt($("#recordCount").val())) {
                                $("#pageNumber").val(num);
                                $("form:eq(0)").submit();
                            }
                        }
                    }
                </script>


            </div>
        </form>

    </div>
    <!-- frame-container /-->
</div>

<script type="text/javascript" src="front/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
    function changeStatus(status) {
        $("#status").val(status);
        $("#myPurchaseAction").submit();
    }
    function selectStatus() {
        changeStatus($("#status").val());
    }
    //myPurchaseStatstics
    function getPurchaseStatistic() {
        $.ajax({
            type: "post",
            url: $("#basePath").val() + "purchase/myPurchaseStatstics",
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
                $("#willend").text(data.willend);
                $("#allCount").text("全部(" + data.allCount + ")");
                $("#purchaseing").text("采购中(" + data.purchaseing + ")");
                $("#checking").text("审核中(" + data.checking + ")");
                $("#unpass").text("审核不通过(" + data.unpass + ")");
                $("#end").text("已过期(" + data.end + ")");
            }
        });
    }
    $(document).ready(function () {
        getPurchaseStatistic();
        $('.msg-pop').each(function () {
            $(this).find('a').click(function () {
                $(this).next('.check_tips').show();
                return false;
            });
            $(this).find('.check_tips>.close').click(function () {
                $(this).parent('.check_tips').hide();
            });
        });
    });

    function deleteById(id) {
        if (id != "" && id != null) {
            if (confirm("确认删除所选采购信息么？")) {
                $.ajax({
                    url: $("#basePath").val() + "purchase/delete",
                    data: {
                        purchaseId: id
                    },
                    dataType: 'json',
                    type: 'post',
                    timeout: 5000,
                    error: function () {
                        alert("删除数据失败");
                    },
                    success: function (result) {
                        if (result.state == 1) {
                            alert("删除成功");
                            location.reload();
                        } else {
                            alert("删除失败");
                        }
                    }
                });
            }
        }
    }
    function stopById(id) {
        if (id != "" && id != null) {
            if (confirm("确认停止所选采购信息么？")) {
                $.ajax({
                    url: $("#basePath").val() + "purchase/stop",
                    data: {
                        purchaseId: id
                    },
                    dataType: 'json',
                    type: 'post',
                    timeout: 5000,
                    error: function () {
                        alert("操作失败");
                    },
                    success: function (result) {
                        if (result.state == 1) {
                            alert("操作成功");
                            location.reload();
                        } else {
                            alert("操作失败");
                        }
                    }
                });
            }
        }
    }
</script>

</body>
</html>
