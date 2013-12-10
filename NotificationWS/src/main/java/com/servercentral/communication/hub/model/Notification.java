package com.servercentral.communication.hub.model;

public class Notification {

	String subject;
	String from;
	String recipientGuid;
	public String getRecipientGuid() {
		return recipientGuid;
	}
	public void setRecipientGuid(String recipientGuid) {
		this.recipientGuid = recipientGuid;
	}
	String to;
	String cc;
	String messageBody;
	Attachment[] attachments;
	
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
