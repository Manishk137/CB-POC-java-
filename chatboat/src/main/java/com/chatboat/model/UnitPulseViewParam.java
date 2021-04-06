package com.chatboat.model;

public class UnitPulseViewParam {
	
	private int totalAssociates;
	private int totalBusinesUnit;
	
	BusinesUnitA buA;
	BusinesUnitB buB;
	BusinesUnitC buC;
	BusinesUnitD buD;
	public int getTotalAssociates() {
		return totalAssociates;
	}
	public void setTotalAssociates(int totalAssociates) {
		this.totalAssociates = totalAssociates;
	}
	public int getTotalBusinesUnit() {
		return totalBusinesUnit;
	}
	public void setTotalBusinesUnit(int totalBusinesUnit) {
		this.totalBusinesUnit = totalBusinesUnit;
	}
	public BusinesUnitA getBuA() {
		return buA;
	}
	public void setBuA(BusinesUnitA buA) {
		this.buA = buA;
	}
	public BusinesUnitB getBuB() {
		return buB;
	}
	public void setBuB(BusinesUnitB buB) {
		this.buB = buB;
	}
	public BusinesUnitC getBuC() {
		return buC;
	}
	public void setBuC(BusinesUnitC buC) {
		this.buC = buC;
	}
	public BusinesUnitD getBuD() {
		return buD;
	}
	public void setBuD(BusinesUnitD buD) {
		this.buD = buD;
	}
	@Override
	public String toString() {
		return "UnitPulseViewParam [totalAssociates=" + totalAssociates + ", totalBusinesUnit=" + totalBusinesUnit
				+ ", buA=" + buA + ", buB=" + buB + ", buC=" + buC + ", buD=" + buD + "]";
	}
}
