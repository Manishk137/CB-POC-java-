package com.chatboat.model;

public class EnterpriseEmployeeRisk {
	
	EnterpriseEmployeeRiskParam enterpriseEmployeeRisk;

	public EnterpriseEmployeeRiskParam getEnterpriseEmployeeRisk() {
		return enterpriseEmployeeRisk;
	}

	public void setEnterpriseEmployeeRisk(EnterpriseEmployeeRiskParam enterpriseEmployeeRisk) {
		this.enterpriseEmployeeRisk = enterpriseEmployeeRisk;
	}

	@Override
	public String toString() {
		return "EnterpriseEmployeeRisk [enterpriseEmployeeRisk=" + enterpriseEmployeeRisk + "]";
	}
}
