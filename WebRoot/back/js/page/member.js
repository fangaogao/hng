var kind = false;

$(function() {
	initOrderGrid();
});

function initOrderGrid() {
	$("#orderGrid")
			.datagrid(
					{
						title : '会员信息列表',
						nowrap : true,
						striped : true,
						fitColumns : true,
						fit : true,
						url : rootPath + "/back/member/getMemberList.action",
						remoteSort : false,
						singleSelect : true,
						pageNumber : 1,
						toolbar : [
								{
									id : 'btnAddOrder',
									text : '新增',
									iconCls : 'icon-add',
									handler : function() {
										kind = true;
										$('#orderForm').form('clear');
										$('#orderDialog').dialog('setTitle',
												"新增功能");

										$("#funStatus").val('1');
										$("#funStatus").combobox({
											editable : false,
											data : [ {
												value : '1',
												text : '启用'
											}, {
												value : '0',
												text : '禁用'
											} ]
										});

										$('#orderDialog').dialog('open');
									}
								},
								'-',
								{
									id : 'btnEditOrder',
									text : '修改',
									iconCls : 'icon-edit',
									handler : function() {
										kind = true;
										var row = $('#orderGrid').datagrid(
												'getSelected');
										if (row != null) {

											$("#orderForm").form('clear');
											$("#funStatus").combobox({
                                                editable : false,
                                                data : [ {
    												value : '1',
    												text : '启用'
    											}, {
    												value : '0',
    												text : '禁用'
    											} ]
											});
											$('#orderForm')
													.form(
															'load',
															{
                                                                roleId : row.roleId,
                                                                roleName : row.roleName,
                                                                roleStatus : row.roleStatus,
                                                                levelCode : row.levelCode,
                                                                orderNum : row.orderNum
															});
											$('#orderDialog').dialog(
													'setTitle', "修改功能信息");
											$('#orderDialog').dialog('open');
										} else {
											$.messager.alert("提示",
													"请选择需要修改的功能", "info");
										}
									}
								},								
								'-',
								{
									id : 'btnRemoveOrder',
									text : '删除',
									iconCls : 'icon-remove',
									handler : function() {
										var row = $('#orderGrid').datagrid(
												'getSelected');
										if (row != null) {
											delGrid(
													$("#orderGrid"),
													rootPath
															+ "/accident/delById.do?orderId="
															+ row.id);
										} else {
											$.messager.alert("提示",
													"请选择需要删除的功能", "info");
										}
									}
								},
								'-',
								{
									id : 'btnEditOrder',
									text : '修改账户信息',
									iconCls : 'icon-edit',
									handler : function() {
										kind = true;
										var row = $('#orderGrid').datagrid(
												'getSelected');
										if (row != null) {

											$("#orderForm").form('clear');
											$("#funStatus").combobox({
                                                editable : false,
                                                data : [ {
    												value : '1',
    												text : '启用'
    											}, {
    												value : '0',
    												text : '禁用'
    											} ]
											});
											$('#orderForm')
													.form(
															'load',
															{
                                                                roleId : row.roleId,
                                                                roleName : row.roleName,
                                                                roleStatus : row.roleStatus,
                                                                levelCode : row.levelCode,
                                                                orderNum : row.orderNum
															});
											$('#orderDialog').dialog(
													'setTitle', "修改功能信息");
											$('#orderDialog').dialog('open');
										} else {
											$.messager.alert("提示",
													"请选择需要修改的功能", "info");
										}
									}
								},'-',
								{
									id : 'btnAuditOrder',
									text : '个人实名认证',
									iconCls : 'icon-tip',
									handler : function() {
										var row = $('#orderGrid').datagrid(
												'getSelected');
										if (row != null) {
											if (row.employeeName != "") {
												$.messager.alert("提示",
														"出险单已派工", "info");
												return;
											}
											if (row.reportState == 0) {
												$.messager.alert("提示",
														"请将出险信息先报案！", "info");
												return;
											}
											$("#employeeForm").form('clear');
											$('#employeeForm').form('load', {
												id : row.id
											});
											$('#employee')
													.combobox(
															{
																url : rootPath
																		+ "/employee/getEmlpoyee.do",
																valueField : 'id',
																textField : 'name',
																editable : false
															});
											$('#employeeDialog').dialog(
													'setTitle', "人员外派管理");
											$('#employeeDialog').dialog('open');
										} else {
											$.messager.alert("提示",
													"请选择需要外派处理的出险单", "info");
										}
									}
								} ,'-',
								{
									id : 'btnAuditOrder',
									text : '企业实名认证',
									iconCls : 'icon-tip',
									handler : function() {
										var row = $('#orderGrid').datagrid(
												'getSelected');
										if (row != null) {
											if (row.employeeName != "") {
												$.messager.alert("提示",
														"出险单已派工", "info");
												return;
											}
											if (row.reportState == 0) {
												$.messager.alert("提示",
														"请将出险信息先报案！", "info");
												return;
											}
											$("#employeeForm").form('clear');
											$('#employeeForm').form('load', {
												id : row.id
											});
											$('#employee')
													.combobox(
															{
																url : rootPath
																		+ "/employee/getEmlpoyee.do",
																valueField : 'id',
																textField : 'name',
																editable : false
															});
											$('#employeeDialog').dialog(
													'setTitle', "人员外派管理");
											$('#employeeDialog').dialog('open');
										} else {
											$.messager.alert("提示",
													"请选择需要外派处理的出险单", "info");
										}
									}
								} ],
							idField : 'memberId',
							    columns : [ [ {
							    field : 'memberName',
							    title : '会员名称',
							    width : 50,
							    align:'center'
							}, {
							    field : 'loginName',
							    title : '登录名',
							    width : 50,
							    align:'center'
							},{
							    field : 'companyName',
							    title : '所属企业',
							    width : 80,
							    align:'center'
							},{
							    field : 'completeAddress',
							    title : '所在地',
							    width : 100,
							    align:'center'
							},{
							    field : 'phone',
							    title : '手机号码',
							    width : 80,
							    align:'center'
							},{
							    field : 'email',
							    title : '邮箱',
							    width : 80,
							    align:'center'
							},{
							    field : 'qq',
							    title : 'QQ',
							    width : 80,
							    align:'center'
							},{
							    field : 'headImg',
							    title : '头像',
							    width : 50,
							    align:'center'
							}, {
							    field : 'memberStatus',
							    title : '账户状态',
							    width : 50,
							    formatter : function(value, row, index) {
							        switch (value.trim()) {
							            case "0":
							                return "禁用";
							            case '1':
							                return "启用";
							            default:
							                return "未设置";
							        }
							    },
							    align:'center'
							}, {
							    field : 'certificationStatus',
							    title : '认证状态',
							    width : 50,
							    formatter : function(value, row, index) {
							        switch (value.trim()) {
							            case "0":
							                return "未认证";
							            case '1':
							                return "邮箱认证";
							            case '2':
							                return "个人认证";
							            case '1':
							                return "企业认证";
							            default:
							                return "未设置";
							        }
							    },
							    align:'center'
							} ] ],
						// 无刷新分页
						pagination : true,
						rownumbers : true
					});
}

