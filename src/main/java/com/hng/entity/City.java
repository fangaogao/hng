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
 * City entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "city", catalog = "hng")
public class City implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private String cityName;
	private String levelCode;
	private Integer parentId;
	private String parentName;
	private String status;
	private Set<BuyInfo> buyInfosForProvinceId = new HashSet<BuyInfo>(0);
	private Set<BuyInfo> buyInfosForAreaId = new HashSet<BuyInfo>(0);
	private Set<Member> membersForAreaId = new HashSet<Member>(0);
	private Set<BuyInfo> buyInfosForCityId = new HashSet<BuyInfo>(0);
	private Set<Company> companiesForCityId = new HashSet<Company>(0);
	private Set<SupplyInfo> supplyInfosForAreaId = new HashSet<SupplyInfo>(0);
	private Set<SupplyInfo> supplyInfosForProvinceId = new HashSet<SupplyInfo>(
			0);
	private Set<SupplyInfo> supplyInfosForCityId = new HashSet<SupplyInfo>(0);
	private Set<Member> membersForProvinceId = new HashSet<Member>(0);
	private Set<Member> membersForCityId = new HashSet<Member>(0);
	private Set<Company> companiesForAreaId = new HashSet<Company>(0);
	private Set<Company> companiesForProvinceId = new HashSet<Company>(0);

	// Constructors

	/** default constructor */
	public City() {
	}
	
	public City(Integer cityId) {
		this.cityId = cityId;
	}

	/** full constructor */
	public City(String cityName, String levelCode, Integer parentId,
			String parentName, String status,
			Set<BuyInfo> buyInfosForProvinceId, Set<BuyInfo> buyInfosForAreaId,
			Set<Member> membersForAreaId, Set<BuyInfo> buyInfosForCityId,
			Set<Company> companiesForCityId,
			Set<SupplyInfo> supplyInfosForAreaId,
			Set<SupplyInfo> supplyInfosForProvinceId,
			Set<SupplyInfo> supplyInfosForCityId,
			Set<Member> membersForProvinceId, Set<Member> membersForCityId,
			Set<Company> companiesForAreaId, Set<Company> companiesForProvinceId) {
		this.cityName = cityName;
		this.levelCode = levelCode;
		this.parentId = parentId;
		this.parentName = parentName;
		this.status = status;
		this.buyInfosForProvinceId = buyInfosForProvinceId;
		this.buyInfosForAreaId = buyInfosForAreaId;
		this.membersForAreaId = membersForAreaId;
		this.buyInfosForCityId = buyInfosForCityId;
		this.companiesForCityId = companiesForCityId;
		this.supplyInfosForAreaId = supplyInfosForAreaId;
		this.supplyInfosForProvinceId = supplyInfosForProvinceId;
		this.supplyInfosForCityId = supplyInfosForCityId;
		this.membersForProvinceId = membersForProvinceId;
		this.membersForCityId = membersForCityId;
		this.companiesForAreaId = companiesForAreaId;
		this.companiesForProvinceId = companiesForProvinceId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cityID", unique = true, nullable = false)
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "cityName", length = 48)
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Column(name = "levelCode", length = 48)
	public String getLevelCode() {
		return this.levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	@Column(name = "parentID")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "parentName", length = 48)
	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Column(name = "status", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByProvinceId")
	public Set<BuyInfo> getBuyInfosForProvinceId() {
		return this.buyInfosForProvinceId;
	}

	public void setBuyInfosForProvinceId(Set<BuyInfo> buyInfosForProvinceId) {
		this.buyInfosForProvinceId = buyInfosForProvinceId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByAreaId")
	public Set<BuyInfo> getBuyInfosForAreaId() {
		return this.buyInfosForAreaId;
	}

	public void setBuyInfosForAreaId(Set<BuyInfo> buyInfosForAreaId) {
		this.buyInfosForAreaId = buyInfosForAreaId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByAreaId")
	public Set<Member> getMembersForAreaId() {
		return this.membersForAreaId;
	}

	public void setMembersForAreaId(Set<Member> membersForAreaId) {
		this.membersForAreaId = membersForAreaId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByCityId")
	public Set<BuyInfo> getBuyInfosForCityId() {
		return this.buyInfosForCityId;
	}

	public void setBuyInfosForCityId(Set<BuyInfo> buyInfosForCityId) {
		this.buyInfosForCityId = buyInfosForCityId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByCityId")
	public Set<Company> getCompaniesForCityId() {
		return this.companiesForCityId;
	}

	public void setCompaniesForCityId(Set<Company> companiesForCityId) {
		this.companiesForCityId = companiesForCityId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByAreaId")
	public Set<SupplyInfo> getSupplyInfosForAreaId() {
		return this.supplyInfosForAreaId;
	}

	public void setSupplyInfosForAreaId(Set<SupplyInfo> supplyInfosForAreaId) {
		this.supplyInfosForAreaId = supplyInfosForAreaId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByProvinceId")
	public Set<SupplyInfo> getSupplyInfosForProvinceId() {
		return this.supplyInfosForProvinceId;
	}

	public void setSupplyInfosForProvinceId(
			Set<SupplyInfo> supplyInfosForProvinceId) {
		this.supplyInfosForProvinceId = supplyInfosForProvinceId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByCityId")
	public Set<SupplyInfo> getSupplyInfosForCityId() {
		return this.supplyInfosForCityId;
	}

	public void setSupplyInfosForCityId(Set<SupplyInfo> supplyInfosForCityId) {
		this.supplyInfosForCityId = supplyInfosForCityId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByProvinceId")
	public Set<Member> getMembersForProvinceId() {
		return this.membersForProvinceId;
	}

	public void setMembersForProvinceId(Set<Member> membersForProvinceId) {
		this.membersForProvinceId = membersForProvinceId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByCityId")
	public Set<Member> getMembersForCityId() {
		return this.membersForCityId;
	}

	public void setMembersForCityId(Set<Member> membersForCityId) {
		this.membersForCityId = membersForCityId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByAreaId")
	public Set<Company> getCompaniesForAreaId() {
		return this.companiesForAreaId;
	}

	public void setCompaniesForAreaId(Set<Company> companiesForAreaId) {
		this.companiesForAreaId = companiesForAreaId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityByProvinceId")
	public Set<Company> getCompaniesForProvinceId() {
		return this.companiesForProvinceId;
	}

	public void setCompaniesForProvinceId(Set<Company> companiesForProvinceId) {
		this.companiesForProvinceId = companiesForProvinceId;
	}

}