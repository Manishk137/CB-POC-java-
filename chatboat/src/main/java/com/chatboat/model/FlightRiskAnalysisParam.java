package com.chatboat.model;

import java.math.BigDecimal;

public class FlightRiskAnalysisParam {
	
	private int associates;
	private BigDecimal highRisk;
	private int highRiskEmployeeCount;
	private BigDecimal mediumRisk;
	private int mediumRiskEmployeeCount;
	private BigDecimal noRisk;
	private int noRiskEmployeeCount;
	public int getAssociates() {
		return associates;
	}
	public void setAssociates(int associates) {
		this.associates = associates;
	}
	public BigDecimal getHighRisk() {
		return highRisk;
	}
	public void setHighRisk(BigDecimal highRisk) {
		this.highRisk = highRisk;
	}
	public int getHighRiskEmployeeCount() {
		return highRiskEmployeeCount;
	}
	public void setHighRiskEmployeeCount(int highRiskEmployeeCount) {
		this.highRiskEmployeeCount = highRiskEmployeeCount;
	}
	public BigDecimal getMediumRisk() {
		return mediumRisk;
	}
	public void setMediumRisk(BigDecimal mediumRisk) {
		this.mediumRisk = mediumRisk;
	}
	public int getMediumRiskEmployeeCount() {
		return mediumRiskEmployeeCount;
	}
	public void setMediumRiskEmployeeCount(int mediumRiskEmployeeCount) {
		this.mediumRiskEmployeeCount = mediumRiskEmployeeCount;
	}
	public BigDecimal getNoRisk() {
		return noRisk;
	}
	public void setNoRisk(BigDecimal noRisk) {
		this.noRisk = noRisk;
	}
	public int getNoRiskEmployeeCount() {
		return noRiskEmployeeCount;
	}
	public void setNoRiskEmployeeCount(int noRiskEmployeeCount) {
		this.noRiskEmployeeCount = noRiskEmployeeCount;
	}
	@Override
	public String toString() {
		return "FlightRiskAnalysisParam [associates=" + associates + ", highRisk=" + highRisk
				+ ", highRiskEmployeeCount=" + highRiskEmployeeCount + ", mediumRisk=" + mediumRisk
				+ ", mediumRiskEmployeeCount=" + mediumRiskEmployeeCount + ", noRisk=" + noRisk
				+ ", noRiskEmployeeCount=" + noRiskEmployeeCount + "]";
	}
}
