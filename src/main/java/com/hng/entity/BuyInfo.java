package com.hng.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
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
 * BuyInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "buyinfo", catalog = "hng")
public class BuyInfo implements java.io.Serializable {

	// Fields

	private Integer buyId;
	private City cityByAreaId;
	private City cityByProvinceId;
	private Member member;
	private AgriculClas agriculClas;
	private City cityByCityId;
	private String buyTitle;
	private Double minQuantity;
	private Double maxQuantity;
	private String quantityUnit;
	private Double minPrice;
	private Double maxPrice;
	private String address;
	private String description;
	private String contacts;
	private String phone;
	private String qq;
	private String email;
	private Timestamp publishDate;
	private Integer expiryInterval;
	private Timestamp expiryDate;
	private Integer accessTimes;
	private Integer collectTimes;
	private String status;
	private Set<QuoteInfo> quoteInfos = new HashSet<QuoteInfo>(0);

	// Constructors

	/** default constructor */
	public BuyInfo(Integer buyId) {
		this.buyId = buyId;
	}
	
	public BuyInfo() {
	}

	/** minimal constructor */
	public BuyInfo(Member member) {
		this.member = member;
	}

	/** full constructor */
	public BuyInfo(City cityByAreaId, City cityByProvinceId, Member member,
			AgriculClas agriculClas, City cityByCityId, String buyTitle,
			Double minQuantity, Double maxQuantity, String quantityUnit,
			Double minPrice, Double maxPrice, String address,
			String description, String contacts, String phone, String qq,
			String email, Timestamp publishDate, Integer expiryInterval,
			Timestamp expiryDate, Integer accessTimes, Integer collectTimes,
			String status, Set<QuoteInfo> quoteInfos) {
		this.cityByAreaId = cityByAreaId;
		this.cityByProvinceId = cityByProvinceId;
		this.member = member;
		this.agriculClas = agriculClas;
		this.cityByCityId = cityByCityId;
		this.buyTitle = buyTitle;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.quantityUnit = quantityUnit;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.address = address;
		this.description = description;
		this.contacts = contacts;
		this.phone = phone;
		this.qq = qq;
		this.email = email;
		this.publishDate = publishDate;
		this.expiryInterval = expiryInterval;
		this.expiryDate = expiryDate;
		this.accessTimes = accessTimes;
		this.collectTimes = collectTimes;
		this.status = status;
		this.quoteInfos = quoteInfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "buyID", unique = true, nullable = false)
	public Integer getBuyId() {
		return this.buyId;
	}

	public void setBuyId(Integer buyId) {
		this.buyId = buyId;
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
	@JoinColumn(name = "memberID", nullable = false)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clasID")
	public AgriculClas getAgriculClas() {
		return this.agriculClas;
	}

	public void setAgriculClas(AgriculClas agriculClas) {
		this.agriculClas = agriculClas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cityID")
	public City getCityByCityId() {
		return this.cityByCityId;
	}

	public void setCityByCityId(City cityByCityId) {
		this.cityByCityId = cityByCityId;
	}

	@Column(name = "buyTitle", length = 48)
	public String getBuyTitle() {
		return this.buyTitle;
	}

	public void setBuyTitle(String buyTitle) {
		this.buyTitle = buyTitle;
	}

	@Column(name = "minQuantity", precision = 10)
	public Double getMinQuantity() {
		return this.minQuantity;
	}

	public void setMinQuantity(Double minQuantity) {
		this.minQuantity = minQuantity;
	}

	@Column(name = "maxQuantity", precision = 10)
	public Double getMaxQuantity() {
		return this.maxQuantity;
	}

	public void setMaxQuantity(Double maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	@Column(name = "quantityUnit", length = 48)
	public String getQuantityUnit() {
		return this.quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	@Column(name = "minPrice", precision = 10)
	public Double getMinPrice() {
		return this.minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	@Column(name = "maxPrice", precision = 10)
	public Double getMaxPrice() {
		return this.maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	@Column(name = "address", length = 48)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "description", length = 48)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "contacts", length = 48)
	public String getContacts() {
		return this.contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
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

	@Column(name = "email", length = 48)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "publishDate", length = 19)
	public Timestamp getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	@Column(name = "expiryInterval")
	public Integer getExpiryInterval() {
		return this.expiryInterval;
	}

	public void setExpiryInterval(Integer expiryInterval) {
		this.expiryInterval = expiryInterval;
	}

	@Column(name = "expiryDate", length = 19)
	public Timestamp getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Column(name = "accessTimes")
	public Integer getAccessTimes() {
		return this.accessTimes;
	}

	public void setAccessTimes(Integer accessTimes) {
		this.accessTimes = accessTimes;
	}

	@Column(name = "collectTimes")
	public Integer getCollectTimes() {
		return this.collectTimes;
	}

	public void setCollectTimes(Integer collectTimes) {
		this.collectTimes = collectTimes;
	}

	@Column(name = "status", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buyInfo")
	public Set<QuoteInfo> getQuoteInfos() {
		return this.quoteInfos;
	}

	public void setQuoteInfos(Set<QuoteInfo> quoteInfos) {
		this.quoteInfos = quoteInfos;
	}

}