<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/back/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>襄阳市惠农谷信息服务平台</title>
<%@ include file="/back/include/res.jsp"%>
<%
 response.setHeader("Pragma","No-cache");
 response.setHeader("Cache-Control","No-cache");
 response.setDateHeader("Expires", -1);
 response.setHeader("Cache-Control", "No-store");
%>
</head>
<body class="easyui-layout">

	<!--   顶部布局 开始      -->
	<div data-options="region:'north',border:false" style="height:65px;background-size:100% 100%;background:url(back/icon/logo.png);background-repeat: no-repeat">
	    <div style="text-align:left;float:left;padding-left: 50px;color:#ddeae4;">
	        <h1>襄阳市惠农谷信息服务平台</h1>
	    </div>
	    <div style="text-align:right; margin-right:50px; margin-top: 28px;font-size:13px;">
	    	欢迎您，${user.userName }&nbsp;&nbsp;&nbsp;<a style="width: 60px;" href="back/logout.action">注销</a>
	    </div>
	</div>
	<!--   顶部布局 结束      -->

	<!--   左边导航 开始      -->
	<div data-options="region:'west',split:true,title:'【系统导航】'" style="width:200px;">
	    <div class="easyui-accordion" data-options="fit:true,border:false">
	    	<c:forEach items="${funs }" var="fun1">
	    		 <div title="${fun1.functionName }" style="padding:10px;">
	    		 	<c:forEach items="${fun1.functionses }" var="fun2">
		    		 	<a class="easyui-linkbutton" data-options="plain:true" onclick="loadContent('${fun2.functionName }', '${fun2.funUrl }')">${fun2.functionName }</a>
	        			<br>
	    		 	</c:forEach>
	    		 </div>
	    	</c:forEach>
	    </div>
	</div>
	<!--   左边导航 结束      --> 

	<!--   中间布局 开始      -->
	<div data-options="region:'center'">
	   	<div id="content" class="easyui-tabs" data-options="fit:true,border:false,plain:true,">
	   		
	   	</div>
	</div>
	<!--   中间布局 结束      -->
	
	<script type="text/javascript">
		
	    function loadContent(title, url) {
	        if ($('#content').tabs('exists', title)) {
	            $('#content').tabs('select', title);
	        } else {
	            var content = '<iframe scrolling="no" frameborder="0" allowtransparency="true" src="'
	                    + url
	                    + '" style="width:100%;height:100%;margin:0;padding:0;background-color:transparent;"></iframe>';
	            $('#content').tabs('add', {
	                title : title,
	                content : content,
	                closable : true,
	                fit: true
	            });
	        }
	    }
	</script>
	
</body>
</html>