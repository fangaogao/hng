<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
{
	success:<s:property value="!hasErrors()"/>,
	errors:{
		<s:iterator value="fieldErrors.keys" status="s">
			"<s:property/>":"<s:property value='fieldErrors[top][0]'/>"<s:if test="!#s.last">,</s:if>
		</s:iterator>
	},
	fieldErrors:{
		<s:iterator value="fieldErrors.keys" status="s">
			"<s:property/>":"<s:property value='fieldErrors[top][0]'/>"<s:if test="!#s.last">,</s:if>
		</s:iterator>
	},
	actionErrors:[
		<s:iterator value="actionErrors" status="s">
			"<s:property/>"<s:if test="!#s.last">,</s:if>
		</s:iterator>
	],
	messages:[
		<s:iterator value="actionMessages" status="s">
			"<s:property escape="false"/>"<s:if test="!#s.last">,</s:if>
		</s:iterator>
	]
}