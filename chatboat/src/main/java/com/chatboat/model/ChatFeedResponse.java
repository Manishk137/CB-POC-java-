package com.chatboat.model;

import java.util.ArrayList;
import java.util.List;

public class ChatFeedResponse {
	
	private String status;
	private String message;
	List<ChatFeedParams> chatFeedList = new ArrayList<ChatFeedParams>();
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ChatFeedParams> getChatFeedList() {
		return chatFeedList;
	}
	public void setChatFeedList(List<ChatFeedParams> chatFeedList) {
		this.chatFeedList = chatFeedList;
	}
	@Override
	public String toString() {
		return "ChatFeedResponse [status=" + status + ", message=" + message + ", chatFeedList=" + chatFeedList + "]";
	}
}
