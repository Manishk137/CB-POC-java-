package com.chatboat.model;

public class EmployeeExperienceView {
	
	EmployeeRole employeeRole;
	TeamWork teamWork;
	PerformanceManagement performanceManagement;
	ManagerCommunication manager;
	ProcessPolicy processPolicy;
	Leadership  leadership;
	//TotalRewards totalRewards;
	//LearningAndDevelopment learningAndDevelopment;
	
	Career career;
	Culture culture;
	Customer customer;
	DecisionMaking decisionMaking;
	public EmployeeRole getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(EmployeeRole employeeRole) {
		this.employeeRole = employeeRole;
	}
	public TeamWork getTeamWork() {
		return teamWork;
	}
	public void setTeamWork(TeamWork teamWork) {
		this.teamWork = teamWork;
	}
	public PerformanceManagement getPerformanceManagement() {
		return performanceManagement;
	}
	public void setPerformanceManagement(PerformanceManagement performanceManagement) {
		this.performanceManagement = performanceManagement;
	}
	public ManagerCommunication getManager() {
		return manager;
	}
	public void setManager(ManagerCommunication manager) {
		this.manager = manager;
	}
	public ProcessPolicy getProcessPolicy() {
		return processPolicy;
	}
	public void setProcessPolicy(ProcessPolicy processPolicy) {
		this.processPolicy = processPolicy;
	}
	public Leadership getLeadership() {
		return leadership;
	}
	public void setLeadership(Leadership leadership) {
		this.leadership = leadership;
	}
	public Career getCareer() {
		return career;
	}
	public void setCareer(Career career) {
		this.career = career;
	}
	public Culture getCulture() {
		return culture;
	}
	public void setCulture(Culture culture) {
		this.culture = culture;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public DecisionMaking getDecisionMaking() {
		return decisionMaking;
	}
	public void setDecisionMaking(DecisionMaking decisionMaking) {
		this.decisionMaking = decisionMaking;
	}
	@Override
	public String toString() {
		return "EmployeeExperienceView [employeeRole=" + employeeRole + ", teamWork=" + teamWork
				+ ", performanceManagement=" + performanceManagement + ", manager=" + manager + ", processPolicy="
				+ processPolicy + ", leadership=" + leadership + ", career=" + career + ", culture=" + culture
				+ ", customer=" + customer + ", decisionMaking=" + decisionMaking + "]";
	}
}
