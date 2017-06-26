package com.hng.entity;

import java.sql.Timestamp;
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
 * QuoteInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "quoteinfo", catalog = "hng")
public class QuoteInfo implements java.io.Serializable {

	// Fields

	private Integer quoteId;
	private Member member;
	private BuyInfo buyInfo;
	private String buyTitle;
	private String memberName;
	private Timestamp contentDate;
	private String phone;
	private Double supplyQuantity;
	private Double supplyPrice;
	private String supplyUnit;
	private String supplyArea;
	private String note;
	private Timestamp replyDate;
	private String status;

	// Constructors

	/** default constructor */
	public QuoteInfo() {
	}

	/** minimal constructor */
	public QuoteInfo(Member member, BuyInfo buyInfo) {
		this.member = member;
		this.buyInfo = buyInfo;
	}

	/** full constructor */
	public QuoteInfo(Member member, BuyInfo buyInfo, String buyTitle,
			String memberName, Timestamp contentDate, String phone,
			Double supplyQuantity, Double supplyPrice, String supplyUnit,
			String supplyArea, String note, Timestamp replyDate, String status) {
		this.member = member;
		this.buyInfo = buyInfo;
		this.buyTitle = buyTitle;
		this.memberName = memberName;
		this.contentDate = contentDate;
		this.phone = phone;
		this.supplyQuantity = supplyQuantity;
		this.supplyPrice = supplyPrice;
		this.supplyUnit = supplyUnit;
		this.supplyArea = supplyArea;
		this.note = note;
		this.replyDate = replyDate;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "quoteID", unique = true, nullable = false)
	public Integer getQuoteId() {
		return this.quoteId;
	}

	public void setQuoteId(Integer quoteId) {
		this.quoteId = quoteId;
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
	@JoinColumn(name = "buyID", nullable = false)
	public BuyInfo getBuyInfo() {
		return this.buyInfo;
	}

	public void setBuyInfo(BuyInfo buyInfo) {
		this.buyInfo = buyInfo;
	}

	@Column(name = "buyTitle", length = 48)
	public String getBuyTitle() {
		return this.buyTitle;
	}

	public void setBuyTitle(String buyTitle) {
		this.buyTitle = buyTitle;
	}

	@Column(name = "memberName", length = 48)
	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Column(name = "contentDate", length = 19)
	public Timestamp getContentDate() {
		return this.contentDate;
	}

	public void setContentDate(Timestamp contentDate) {
		this.contentDate = contentDate;
	}

	@Column(name = "phone", length = 48)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "supplyQuantity", precision = 10)
	public Double getSupplyQuantity() {
		return this.supplyQuantity;
	}

	public void setSupplyQuantity(Double supplyQuantity) {
		this.supplyQuantity = supplyQuantity;
	}

	@Column(name = "supplyPrice", precision = 10)
	public Double getSupplyPrice() {
		return this.supplyPrice;
	}

	public void setSupplyPrice(Double supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	@Column(name = "supplyUnit", length = 48)
	public String getSupplyUnit() {
		return this.supplyUnit;
	}

	public void setSupplyUnit(String supplyUnit) {
		this.supplyUnit = supplyUnit;
	}

	@Column(name = "supplyArea", length = 48)
	public String getSupplyArea() {
		return this.supplyArea;
	}

	public void setSupplyArea(String supplyArea) {
		this.supplyArea = supplyArea;
	}

	@Column(name = "note", length = 48)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "replyDate", length = 19)
	public Timestamp getReplyDate() {
		return this.replyDate;
	}

	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}

	@Column(name = "status", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}