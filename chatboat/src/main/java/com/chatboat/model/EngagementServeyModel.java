package com.chatboat.model;

public class EngagementServeyModel {
	
	private int id;
	private String question;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "EngagementServeyModel [id=" + id + ", question=" + question + "]";
	}
}
