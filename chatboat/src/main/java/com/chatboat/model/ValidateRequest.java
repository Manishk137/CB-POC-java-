package com.chatboat.model;

public class ValidateRequest {
	
	private String emailId;
	private String ldap;
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
	@Override
	public String toString() {
		return "ValidateRequest [emailId=" + emailId + ", ldap=" + ldap + "]";
	}
}
