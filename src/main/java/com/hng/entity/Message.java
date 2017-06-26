package com.hng.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "hng")
public class Message implements java.io.Serializable {

	// Fields

	private String messsageId;
	private String senderId;
	private String senderName;
	private String receiverId;
	private String receiverName;
	private String infoId;
	private String infoTitle;
	private String content;
	private Timestamp createDate;
	private String messageType;
	private String msgSatus;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(String messsageId, String senderId) {
		this.messsageId = messsageId;
		this.senderId = senderId;
	}

	/** full constructor */
	public Message(String messsageId, String senderId, String senderName,
			String receiverId, String receiverName, String infoId,
			String infoTitle, String content, Timestamp createDate,
			String messageType, String msgSatus) {
		this.messsageId = messsageId;
		this.senderId = senderId;
		this.senderName = senderName;
		this.receiverId = receiverId;
		this.receiverName = receiverName;
		this.infoId = infoId;
		this.infoTitle = infoTitle;
		this.content = content;
		this.createDate = createDate;
		this.messageType = messageType;
		this.msgSatus = msgSatus;
	}

	// Property accessors
	@Id
	@Column(name = "messsageID", unique = true, nullable = false, length = 48)
	public String getMesssageId() {
		return this.messsageId;
	}

	public void setMesssageId(String messsageId) {
		this.messsageId = messsageId;
	}

	@Column(name = "senderID", nullable = false, length = 48)
	public String getSenderId() {
		return this.senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	@Column(name = "senderName", length = 48)
	public String getSenderName() {
		return this.senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	@Column(name = "receiverID", length = 48)
	public String getReceiverId() {
		return this.receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	@Column(name = "receiverName", length = 48)
	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	@Column(name = "infoID", length = 48)
	public String getInfoId() {
		return this.infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	@Column(name = "infoTitle", length = 48)
	public String getInfoTitle() {
		return this.infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "createDate", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "messageType", length = 48)
	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	@Column(name = "msgSatus", length = 1)
	public String getMsgSatus() {
		return this.msgSatus;
	}

	public void setMsgSatus(String msgSatus) {
		this.msgSatus = msgSatus;
	}

}