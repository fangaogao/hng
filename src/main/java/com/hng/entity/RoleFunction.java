package com.hng.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RoleFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rolefunction", catalog = "hng")
public class RoleFunction implements java.io.Serializable {

	// Fields

	private Integer roleFunId;
	private Functions functions;
	private Roles roles;
	private Integer orderNum;

	// Constructors

	/** default constructor */
	public RoleFunction() {
	}

	/** full constructor */
	public RoleFunction(Functions functions, Roles roles, Integer orderNum) {
		this.functions = functions;
		this.roles = roles;
		this.orderNum = orderNum;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "roleFunID", unique = true, nullable = false)
	public Integer getRoleFunId() {
		return this.roleFunId;
	}

	public void setRoleFunId(Integer roleFunId) {
		this.roleFunId = roleFunId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "functionID")
	public Functions getFunctions() {
		return this.functions;
	}

	public void setFunctions(Functions functions) {
		this.functions = functions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleID")
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Column(name = "orderNum")
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

}