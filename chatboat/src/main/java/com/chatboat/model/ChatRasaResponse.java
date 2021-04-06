package com.chatboat.model;

public class ChatRasaResponse {
	
	private String flag;
	private String message;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ChatRasaResponse [flag=" + flag + ", message=" + message + "]";
	}
}
