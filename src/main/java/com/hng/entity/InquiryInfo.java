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
 * InquiryInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "inquiryinfo", catalog = "hng")
public class InquiryInfo implements java.io.Serializable {

	// Fields

	private Integer inquiryId;
	private Member member;
	private SupplyInfo supplyInfo;
	private String supplyTitle;
	private String memberName;
	private Timestamp contentDate;
	private String content;
	private Timestamp replyDate;
	private String status;

	// Constructors

	/** default constructor */
	public InquiryInfo() {
	}

	/** minimal constructor */
	public InquiryInfo(Member member, SupplyInfo supplyInfo) {
		this.member = member;
		this.supplyInfo = supplyInfo;
	}

	/** full constructor */
	public InquiryInfo(Member member, SupplyInfo supplyInfo,
			String supplyTitle, String memberName, Timestamp contentDate,
			String content, Timestamp replyDate, String status) {
		this.member = member;
		this.supplyInfo = supplyInfo;
		this.supplyTitle = supplyTitle;
		this.memberName = memberName;
		this.contentDate = contentDate;
		this.content = content;
		this.replyDate = replyDate;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "inquiryID", unique = true, nullable = false)
	public Integer getInquiryId() {
		return this.inquiryId;
	}

	public void setInquiryId(Integer inquiryId) {
		this.inquiryId = inquiryId;
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
	@JoinColumn(name = "supplyID", nullable = false)
	public SupplyInfo getSupplyInfo() {
		return this.supplyInfo;
	}

	public void setSupplyInfo(SupplyInfo supplyInfo) {
		this.supplyInfo = supplyInfo;
	}

	@Column(name = "supplyTitle", length = 48)
	public String getSupplyTitle() {
		return this.supplyTitle;
	}

	public void setSupplyTitle(String supplyTitle) {
		this.supplyTitle = supplyTitle;
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

	@Column(name = "content", length = 48)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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