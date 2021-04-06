package com.chatboat.model;

public class ChatRequest {
	
	private String emailId;
	private String question;
	private long timestamp;
	private String deviceId;
	private String imei;
	private String _interface;
	private String model;
	private String macId;
	private String version;
	private String msg_by;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String get_interface() {
		return _interface;
	}
	public void set_interface(String _interface) {
		this._interface = _interface;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMacId() {
		return macId;
	}
	public void setMacId(String macId) {
		this.macId = macId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getMsg_by() {
		return msg_by;
	}
	public void setMsg_by(String msg_by) {
		this.msg_by = msg_by;
	}
	@Override
	public String toString() {
		return "ChatRequest [emailId=" + emailId + ", question=" + question + ", timestamp=" + timestamp + ", deviceId="
				+ deviceId + ", imei=" + imei + ", _interface=" + _interface + ", model=" + model + ", macId=" + macId
				+ ", version=" + version + ", msg_by=" + msg_by + "]";
	}
}
