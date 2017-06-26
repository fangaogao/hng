package com.hng.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Functions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "functions", catalog = "hng")
public class Functions implements java.io.Serializable {

	// Fields

	private Integer functionId;
	private Functions functions;
	private String functionName;
	private String levelCode;
	private String funUrl;
	private String parentName;
	private String funStatus;
	private Integer orderNum;
	private Set<RoleFunction> roleFunctions = new HashSet<RoleFunction>(0);
	private List<Functions> functionses = new ArrayList<Functions>(0);

	// Constructors

	/** default constructor */
	public Functions() {
	}

	/** full constructor */
	public Functions(Functions functions, String functionName,
			String levelCode, String funUrl, String parentName,
			String funStatus, Integer orderNum,
			Set<RoleFunction> roleFunctions, List<Functions> functionses) {
		this.functions = functions;
		this.functionName = functionName;
		this.levelCode = levelCode;
		this.funUrl = funUrl;
		this.parentName = parentName;
		this.funStatus = funStatus;
		this.orderNum = orderNum;
		this.roleFunctions = roleFunctions;
		this.functionses = functionses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "functionID", unique = true, nullable = false)
	public Integer getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentID")
	public Functions getFunctions() {
		return this.functions;
	}

	public void setFunctions(Functions functions) {
		this.functions = functions;
	}

	@Column(name = "functionName", length = 48)
	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Column(name = "levelCode", length = 48)
	public String getLevelCode() {
		return this.levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	@Column(name = "funUrl", length = 48)
	public String getFunUrl() {
		return this.funUrl;
	}

	public void setFunUrl(String funUrl) {
		this.funUrl = funUrl;
	}

	@Column(name = "parentName", length = 48)
	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Column(name = "funStatus", length = 1)
	public String getFunStatus() {
		return this.funStatus;
	}

	public void setFunStatus(String funStatus) {
		this.funStatus = funStatus;
	}

	@Column(name = "orderNum")
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "functions")
	public Set<RoleFunction> getRoleFunctions() {
		return this.roleFunctions;
	}

	public void setRoleFunctions(Set<RoleFunction> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "functions")
	public List<Functions> getFunctionses() {
		return this.functionses;
	}

	public void setFunctionses(List<Functions> functionses) {
		this.functionses = functionses;
	}

}