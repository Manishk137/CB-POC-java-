package com.chatboat.model;

public class Gender {
	
	private int highRiskMale;
	private int highRiskFemale;
	
	private int mediumRiskMale;
	private int mediumRiskFemale;
	public int getHighRiskMale() {
		return highRiskMale;
	}
	public void setHighRiskMale(int highRiskMale) {
		this.highRiskMale = highRiskMale;
	}
	public int getHighRiskFemale() {
		return highRiskFemale;
	}
	public void setHighRiskFemale(int highRiskFemale) {
		this.highRiskFemale = highRiskFemale;
	}
	public int getMediumRiskMale() {
		return mediumRiskMale;
	}
	public void setMediumRiskMale(int mediumRiskMale) {
		this.mediumRiskMale = mediumRiskMale;
	}
	public int getMediumRiskFemale() {
		return mediumRiskFemale;
	}
	public void setMediumRiskFemale(int mediumRiskFemale) {
		this.mediumRiskFemale = mediumRiskFemale;
	}
	@Override
	public String toString() {
		return "Gender [highRiskMale=" + highRiskMale + ", highRiskFemale=" + highRiskFemale + ", mediumRiskMale="
				+ mediumRiskMale + ", mediumRiskFemale=" + mediumRiskFemale + "]";
	}
}
