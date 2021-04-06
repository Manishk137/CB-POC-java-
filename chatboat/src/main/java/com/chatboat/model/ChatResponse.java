package com.chatboat.model;

public class ChatResponse {
	
	private String question;
	private String flag;
	private String answer;
	private String status;
	private String message;
	private String msg_by;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
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
	public String getMsg_by() {
		return msg_by;
	}
	public void setMsg_by(String msg_by) {
		this.msg_by = msg_by;
	}
	@Override
	public String toString() {
		return "ChatResponse [question=" + question + ", flag=" + flag + ", answer=" + answer + ", status=" + status
				+ ", message=" + message + ", msg_by=" + msg_by + "]";
	}
}
