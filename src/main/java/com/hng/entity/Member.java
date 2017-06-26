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
 * Member entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member", catalog = "hng")
public class Member implements java.io.Serializable {

	// Fields

	private Integer memberId;
	private City cityByAreaId;
	private City cityByProvinceId;
	private Company company;
	private Users users;
	private City cityByCityId;
	private String memberName;
	private String companyName;
	private String headImg;
	private String email;
	private String phone;
	private String qq;
	private String address;
	private String memberStatus;
	private String certificationStatus;
	private String idNumber;
	private String identityImg;
	private String identitystatus;
	private Set<SupplyInfo> supplyInfos = new HashSet<SupplyInfo>(0);
	private Set<SysMessage> sysMessages = new HashSet<SysMessage>(0);
	private Set<BuyInfo> buyInfos = new HashSet<BuyInfo>(0);
	private Set<QuoteInfo> quoteInfos = new HashSet<QuoteInfo>(0);
	private Set<InquiryInfo> inquiryInfos = new HashSet<InquiryInfo>(0);
	private Set<Collection> collections = new HashSet<Collection>(0);

	// Constructors

	/** default constructor */
	public Member() {
	}

	/** full constructor */
	public Member(City cityByAreaId, City cityByProvinceId, Company company,
			Users users, City cityByCityId, String memberName,
			String companyName, String headImg, String email, String phone,
			String qq, String address, String memberStatus,
			String certificationStatus, String idNumber, String identityImg,
			String identitystatus, Set<SupplyInfo> supplyInfos,
			Set<SysMessage> sysMessages, Set<BuyInfo> buyInfos,
			Set<QuoteInfo> quoteInfos, Set<InquiryInfo> inquiryInfos,
			Set<Collection> collections) {
		this.cityByAreaId = cityByAreaId;
		this.cityByProvinceId = cityByProvinceId;
		this.company = company;
		this.users = users;
		this.cityByCityId = cityByCityId;
		this.memberName = memberName;
		this.companyName = companyName;
		this.headImg = headImg;
		this.email = email;
		this.phone = phone;
		this.qq = qq;
		this.address = address;
		this.memberStatus = memberStatus;
		this.certificationStatus = certificationStatus;
		this.idNumber = idNumber;
		this.identityImg = identityImg;
		this.identitystatus = identitystatus;
		this.supplyInfos = supplyInfos;
		this.sysMessages = sysMessages;
		this.buyInfos = buyInfos;
		this.quoteInfos = quoteInfos;
		this.inquiryInfos = inquiryInfos;
		this.collections = collections;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "memberID", unique = true, nullable = false)
	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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
	@JoinColumn(name = "companyID")
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cityID")
	public City getCityByCityId() {
		return this.cityByCityId;
	}

	public void setCityByCityId(City cityByCityId) {
		this.cityByCityId = cityByCityId;
	}

	@Column(name = "memberName", length = 48)
	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Column(name = "companyName", length = 48)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "headImg", length = 48)
	public String getHeadImg() {
		return this.headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	@Column(name = "email", length = 48)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Column(name = "memberStatus", length = 1)
	public String getMemberStatus() {
		return this.memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	@Column(name = "certificationStatus", length = 1)
	public String getCertificationStatus() {
		return this.certificationStatus;
	}

	public void setCertificationStatus(String certificationStatus) {
		this.certificationStatus = certificationStatus;
	}

	@Column(name = "idNumber", length = 48)
	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Column(name = "identityImg", length = 48)
	public String getIdentityImg() {
		return this.identityImg;
	}

	public void setIdentityImg(String identityImg) {
		this.identityImg = identityImg;
	}

	@Column(name = "identitystatus", length = 1)
	public String getIdentitystatus() {
		return this.identitystatus;
	}

	public void setIdentitystatus(String identitystatus) {
		this.identitystatus = identitystatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "member")
	public Set<SupplyInfo> getSupplyInfos() {
		return this.supplyInfos;
	}

	public void setSupplyInfos(Set<SupplyInfo> supplyInfos) {
		this.supplyInfos = supplyInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "member")
	public Set<SysMessage> getSysMessages() {
		return this.sysMessages;
	}

	public void setSysMessages(Set<SysMessage> sysMessages) {
		this.sysMessages = sysMessages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "member")
	public Set<BuyInfo> getBuyInfos() {
		return this.buyInfos;
	}

	public void setBuyInfos(Set<BuyInfo> buyInfos) {
		this.buyInfos = buyInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "member")
	public Set<QuoteInfo> getQuoteInfos() {
		return this.quoteInfos;
	}

	public void setQuoteInfos(Set<QuoteInfo> quoteInfos) {
		this.quoteInfos = quoteInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "member")
	public Set<InquiryInfo> getInquiryInfos() {
		return this.inquiryInfos;
	}

	public void setInquiryInfos(Set<InquiryInfo> inquiryInfos) {
		this.inquiryInfos = inquiryInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "member")
	public Set<Collection> getCollections() {
		return this.collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}

}