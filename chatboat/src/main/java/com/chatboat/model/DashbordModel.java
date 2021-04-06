package com.chatboat.model;

public class DashbordModel {

	private int totalAssociates;
	CompanyPulseScoreView companyPulseScoreView;
	AssociateResponseView associateResponseView;
	public int getTotalAssociates() {
		return totalAssociates;
	}
	public void setTotalAssociates(int totalAssociates) {
		this.totalAssociates = totalAssociates;
	}
	public CompanyPulseScoreView getCompanyPulseScoreView() {
		return companyPulseScoreView;
	}
	public void setCompanyPulseScoreView(CompanyPulseScoreView companyPulseScoreView) {
		this.companyPulseScoreView = companyPulseScoreView;
	}
	public AssociateResponseView getAssociateResponseView() {
		return associateResponseView;
	}
	public void setAssociateResponseView(AssociateResponseView associateResponseView) {
		this.associateResponseView = associateResponseView;
	}
	@Override
	public String toString() {
		return "DashbordModel [totalAssociates=" + totalAssociates + ", companyPulseScoreView=" + companyPulseScoreView
				+ ", associateResponseView=" + associateResponseView + "]";
	}
}
