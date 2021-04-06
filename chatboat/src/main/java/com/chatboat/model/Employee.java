package com.chatboat.model;

public class Employee {
	
	private int id;
	private String name;
	private float pulse;
	private String critical;
	private String band;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPulse() {
		return pulse;
	}
	public void setPulse(float pulse) {
		this.pulse = pulse;
	}
	public String getCritical() {
		return critical;
	}
	public void setCritical(String critical) {
		this.critical = critical;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", pulse=" + pulse + ", critical=" + critical + ", band="
				+ band + ", location=" + location + "]";
	}
}
