/**
 * easyui datagrid表格长文本格式化
 * @param value 单元格值
 * @param data 行数据
 * @param index 索引
 * @returns
 */
function longTextFormatter(value, data, index) {
    if (value) {
        return "<span title='" + value + "'>" + value + "</span>";
    }
    return value;
}


function sexFormatter(value, data, index) {
    if (value=="0") {
        return "女";
    }
    return "男";
}

function sdewFormatter(value, data, index) {
	    if (value=="0") {
        return "无";
    }
    if(value=="1"){
    return "车辆 损失";
}
    if(value=="2"){
    	 return "第三者责任";
    }
    if(value=="3"){
    	return "车辆损失、第三者责任";
    }
}


/**
 * easyui datagrid表格数值格式化, 保留两位小数
 * @param value 单元格值
 * @param data 行数据
 * @param index 索引
 * @returns 
 */
function currencyFormatter(value, data, index) {
    if (value == null) {
        return "";
    }
    var s = value + "";
    var s1 = s;
    var s2 = "";
    var dpos = s.indexOf(".");
    if (dpos >= 0) {
        s1 = s.substring(0, dpos);
        s2 = s.substring(dpos + 1, s.length);
    }
    var p = /(\d+)(\d{3})/;
    while (p.test(s1)) {
        s1 = s1.replace(p, "$1,$2");
    }
    for (var i = s2.length; i < 2; i ++) {
    	s2 += "0";
    }
    return s1 + "." + s2;
}

//删除表格选中数据
function delGrid($table, url, callback) {
  var selected = $table.datagrid('getSelected');
  if(selected != null) {
      $.messager.confirm('提示', '确定要删除吗？', 
              function(b) {
                  if(b) {
                      $.ajax({
                          type: "post",
                          url: url,
                          dataType: "json",
                          success: function(data) {
                              if(data.status == "success"){
                                  $.messager.alert("提示", "删除成功", 'info');
                                  //刷新表格数据
                                  $table.datagrid('clearSelections');
                                  $table.datagrid('clearChecked');
                                  $table.datagrid('reload');
                                  if (callback) {
                                	  try {
                                		  callback();
                                	  } catch (e) {
									  }
                                  }
                              } else {
                                  $.messager.alert("提示", data.msg ,'info');
                              }
                          },
                          error: function(xml, e) {
                              $.messager.alert("处理失败", "状态: " + xml.status + "\n信息: " + e ,'error');
                          }
                      });
                  }
              }
      );
  }
}

//处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外  
function banBackSpace(e) {
	var ev = e || window.event;//获取event对象     
	var obj = ev.target || ev.srcElement;//获取事件源     

	var t = obj.type || obj.getAttribute('type');//获取事件源类型    

	//获取作为判断条件的事件类型  
	var vReadOnly = obj.getAttribute('readonly');
	var vEnabled = obj.getAttribute('enabled');
	//处理null值情况  
	var bReadOnly = vReadOnly != null && vReadOnly != "";
	var bEnabled = vEnabled == null;

	//当敲Backspace键时，事件源类型为密码或单行、多行文本的，  
	//并且readonly属性为true或enabled属性为false的，则退格键失效  
	var flag1 = ev.keyCode == 8 && (t == "password" || t == "text" || t == "textarea") && (bReadOnly || !bEnabled);

	//当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效  
	var flag2 = ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea";

	//判断  
	if (flag2) {
		return false;
	}
	if (flag1) {
		return false;
	}
}

//禁止后退键 作用于Firefox、Opera  
document.onkeypress = banBackSpace;
//禁止后退键  作用于IE、Chrome  
document.onkeydown = banBackSpace;