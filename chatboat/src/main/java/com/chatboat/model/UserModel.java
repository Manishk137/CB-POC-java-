package com.chatboat.model;

public class UserModel {
	
	private int id;
	private String fName;
	private String mName;
	private String lName;
	private long mobileNo;
	private String emailId;
	private String ldap;
	private long timestamp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLdap() {
		return ldap;
	}
	public void setLdap(String ldap) {
		this.ldap = ldap;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fName=" + fName + ", mName=" + mName + ", lName=" + lName + ", mobileNo="
				+ mobileNo + ", emailId=" + emailId + ", ldap=" + ldap + ", timestamp=" + timestamp + "]";
	}
}
