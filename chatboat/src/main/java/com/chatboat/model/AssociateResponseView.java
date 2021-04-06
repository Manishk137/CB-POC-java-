package com.chatboat.model;

public class AssociateResponseView {
	
	private int totalEmployee;
	private int totalResponse;
	Location location;
	public int getTotalEmployee() {
		return totalEmployee;
	}
	public void setTotalEmployee(int totalEmployee) {
		this.totalEmployee = totalEmployee;
	}
	public int getTotalResponse() {
		return totalResponse;
	}
	public void setTotalResponse(int totalResponse) {
		this.totalResponse = totalResponse;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "AssociateResponseView [totalEmployee=" + totalEmployee + ", totalResponse=" + totalResponse
				+ ", location=" + location + "]";
	}
}
