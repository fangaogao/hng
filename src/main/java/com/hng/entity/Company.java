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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "company", catalog = "hng")
public class Company implements java.io.Serializable {

	// Fields

	private Integer companyId;
	private City cityByAreaId;
	private City cityByProvinceId;
	private City cityByCityId;
	private String companyName;
	private String email;
	private String fixPhone;
	private String phone;
	private String qq;
	private String address;
	private String companyStatus;
	private String introdution;
	private String corpName;
	private String businessNum;
	private String orgNum;
	private String unifiedNum;
	private String identityType;
	private String identityImg;
	private String identityStatus;
	private Set<Member> members = new HashSet<Member>(0);

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** full constructor */
	public Company(City cityByAreaId, City cityByProvinceId, City cityByCityId,
			String companyName, String email, String fixPhone, String phone,
			String qq, String address, String companyStatus,
			String introdution, String corpName, String businessNum,
			String orgNum, String unifiedNum, String identityType,
			String identityImg, String identityStatus, Set<Member> members) {
		this.cityByAreaId = cityByAreaId;
		this.cityByProvinceId = cityByProvinceId;
		this.cityByCityId = cityByCityId;
		this.companyName = companyName;
		this.email = email;
		this.fixPhone = fixPhone;
		this.phone = phone;
		this.qq = qq;
		this.address = address;
		this.companyStatus = companyStatus;
		this.introdution = introdution;
		this.corpName = corpName;
		this.businessNum = businessNum;
		this.orgNum = orgNum;
		this.unifiedNum = unifiedNum;
		this.identityType = identityType;
		this.identityImg = identityImg;
		this.identityStatus = identityStatus;
		this.members = members;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "companyID", unique = true, nullable = false)
	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "areaID")
	public City getCityByAreaId() {
		return this.cityByAreaId;
	}

	public void setCityByAreaId(City cityByAreaId) {
		this.cityByAreaId = cityByAreaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "provinceID")
	public City getCityByProvinceId() {
		return this.cityByProvinceId;
	}

	public void setCityByProvinceId(City cityByProvinceId) {
		this.cityByProvinceId = cityByProvinceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cityID")
	public City getCityByCityId() {
		return this.cityByCityId;
	}

	public void setCityByCityId(City cityByCityId) {
		this.cityByCityId = cityByCityId;
	}

	@Column(name = "companyName", length = 48)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "email", length = 48)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "fixPhone", length = 48)
	public String getFixPhone() {
		return this.fixPhone;
	}

	public void setFixPhone(String fixPhone) {
		this.fixPhone = fixPhone;
	}

	@Column(name = "phone", length = 48)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "qq", length = 48)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "address", length = 48)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "companyStatus", length = 1)
	public String getCompanyStatus() {
		return this.companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

	@Column(name = "introdution", length = 1000)
	public String getIntrodution() {
		return this.introdution;
	}

	public void setIntrodution(String introdution) {
		this.introdution = introdution;
	}

	@Column(name = "corpName", length = 48)
	public String getCorpName() {
		return this.corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	@Column(name = "businessNum", length = 48)
	public String getBusinessNum() {
		return this.businessNum;
	}

	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}

	@Column(name = "orgNum", length = 48)
	public String getOrgNum() {
		return this.orgNum;
	}

	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}

	@Column(name = "unifiedNum", length = 48)
	public String getUnifiedNum() {
		return this.unifiedNum;
	}

	public void setUnifiedNum(String unifiedNum) {
		this.unifiedNum = unifiedNum;
	}

	@Column(name = "identityType", length = 48)
	public String getIdentityType() {
		return this.identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	@Column(name = "identityImg", length = 48)
	public String getIdentityImg() {
		return this.identityImg;
	}

	public void setIdentityImg(String identityImg) {
		this.identityImg = identityImg;
	}

	@Column(name = "identityStatus", length = 1)
	public String getIdentityStatus() {
		return this.identityStatus;
	}

	public void setIdentityStatus(String identityStatus) {
		this.identityStatus = identityStatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Member> getMembers() {
		return this.members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

}