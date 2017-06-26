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
 * AgriculClas entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "agriculclas", catalog = "hng")
public class AgriculClas implements java.io.Serializable {

	// Fields

	private Integer clasId;
	private AgriculClas agriculClas;
	private String clasName;
	private String levelCode;
	private String clasIcom;
	private String clasImage;
	private String parentName;
	private String status;
	private Set<BuyInfo> buyInfos = new HashSet<BuyInfo>(0);
	private Set<SupplyInfo> supplyInfos = new HashSet<SupplyInfo>(0);
	private List<AgriculClas> agriculClases = new ArrayList<AgriculClas>(0);

	// Constructors

	/** default constructor */
	public AgriculClas() {
	}
	public AgriculClas(Integer clasId) {
		this.clasId = clasId;
	}

	/** full constructor */
	public AgriculClas(AgriculClas agriculClas, String clasName,
			String levelCode, String clasIcom, String clasImage,
			String parentName, String status, Set<BuyInfo> buyInfos,
			Set<SupplyInfo> supplyInfos, List<AgriculClas> agriculClases) {
		this.agriculClas = agriculClas;
		this.clasName = clasName;
		this.levelCode = levelCode;
		this.clasIcom = clasIcom;
		this.clasImage = clasImage;
		this.parentName = parentName;
		this.status = status;
		this.buyInfos = buyInfos;
		this.supplyInfos = supplyInfos;
		this.agriculClases = agriculClases;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "clasID", unique = true, nullable = false)
	public Integer getClasId() {
		return this.clasId;
	}

	public void setClasId(Integer clasId) {
		this.clasId = clasId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentID")
	public AgriculClas getAgriculClas() {
		return this.agriculClas;
	}

	public void setAgriculClas(AgriculClas agriculClas) {
		this.agriculClas = agriculClas;
	}

	@Column(name = "clasName", length = 48)
	public String getClasName() {
		return this.clasName;
	}

	public void setClasName(String clasName) {
		this.clasName = clasName;
	}

	@Column(name = "levelCode", length = 48)
	public String getLevelCode() {
		return this.levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	@Column(name = "clasIcom", length = 48)
	public String getClasIcom() {
		return this.clasIcom;
	}

	public void setClasIcom(String clasIcom) {
		this.clasIcom = clasIcom;
	}

	@Column(name = "clasImage", length = 48)
	public String getClasImage() {
		return this.clasImage;
	}

	public void setClasImage(String clasImage) {
		this.clasImage = clasImage;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "agriculClas")
	public Set<BuyInfo> getBuyInfos() {
		return this.buyInfos;
	}

	public void setBuyInfos(Set<BuyInfo> buyInfos) {
		this.buyInfos = buyInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "agriculClas")
	public Set<SupplyInfo> getSupplyInfos() {
		return this.supplyInfos;
	}

	public void setSupplyInfos(Set<SupplyInfo> supplyInfos) {
		this.supplyInfos = supplyInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "agriculClas")
	public List<AgriculClas> getAgriculClases() {
		return this.agriculClases;
	}

	public void setAgriculClases(List<AgriculClas> agriculClases) {
		this.agriculClases = agriculClases;
	}

}