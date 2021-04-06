package com.chatboat.model;

public class UnitPulseView {
	
	UnitPulseViewParam unitPulseView;
	EmployeeExperienceView employeeExperienceView;
	public UnitPulseViewParam getUnitPulseView() {
		return unitPulseView;
	}
	public void setUnitPulseView(UnitPulseViewParam unitPulseView) {
		this.unitPulseView = unitPulseView;
	}
	public EmployeeExperienceView getEmployeeExperienceView() {
		return employeeExperienceView;
	}
	public void setEmployeeExperienceView(EmployeeExperienceView employeeExperienceView) {
		this.employeeExperienceView = employeeExperienceView;
	}
	@Override
	public String toString() {
		return "UnitPulseView [unitPulseView=" + unitPulseView + "]";
	}
}
