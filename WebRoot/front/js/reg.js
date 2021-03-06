﻿// JavaScript Document

var INFO_MSG_INDEX = 2;
var ERROR_MSG_INDEX = 3;

var LI_LENGTH = 4;

var NODE_TYPE_ELEMENT = 1;

var TR_CLASS_NAME = "tr";

var SELECTED_TR_CLASS_NAME = "tr tr_selected";

function init() {
	var ul = window.document.getElementById("frame");
	var liNodes = ul.getElementsByTagName("li");
	var len = liNodes.length;
	for ( var i = 0; i < len; i++) {
		var trNode = liNodes.item(i);
		if (trNode.nodeType == NODE_TYPE_ELEMENT
				&& (trNode.className == TR_CLASS_NAME || trNode.className == SELECTED_TR_CLASS_NAME)) {

			trNode.className = TR_CLASS_NAME;
			var msgNodes = trNode.getElementsByTagName("li");
			if (msgNodes.length == LI_LENGTH) {
				msgNodes.item(INFO_MSG_INDEX).style.visibility = "hidden";
			}
		}
	}
}

function selectTr(index, msg) {
	init();
	var ul = window.document.getElementById("frame");
	var activedNode = ul.getElementsByTagName("li").item(index);
	activedNode.className = SELECTED_TR_CLASS_NAME;

	var activeMsgNodes = activedNode.getElementsByTagName("li");
	if (activeMsgNodes.length == LI_LENGTH) {
		activeMsgNodes.item(INFO_MSG_INDEX).style.visibility = "visible";
        activedNode.getElementsByTagName("input").item(0).style.border="1.5px solid #F47A11";
		activeMsgNodes.item(INFO_MSG_INDEX).innerHTML = msg;
		activeMsgNodes.item(ERROR_MSG_INDEX).style.visibility = "hidden";
        activedNode.getElementsByTagName("span").item(0).style.visibility="hidden";
        activedNode.getElementsByTagName("img").item(0).style.visibility="hidden";
	}

}

function oneOK(index){
    var ul = window.document.getElementById("frame");
    var activedNode = ul.getElementsByTagName("li").item(index);
    activedNode.getElementsByTagName("input").item(0).style.border="1px solid #a5a5a5";
    activedNode.getElementsByTagName("img").item(0).style.visibility="visible";
}

function validateMail(index) {

	var mail = window.document.getElementById("txtMail").value;

	if (checkEmpty(mail)) {
		showErrMsg(index, ERR_MSG_EMPTY_EMAIL);
		return false;
	}
	if (!checkEmail(mail)) {
		showErrMsg(index, ERR_MSG_FORMAT_EMAIL);
		return false;
	}
    oneOK(index);
	return true;
}

function validatePassword(index) {

	var pwd = window.document.getElementById("txtPassword").value;

	if (checkEmpty(pwd)) {
		showErrMsg(index, ERR_MSG_EMPTY_PWD);
		return false;
	}
	if (!checkRange(pwd, 6, 20)) {
		showErrMsg(index, ERR_MSG_LENGTH_PWD);
		return false;
	}
    oneOK(index)
	return true;
}

function validateRePassword(index) {

	var pwd = window.document.getElementById("txtPassword").value;
	var repwd = window.document.getElementById("txtRePassword").value;

	if (checkEmpty(repwd)) {
		showErrMsg(index, ERR_MSG_EMPTY_REPWD);
		return false;
	}
	if (repwd != pwd) {
		showErrMsg(index, ERR_MSG_EQUAL_REPWD);
		alert
		return false;
	}
    oneOK(index)
	return true;
}

function validateRegName(index) {
	var reg = window.document.getElementById("txtRegName").value;

	if (checkEmpty(reg)) {
		showErrMsg(index, ERR_MSG_EMPTY_REGNAME);
		return false;
	}
	if (!checkRange(reg, 1, 20)) {
		showErrMsg(index, ERR_MSG_LENGTH_REGNAME);
		return false;
	}
    oneOK(index)
	return true;
}

function validateCode(index) {

    var code = window.document.getElementById("txtCode").value;

    if (checkEmpty(code)) {
        showErrMsg(index, ERR_MSG_EMPTY_CODE);
        return false;
    }
    oneOK(index)
    return true;
}

function showErrMsg(index, msg) {
	var ul = window.document.getElementById("frame");

	var activedNode = ul.getElementsByTagName("li").item(index);
	var activeMsgNodes = activedNode.getElementsByTagName("li");

	if (activeMsgNodes.length == LI_LENGTH) {
		activedNode.className = "tr";
		activeMsgNodes.item(INFO_MSG_INDEX).style.visibility = "hidden";
        activedNode.getElementsByTagName("img").item(0).style.visibility="hidden";
		activeMsgNodes.item(ERROR_MSG_INDEX).style.visibility = "visible";
        activedNode.getElementsByTagName("span").item(0).style.visibility = "visible";
        activedNode.getElementsByTagName("input").item(0).style.border="1px solid #ff9a9a";
	}

	if (msg === null || msg == "") {
		return;
	}

	activeMsgNodes.item(ERROR_MSG_INDEX).innerHTML = msg;
}


function regSubmit(formName) {
		if(validateAll())
			return true;
        return false;
}
	
function validateAll() {
    ret = validateRegName(0)&&validateMail(5)&&validatePassword(10)&&validateRePassword(15);
    //&&validateCode(20);
    return ret;
}
	
function regfreshCode() {
	var refreshIndex = Math.random();
	window.document.getElementById("imgCode").src="code.action?" + refreshIndex;
	
}