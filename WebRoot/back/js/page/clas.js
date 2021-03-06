var kind = false;

$(function() {
	initOrderGrid();
});

function initOrderGrid() {
	$("#orderGrid")
			.datagrid(
					{
						title : '品种信息列表',
						nowrap : true,
						striped : true,
						fitColumns : true,
						fit : true,
						url : rootPath + "/back/clas/getClasList.action",
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
								}],
								idField : 'clasId',
							    columns : [ [ {
							    field : 'clasName',
							    title : '品种名称',
							    width : 100,
							    align:'center'
							}, {
							    field : 'clasIcom',
							    title : '图标',
							    width : 120,
							    align:'center'
							},{
							    field : 'clasImage',
							    title : '图片',
							    width : 120,
							    align:'center'
							}, {
							    field : 'status',
							    title : '品种状态',
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
							    field : 'levelCode',
							    title : '层级编码',
							    width : 50,
							    align:'center'
							}, {
							    field : 'parentName',
							    title : '父品种',
							    width : 80,
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
