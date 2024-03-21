package com.health.dto;

public class MfaVerificationRequest {
    private String username;
    private String totp;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTotp() {
		return totp;
	}
	public void setTotp(String totp) {
		this.totp = totp;
	}
    
    public MfaVerificationRequest() {
		// TODO Auto-generated constructor stub
	}
	public MfaVerificationRequest(String username, String totp) {
		super();
		this.username = username;
		this.totp = totp;
	}
    
}
