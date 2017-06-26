package com.hng.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Roles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "roles", catalog = "hng")
public class Roles implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String roleStatus;
	private String levelCode;
	private Integer orderNum;
	/*private Set<RoleFunction> roleFunctions = new HashSet<RoleFunction>(0);
	private Set<Users> userses = new HashSet<Users>(0);*/

	// Constructors

	/** default constructor */
	public Roles() {
	}
	public Roles(Integer roleId) {
		this.roleId = roleId;
	}

	/** full constructor */
	public Roles(String roleName, String roleStatus, String levelCode,
			Integer orderNum, Set<RoleFunction> roleFunctions,
			Set<Users> userses) {
		this.roleName = roleName;
		this.roleStatus = roleStatus;
		this.levelCode = levelCode;
		this.orderNum = orderNum;
		/*this.roleFunctions = roleFunctions;
		this.userses = userses;*/
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "roleID", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "roleName", length = 48)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "roleStatus", length = 1)
	public String getRoleStatus() {
		return this.roleStatus;
	}

	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}

	@Column(name = "levelCode", length = 48)
	public String getLevelCode() {
		return this.levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	@Column(name = "orderNum")
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<RoleFunction> getRoleFunctions() {
		return this.roleFunctions;
	}

	public void setRoleFunctions(Set<RoleFunction> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}*/

}