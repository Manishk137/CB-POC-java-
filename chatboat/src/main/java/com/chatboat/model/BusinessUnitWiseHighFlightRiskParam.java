package com.chatboat.model;

import java.math.BigDecimal;

public class BusinessUnitWiseHighFlightRiskParam {
	
	private int totalHighRiskAssociates;
	private BigDecimal  percenteOfBusinesUnit1;
	private BigDecimal  percenteOfBusinesUnit2;
	private BigDecimal  percenteOfBusinesUnit3;
	private BigDecimal  percenteOfBusinesUnit4;
	public int getTotalHighRiskAssociates() {
		return totalHighRiskAssociates;
	}
	public void setTotalHighRiskAssociates(int totalHighRiskAssociates) {
		this.totalHighRiskAssociates = totalHighRiskAssociates;
	}
	public BigDecimal getPercenteOfBusinesUnit1() {
		return percenteOfBusinesUnit1;
	}
	public void setPercenteOfBusinesUnit1(BigDecimal percenteOfBusinesUnit1) {
		this.percenteOfBusinesUnit1 = percenteOfBusinesUnit1;
	}
	public BigDecimal getPercenteOfBusinesUnit2() {
		return percenteOfBusinesUnit2;
	}
	public void setPercenteOfBusinesUnit2(BigDecimal percenteOfBusinesUnit2) {
		this.percenteOfBusinesUnit2 = percenteOfBusinesUnit2;
	}
	public BigDecimal getPercenteOfBusinesUnit3() {
		return percenteOfBusinesUnit3;
	}
	public void setPercenteOfBusinesUnit3(BigDecimal percenteOfBusinesUnit3) {
		this.percenteOfBusinesUnit3 = percenteOfBusinesUnit3;
	}
	public BigDecimal getPercenteOfBusinesUnit4() {
		return percenteOfBusinesUnit4;
	}
	public void setPercenteOfBusinesUnit4(BigDecimal percenteOfBusinesUnit4) {
		this.percenteOfBusinesUnit4 = percenteOfBusinesUnit4;
	}
	@Override
	public String toString() {
		return "BusinessUnitWiseHighFlightRiskParam [totalHighRiskAssociates=" + totalHighRiskAssociates
				+ ", percenteOfBusinesUnit1=" + percenteOfBusinesUnit1 + ", percenteOfBusinesUnit2="
				+ percenteOfBusinesUnit2 + ", percenteOfBusinesUnit3=" + percenteOfBusinesUnit3
				+ ", percenteOfBusinesUnit4=" + percenteOfBusinesUnit4 + "]";
	}
}
