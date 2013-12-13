package com.servercentral.communication.hub.model;

import java.util.Date;

public class Notification {

	String subject;
	String from;
	String receiverGUID;
	String senderGUID;
	String senderTenantGUID;
	String receiverTenantGuid;
	String to;
	String cc;
	Date receivedDate;
	Date forwardDate;
	String forwardEmail;
	Integer forward;
	Integer messageType;
	String messageBody;
	Attachment[] attachments;
	
	public Integer getMessageType() {
		return messageType;
	}
	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}
	
	public String getReceiverGUID() {
		return receiverGUID;
	}
	public void setReceiverGUID(String receiverGUID) {
		this.receiverGUID = receiverGUID;
	}
	public String getSenderGUID() {
		return senderGUID;
	}
	public void setSenderGUID(String senderGUID) {
		this.senderGUID = senderGUID;
	}
	public String getSenderTenantGUID() {
		return senderTenantGUID;
	}
	public void setSenderTenantGUID(String senderTenantGUID) {
		this.senderTenantGUID = senderTenantGUID;
	}
	public String getReceiverTenantGuid() {
		return receiverTenantGuid;
	}
	public void setReceiverTenantGuid(String receiverTenantGuid) {
		this.receiverTenantGuid = receiverTenantGuid;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public Date getForwardDate() {
		return forwardDate;
	}
	public void setForwardDate(Date forwardDate) {
		this.forwardDate = forwardDate;
	}
	public String getForwardEmail() {
		return forwardEmail;
	}
	public void setForwardEmail(String forwardEmail) {
		this.forwardEmail = forwardEmail;
	}
	public Integer getForward() {
		return forward;
	}
	public void setForward(Integer forward) {
		this.forward = forward;
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public Attachment[] getAttachments() {
		return attachments;
	}
	public void setAttachments(Attachment[] attachments) {
		this.attachments = attachments;
	}
	
}
