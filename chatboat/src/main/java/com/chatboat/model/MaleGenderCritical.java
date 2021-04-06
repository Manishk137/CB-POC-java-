package com.chatboat.model;

import java.math.BigDecimal;

public class MaleGenderCritical {
	
	private BigDecimal  maleCriticalHighRiskPercentage;
	private int totalMaleCriticalHighRiskEmp;
	public BigDecimal getMaleCriticalHighRiskPercentage() {
		return maleCriticalHighRiskPercentage;
	}
	public void setMaleCriticalHighRiskPercentage(BigDecimal maleCriticalHighRiskPercentage) {
		this.maleCriticalHighRiskPercentage = maleCriticalHighRiskPercentage;
	}
	public int getTotalMaleCriticalHighRiskEmp() {
		return totalMaleCriticalHighRiskEmp;
	}
	public void setTotalMaleCriticalHighRiskEmp(int totalMaleCriticalHighRiskEmp) {
		this.totalMaleCriticalHighRiskEmp = totalMaleCriticalHighRiskEmp;
	}
	@Override
	public String toString() {
		return "MaleGenderCritical [maleCriticalHighRiskPercentage=" + maleCriticalHighRiskPercentage
				+ ", totalMaleCriticalHighRiskEmp=" + totalMaleCriticalHighRiskEmp + "]";
	}
}
