/**
 * 发布信息
 */

function regSubmit(formName) {
    if(validateAll()){
    	$("#status").val('2');
        window.document.forms[formName].submit();
        return true;
    }
    return false;
}

function validateAll() {
    ret = testInfoTitle()&&testClass()&&testDate()&&testContact()&&testMobile()&&testPcc();
    return ret;
}
//验证信息标题
function testInfoTitle(){
    if($("#infoTitle").val()==""){
        windows_open(1,"请填写信息标题!");
        $("#infoTitle").focus();
        return false;
    };
    if($("#infoTitle").val().length>25){
        windows_open(1,"信息标题请不要超过25个字!");
        $("#infoTitle").focus();
        return false;
    }
    return true;
}
//验证品种
function testClass(){
    if($("#first").val()==""||$("#second").val()==""||$("#third").val()==""){
        windows_open(1,"请选择完整的农产品分类!");
        $("#first").focus();
        return false;
    }
    return true;
}

//验证有效时期
function testDate(){
    if($("#date1").val()==""||$("#date2").val()==""){
        windows_open(1,"请填写有效期限!");
        return false;
    }
    return true;
}
//txtMov验证手机号码
function testMobile(){
    var value=$("#txtMov").val();
//    var regPartton = /^[1-11]\d{12}$/;
    var regPartton = /^[1][3-8]+\\d{9}$/;
    if (value == "" || parseInt(value) == 0) {
        windows_open(1,"请填写手机号码!");
        $("#txtMov").focus();
        return false;
    }
   
//    if (!regPartton.test(value)) {
//        windows_open(1,"请填写正确的手机号码!");
//        $("#txtMov").focus();
//        return false;
//    }
    return true;
}
//验证联系人
function testContact(){
    var value=$("#txtContact").val();
    var regPartton = /^[\u4E00-\u9FA5A-Za-z0-9_]+$/;
    if (value == "" ||parseInt(value) == 0) {
        windows_open(1,"请填写联系人!");
        $("#txtContact").focus();
        return false;
    }
    if (!lengthCN(value, 4, 20) || !regPartton.test(value)) {
        windows_open(1,"用户名必须由2-10个中文字符或4-20个英文字符或下划线_组成！");
        $("#txtContact").focus();
        return false;
    }
    return true;
}
//province  city  county
//验证期望货源地
function testPcc(){
    if($("#province").val()==""||$("#city").val()==""||$("#area").val()==""){
        windows_open(1,"请填写完整的区域信息!");
        return false;
    }
    return true;
}
//限制中英混合字符串长度在一定范围内
function lengthCN(str, minLength, maxLength) {
    var len = 0;
    for (var i = 0; i < str.length; i++) {
        var c = str.charCodeAt(i);
        //单字节加1（英文单字节，中文双字节）
        if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
            len++;
        }
        else {
            len += 2;
        }
    }
    if (len >= minLength && len <= maxLength) {
        return true;
    } else {
        return false;
    }
}

