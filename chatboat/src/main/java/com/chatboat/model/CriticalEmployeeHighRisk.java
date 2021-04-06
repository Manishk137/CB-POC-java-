package com.chatboat.model;

public class CriticalEmployeeHighRisk {

	CriticalEmployeeHighRiskParam CriticalEmployeeHighRisk;

	public CriticalEmployeeHighRiskParam getCriticalEmployeeHighRisk() {
		return CriticalEmployeeHighRisk;
	}

	public void setCriticalEmployeeHighRisk(CriticalEmployeeHighRiskParam criticalEmployeeHighRisk) {
		CriticalEmployeeHighRisk = criticalEmployeeHighRisk;
	}

	@Override
	public String toString() {
		return "CriticalEmployeeHighRisk [CriticalEmployeeHighRisk=" + CriticalEmployeeHighRisk + "]";
	}
}
