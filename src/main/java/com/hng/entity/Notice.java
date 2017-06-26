package com.hng.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "notice", catalog = "hng")
public class Notice implements java.io.Serializable {

	// Fields

	private Integer noticeId;
	private Users users;
	private String noticeTitle;
	private String userName;
	private String noticeType;
	private Date createDate;
	private String content;
	private String msgSatus;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(Integer noticeId, Users users) {
		this.noticeId = noticeId;
		this.users = users;
	}

	/** full constructor */
	public Notice(Integer noticeId, Users users, String noticeTitle,
			String userName, String noticeType, Date createDate,
			String content, String msgSatus) {
		this.noticeId = noticeId;
		this.users = users;
		this.noticeTitle = noticeTitle;
		this.userName = userName;
		this.noticeType = noticeType;
		this.createDate = createDate;
		this.content = content;
		this.msgSatus = msgSatus;
	}

	// Property accessors
	@Id
	@Column(name = "noticeID", unique = true, nullable = false)
	public Integer getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "noticeTitle", length = 48)
	public String getNoticeTitle() {
		return this.noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	@Column(name = "userName", length = 48)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "noticeType", length = 48)
	public String getNoticeType() {
		return this.noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	@Column(name = "createDate", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
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