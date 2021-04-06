package com.chatboat.model;

import java.math.BigDecimal;

public class FlightMediumRisk {

	private BigDecimal  mediumRiskPercentage;
	private int totalMediumRiskEmployee;
	public BigDecimal getMediumRiskPercentage() {
		return mediumRiskPercentage;
	}
	public void setMediumRiskPercentage(BigDecimal mediumRiskPercentage) {
		this.mediumRiskPercentage = mediumRiskPercentage;
	}
	public int getTotalMediumRiskEmployee() {
		return totalMediumRiskEmployee;
	}
	public void setTotalMediumRiskEmployee(int totalMediumRiskEmployee) {
		this.totalMediumRiskEmployee = totalMediumRiskEmployee;
	}
	@Override
	public String toString() {
		return "FlightMediumRisk [mediumRiskPercentage=" + mediumRiskPercentage + ", totalMediumRiskEmployee="
				+ totalMediumRiskEmployee + "]";
	}
}
