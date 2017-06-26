package com.hng.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Collection entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "collection", catalog = "hng")
public class Collection implements java.io.Serializable {

	// Fields

	private Integer collectionId;
	private Member member;
	private String memerName;
	private Integer supBuyInfoId;
	private String supBuyInfoTitle;
	private String supBuyType;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public Collection() {
	}

	/** minimal constructor */
	public Collection(Integer collectionId, Member member, Integer supBuyInfoId) {
		this.collectionId = collectionId;
		this.member = member;
		this.supBuyInfoId = supBuyInfoId;
	}

	/** full constructor */
	public Collection(Integer collectionId, Member member, String memerName,
			Integer supBuyInfoId, String supBuyInfoTitle, String supBuyType,
			Timestamp createDate) {
		this.collectionId = collectionId;
		this.member = member;
		this.memerName = memerName;
		this.supBuyInfoId = supBuyInfoId;
		this.supBuyInfoTitle = supBuyInfoTitle;
		this.supBuyType = supBuyType;
		this.createDate = createDate;
	}

	// Property accessors
	@Id
	@Column(name = "collectionID", unique = true, nullable = false)
	public Integer getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberID", nullable = false)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Column(name = "memerName", length = 48)
	public String getMemerName() {
		return this.memerName;
	}

	public void setMemerName(String memerName) {
		this.memerName = memerName;
	}

	@Column(name = "supBuyInfoID", nullable = false)
	public Integer getSupBuyInfoId() {
		return this.supBuyInfoId;
	}

	public void setSupBuyInfoId(Integer supBuyInfoId) {
		this.supBuyInfoId = supBuyInfoId;
	}

	@Column(name = "supBuyInfoTitle", length = 48)
	public String getSupBuyInfoTitle() {
		return this.supBuyInfoTitle;
	}

	public void setSupBuyInfoTitle(String supBuyInfoTitle) {
		this.supBuyInfoTitle = supBuyInfoTitle;
	}

	@Column(name = "supBuyType", length = 1)
	public String getSupBuyType() {
		return this.supBuyType;
	}

	public void setSupBuyType(String supBuyType) {
		this.supBuyType = supBuyType;
	}

	@Column(name = "createDate", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}