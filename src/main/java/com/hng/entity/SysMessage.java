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
 * SysMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sysmessage", catalog = "hng")
public class SysMessage implements java.io.Serializable {

	// Fields

	private Integer sysMsgId;
	private Member member;
	private String sysMsgTitle;
	private String memberName;
	private String messageType;
	private Timestamp createDate;
	private String content;
	private String msgSatus;

	// Constructors

	/** default constructor */
	public SysMessage() {
	}

	/** minimal constructor */
	public SysMessage(Integer sysMsgId, Member member) {
		this.sysMsgId = sysMsgId;
		this.member = member;
	}

	/** full constructor */
	public SysMessage(Integer sysMsgId, Member member, String sysMsgTitle,
			String memberName, String messageType, Timestamp createDate,
			String content, String msgSatus) {
		this.sysMsgId = sysMsgId;
		this.member = member;
		this.sysMsgTitle = sysMsgTitle;
		this.memberName = memberName;
		this.messageType = messageType;
		this.createDate = createDate;
		this.content = content;
		this.msgSatus = msgSatus;
	}

	// Property accessors
	@Id
	@Column(name = "sysMsgID", unique = true, nullable = false)
	public Integer getSysMsgId() {
		return this.sysMsgId;
	}

	public void setSysMsgId(Integer sysMsgId) {
		this.sysMsgId = sysMsgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberID", nullable = false)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Column(name = "sysMsgTitle", length = 48)
	public String getSysMsgTitle() {
		return this.sysMsgTitle;
	}

	public void setSysMsgTitle(String sysMsgTitle) {
		this.sysMsgTitle = sysMsgTitle;
	}

	@Column(name = "memberName", length = 48)
	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Column(name = "messageType", length = 48)
	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	@Column(name = "createDate", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "content", length = 1000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "msgSatus", length = 1)
	public String getMsgSatus() {
		return this.msgSatus;
	}

	public void setMsgSatus(String msgSatus) {
		this.msgSatus = msgSatus;
	}

}