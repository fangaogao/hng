var kind = false;

$(function() {
	initOrderGrid();
});

function initOrderGrid() {
	$("#orderGrid")
			.datagrid(
					{
						title : '求购信息列表',
						nowrap : true,
						striped : true,
						fitColumns : true,
						fit : true,
						url : rootPath + "/back/buyInfo/getBuyInfoList.action",
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
								},'-',
								{
									id : 'btnAuditOrder',
									text : '信息详情',
									iconCls : 'icon-search',
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
									id : 'btnAuditOrder',
									text : '审核',
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
								}  ],
							idField : 'buyId',
							    columns : [ [ {
							    field : 'buyTitle',
							    title : '求购标题',
							    width : 100,
							    align:'center'
							}, {
							    field : 'memberName',
							    title : '发布人',
							    width : 50,
							    align:'center'
							},{
							    field : 'agriculClasName',
							    title : '种类',
							    width : 50,
							    align:'center'
							}, {
							    field : 'minQuantity',
							    title : '数量',
							    width : 80,
							    formatter : function(value, row, index) {
							       return row.minQuantity+'-'+row.maxQuantity+'/'+row.quantityUnit;
							    },
							    align:'center'
							}, {
							    field : 'minPrice',
							    title : '价格',
							    width : 80,
							    formatter : function(value, row, index) {
							       return row.minPrice+'-'+row.maxPrice+'/元';
							    },
							    align:'center'
							}
							,{
							    field : 'completeAddress',
							    title : '所在地',
							    width : 100,
							    align:'center'
							},{
							    field : 'publishDate',
							    title : '发布日期',
							    width : 80,
							    align:'center'
							},{
							    field : 'expiryInterval',
							    title : '有效期',
							    width : 50,
							    align:'center'
							},{
							    field : 'expiryDate',
							    title : '截止日期',
							    width : 80,
							    align:'center'
							},{
							    field : 'accessTimes',
							    title : '访问次数',
							    width : 50,
							    align:'center'
							},{
							    field : 'collectTimes',
							    title : '收藏次数',
							    width : 50,
							    align:'center'
							}, {
							    field : 'status',
							    title : '信息状态',
							    width : 50,
							    formatter : function(value, row, index) {
							        switch (value.trim()) {
							            case "0":
							                return "已删除";
							            case '1':
							                return "草稿箱";
							            case '2':
							                return "审核中";
							            case '3':
							                return "审核不通过";
							            case '4':
							                return "发布中";
							            case '5':
							                return "已结束";
							            default:
							                return "未设置";
							        }
							    },
							    align:'center'
							}] ],
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
