package com.chatboat.model;

public class EnterpriseEmployeeRiskParam {
	
	FlightHighRisk flightHighRisk;
	FlightMediumRisk flightMediumRisk;
	private int totalAssociate;
	
	AgeGroup ageGroup;
	Performers performers;
	Educations educations;
	Experience experience;
	Gender gender;
	public FlightHighRisk getFlightHighRisk() {
		return flightHighRisk;
	}
	public void setFlightHighRisk(FlightHighRisk flightHighRisk) {
		this.flightHighRisk = flightHighRisk;
	}
	public FlightMediumRisk getFlightMediumRisk() {
		return flightMediumRisk;
	}
	public void setFlightMediumRisk(FlightMediumRisk flightMediumRisk) {
		this.flightMediumRisk = flightMediumRisk;
	}
	public int getTotalAssociate() {
		return totalAssociate;
	}
	public void setTotalAssociate(int totalAssociate) {
		this.totalAssociate = totalAssociate;
	}
	public AgeGroup getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}
	public Performers getPerformers() {
		return performers;
	}
	public void setPerformers(Performers performers) {
		this.performers = performers;
	}
	public Educations getEducations() {
		return educations;
	}
	public void setEducations(Educations educations) {
		this.educations = educations;
	}
	public Experience getExperience() {
		return experience;
	}
	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "EnterpriseEmployeeRiskParam [flightHighRisk=" + flightHighRisk + ", flightMediumRisk="
				+ flightMediumRisk + ", totalAssociate=" + totalAssociate + ", ageGroup=" + ageGroup + ", performers="
				+ performers + ", educations=" + educations + ", experience=" + experience + ", gender=" + gender + "]";
	}
}
