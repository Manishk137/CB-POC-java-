package com.chatboat.model;

public class ChatFeedRequest {
	
	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "ChatFeedRequest [emailId=" + emailId + "]";
	}

}
