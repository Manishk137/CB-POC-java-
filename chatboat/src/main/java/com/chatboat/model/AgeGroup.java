package com.chatboat.model;

public class AgeGroup {
	
	private int highRisk30Above;
	private int highRisk30Below;
	
	private int mediumRisk30Above;
	private int mediumRisk30Below;
	public int getHighRisk30Above() {
		return highRisk30Above;
	}
	public void setHighRisk30Above(int highRisk30Above) {
		this.highRisk30Above = highRisk30Above;
	}
	public int getHighRisk30Below() {
		return highRisk30Below;
	}
	public void setHighRisk30Below(int highRisk30Below) {
		this.highRisk30Below = highRisk30Below;
	}
	public int getMediumRisk30Above() {
		return mediumRisk30Above;
	}
	public void setMediumRisk30Above(int mediumRisk30Above) {
		this.mediumRisk30Above = mediumRisk30Above;
	}
	public int getMediumRisk30Below() {
		return mediumRisk30Below;
	}
	public void setMediumRisk30Below(int mediumRisk30Below) {
		this.mediumRisk30Below = mediumRisk30Below;
	}
	@Override
	public String toString() {
		return "AgeGroup [highRisk30Above=" + highRisk30Above + ", highRisk30Below=" + highRisk30Below
				+ ", mediumRisk30Above=" + mediumRisk30Above + ", mediumRisk30Below=" + mediumRisk30Below + "]";
	}
}
