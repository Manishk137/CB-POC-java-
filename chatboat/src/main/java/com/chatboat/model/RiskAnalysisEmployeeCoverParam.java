package com.chatboat.model;

public class RiskAnalysisEmployeeCoverParam {
	
	HighRisk highRisk;
	MediumRisk mediumRisk;
	NoRisk noRisk;
	public HighRisk getHighRisk() {
		return highRisk;
	}
	public void setHighRisk(HighRisk highRisk) {
		this.highRisk = highRisk;
	}
	public MediumRisk getMediumRisk() {
		return mediumRisk;
	}
	public void setMediumRisk(MediumRisk mediumRisk) {
		this.mediumRisk = mediumRisk;
	}
	public NoRisk getNoRisk() {
		return noRisk;
	}
	public void setNoRisk(NoRisk noRisk) {
		this.noRisk = noRisk;
	}
	@Override
	public String toString() {
		return "RiskAnalysisEmployeeCoverParam [highRisk=" + highRisk + ", mediumRisk=" + mediumRisk + ", noRisk="
				+ noRisk + "]";
	}
}
