package com.hng.entity.vo;

import com.hng.entity.Functions;

public class FunctionVO {

	private Integer functionId;
	private Integer parentId;
	private String functionName;
	private String levelCode;
	private String funUrl;
	private String parentName;
	private String funStatus;
	private Integer orderNum;
	
	public FunctionVO(){}
	
	public FunctionVO(Functions fun,Integer parentId){
		this.functionId = fun.getFunctionId();
		this.parentId = parentId;
		this.functionName = fun.getFunctionName();
		this.levelCode = fun.getLevelCode();
		this.funUrl = fun.getFunUrl();
		this.parentName = fun.getParentName();
		this.funStatus = fun.getFunStatus();
		this.orderNum = fun.getOrderNum();
	}
	
	public FunctionVO(Integer functionId, Integer parentId,
			String functionName, String levelCode, String funUrl,
			String parentName, String funStatus, Integer orderNum) {
		super();
		this.functionId = functionId;
		this.parentId = parentId;
		this.functionName = functionName;
		this.levelCode = levelCode;
		this.funUrl = funUrl;
		this.parentName = parentName;
		this.funStatus = funStatus;
		this.orderNum = orderNum;
	}
	public Integer getFunctionId() {
		return functionId;
	}
	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getFunUrl() {
		return funUrl;
	}
	public void setFunUrl(String funUrl) {
		this.funUrl = funUrl;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getFunStatus() {
		return funStatus;
	}
	public void setFunStatus(String funStatus) {
		this.funStatus = funStatus;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	
	
}
