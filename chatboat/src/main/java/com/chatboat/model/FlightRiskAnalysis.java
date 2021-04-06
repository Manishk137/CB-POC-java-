package com.chatboat.model;

public class FlightRiskAnalysis {
	
	FlightRiskAnalysisParam flightRiskAnalysis;

	public FlightRiskAnalysisParam getFlightRiskAnalysis() {
		return flightRiskAnalysis;
	}

	public void setFlightRiskAnalysis(FlightRiskAnalysisParam flightRiskAnalysis) {
		this.flightRiskAnalysis = flightRiskAnalysis;
	}

	@Override
	public String toString() {
		return "FlightRiskAnalysis [flightRiskAnalysis=" + flightRiskAnalysis + "]";
	}
}
