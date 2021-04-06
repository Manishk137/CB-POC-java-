package com.chatboat.model;

public class ServeyQuestions {
	
	private int questionId;
	private String question;
	private String type;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ServeyQuestions [questionId=" + questionId + ", question=" + question + ", type=" + type + "]";
	}
}
