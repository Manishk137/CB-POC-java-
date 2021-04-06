package com.chatboat.model;

public class CompanyPulseScoreView {
	
	
	private int StronglyDisagreeCount;
	private int DisagreeCount;
	private int SomewhatDisagreeCount;
	private int SomewhatAgreeCount;
	private int AgreeCount;
	private int StronglyAgreeCount;
	public int getStronglyDisagreeCount() {
		return StronglyDisagreeCount;
	}
	public void setStronglyDisagreeCount(int stronglyDisagreeCount) {
		StronglyDisagreeCount = stronglyDisagreeCount;
	}
	public int getDisagreeCount() {
		return DisagreeCount;
	}
	public void setDisagreeCount(int disagreeCount) {
		DisagreeCount = disagreeCount;
	}
	public int getSomewhatDisagreeCount() {
		return SomewhatDisagreeCount;
	}
	public void setSomewhatDisagreeCount(int somewhatDisagreeCount) {
		SomewhatDisagreeCount = somewhatDisagreeCount;
	}
	public int getSomewhatAgreeCount() {
		return SomewhatAgreeCount;
	}
	public void setSomewhatAgreeCount(int somewhatAgreeCount) {
		SomewhatAgreeCount = somewhatAgreeCount;
	}
	public int getAgreeCount() {
		return AgreeCount;
	}
	public void setAgreeCount(int agreeCount) {
		AgreeCount = agreeCount;
	}
	public int getStronglyAgreeCount() {
		return StronglyAgreeCount;
	}
	public void setStronglyAgreeCount(int stronglyAgreeCount) {
		StronglyAgreeCount = stronglyAgreeCount;
	}
	@Override
	public String toString() {
		return "CompanyPulseScoreView [StronglyDisagreeCount=" + StronglyDisagreeCount + ", DisagreeCount="
				+ DisagreeCount + ", SomewhatDisagreeCount=" + SomewhatDisagreeCount + ", SomewhatAgreeCount="
				+ SomewhatAgreeCount + ", AgreeCount=" + AgreeCount + ", StronglyAgreeCount=" + StronglyAgreeCount
				+ "]";
	}
}
