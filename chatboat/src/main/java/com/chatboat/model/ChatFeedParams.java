package com.chatboat.model;

public class ChatFeedParams {
	
	private int id;
	private String emailId;
	private String question;
	private String answer;
	private String date;
	private String datetime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "ChatFeedParams [id=" + id + ", emailId=" + emailId + ", question=" + question + ", answer=" + answer
				+ ", date=" + date + ", datetime=" + datetime + "]";
	}
}
