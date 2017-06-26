package com.hng.entity.vo;

import java.util.Date;

import com.hng.entity.Notice;

public class NoticeVO{
	private Integer noticeId;
	private Integer userId;
	private String noticeTitle;
	private String userName;
	private String noticeType;
	private Date createDate;
	private String content;
	private String msgSatus;
	
	public NoticeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NoticeVO(Notice n,Integer userId) {
		super();
		this.noticeId = n.getNoticeId();
		this.userId = userId;
		this.noticeTitle = n.getNoticeTitle();
		this.userName = n.getUserName();
		this.noticeType = n.getNoticeType();
		this.createDate = n.getCreateDate();
		this.content = n.getContent();
		this.msgSatus = n.getMsgSatus();
	}
	
	
	public NoticeVO(Integer noticeId, Integer userId, String noticeTitle,
			String userName, String noticeType, Date createDate,
			String content, String msgSatus) {
		super();
		this.noticeId = noticeId;
		this.userId = userId;
		this.noticeTitle = noticeTitle;
		this.userName = userName;
		this.noticeType = noticeType;
		this.createDate = createDate;
		this.content = content;
		this.msgSatus = msgSatus;
	}
	public Integer getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMsgSatus() {
		return msgSatus;
	}
	public void setMsgSatus(String msgSatus) {
		this.msgSatus = msgSatus;
	}
	
	
	
}