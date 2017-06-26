<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/back/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>功能管理</title>
<%@ include file="/back/include/res.jsp"%>
<script type="text/javascript">
	var isAdmin = '${isAdmin}';
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',border:false,fit:true"
		style="padding: 3px;">		
		<div class="easyui-layout" fit="true">
			<div data-options="region:'center',border:false"
				style="padding-top: 3px;">
				<table id="orderGrid"></table>
			</div>
		</div>
	</div>

	<!-- 功能弹出框  begin -->
	<div id="orderDialog" class="easyui-dialog"
		style="width: 360px; height: 230px; margin: auto auto; padding: 1px"
		resizable="true" closed="true" modal="true">
		<form id="orderForm" method="post" class="ajaxform">
			<input id="functionId" name="functionId" type="hidden">
			<table cellpadding="1" cellspacing="1" class="form">
				<tr>
					<th style="width: 100px">功能名称：</th>
					<td><input name="functionName" id="functionName" type="text"
						style="width: 140px;" class="easyui-validatebox" maxlength="30"
						validType="length[0,30]" required="true"></td>
				</tr>
				<tr>
					<th style="width: 100px">访问路径：</th>
					<td><input name="funUrl" id="funUrl" type="text"
						style="width: 140px;" class="easyui-validatebox" maxlength="30"
						validType="length[0,50]" required="true"></td>
				</tr>
				<tr>
					<th style="width: 100px">功能状态：</th>
					<td><input name="funStatus" id="funStatus"
						style="width: 140px;" panelHeight ="50px"></td>
				</tr>
				<tr>
					<th style="width: 100px">层级编码：</th>
					<td><input name="levelCode" id="levelCode" 
						style="width: 140px;"></td>
				</tr>
				<tr>
					<th style="width: 100px">父功能：</th>
					<td><input name="parentName" id="parentName" 
						style="width: 140px;"></td>
				</tr>
				<tr>
					<th style="width: 100px">排序号：</th>
					<td><input name="orderNum" id="orderNum" 
						style="width: 140px;"></td>
				</tr>
			</table>
		</form>
		<div align="center" style="margin-top: 5px; margin-bottom: 5px;">
			<a class="easyui-linkbutton" onclick="accidentSaveOrder();">保存</a> <a
				class="easyui-linkbutton"
				onclick="$('#orderDialog').dialog('close')">关闭</a>
		</div>
	</div>
	<!-- 出险单弹出框  end -->

	<!-- 派工管理弹出框  begin -->
	<div id="employeeDialog" class="easyui-dialog"
		style="width: 320px; height: 135px; margin: auto auto; padding: 1px"
		resizable="true" closed="true" modal="true">
		<form id="employeeForm" method="post" class="ajaxform">
			<input id="id" name="id" type="hidden">
			<table cellpadding="1" cellspacing="1" class="form">
				<tr>
					<th style="width: 100px">外派人员：</th>
					<td><input name="employee" id="employee" style="width: 140px;"></td>
				</tr>
			</table>
		</form>
		<div align="center" style="margin-top: 15px; margin-bottom: 5px;">
			<a class="easyui-linkbutton" onclick="accidentSetEmployee();">保存</a>
			<a class="easyui-linkbutton"
				onclick="$('#employeeDialog').dialog('close')">关闭</a>
		</div>
	</div>
	<!-- 派工管理弹出框  end -->

	<script type="text/javascript"
		src="<c:url value='/back/js/page/function.js'/>"></script>
</body>
</html>