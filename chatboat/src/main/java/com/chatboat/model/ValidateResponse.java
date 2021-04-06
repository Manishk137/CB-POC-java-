package com.chatboat.model;

/**
 * @author Bhanu Pratap Dhakad
 *
 */
public class ValidateResponse {
	
	private String status;
	private String message;
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String ldap;
	private long mobileNo;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "ValidateResponse [status=" + status + ", message=" + message + ", id=" + id + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", emailId=" + emailId + ", ldap=" + ldap
				+ ", mobileNo=" + mobileNo + "]";
	}
}