//保存订单
function accidentSaveOrder() {
	if (!$("#orderForm").form('validate')) {
		return;
	}
	$('#orderForm').form('submit', {
		url : rootPath + "/accident/save.do",
		onSubmit : function() {
		},
		success : function(data) {
			data = JSON.parse(data);
			if (data.status == "success") {
				$.messager.alert("提示", "操作成功!", "info");
				$('#orderGrid').datagrid('reload');
				$('#orderDialog').dialog('close');
			} else {
				$.messager.alert("提示", data.msg, "info");
			}
		}
	});
}
//设置派工人员
function accidentSetEmployee() {
	if (!$("#employeeForm").form('validate')) {
		return;
	}
	$('#employeeForm').form('submit', {
		url : rootPath + "/employee/setEmployee.do",
		onSubmit : function() {
		},
		success : function(data) {
			data = JSON.parse(data);
			if (data.status == "success") {
				$.messager.alert("提示", "操作成功!", "info");
				$('#orderGrid').datagrid('reload');
				$('#employeeDialog').dialog('close');
			} else {
				$.messager.alert("提示", data.msg, "info");
			}
		}
	});
}

// 点击查询数据
function accidentQueryData() {
	if (!$("#queryForm").form('validate')) {
		return;
	}
	var qOrderNum = $("#qOrderNum").val();
	var reportState = $("#reportState").combobox("getValue");
	var cusName = $("#cusName").val();

	var queryTypeParams = $('#orderGrid').datagrid('options').queryParams;
	queryTypeParams.orderNum = qOrderNum;
	queryTypeParams.reportState = reportState;
	queryTypeParams.cusName = cusName;

	reloaGrid($('#orderGrid'), queryTypeParams);
}

// 重置列表
function accidentResetAndLoad() {
	$("#queryForm").form('clear');
	accidentQueryData();
}

function reloaGrid($table, queryParams) {
	$table.datagrid('options').queryParams = queryParams;
	$table.datagrid("options").pageNumber = 1;
	$table.datagrid("getPager").pagination({
		pageNumber : 1
	});
	$table.datagrid("clearSelections");
	$table.datagrid("reload");
}
