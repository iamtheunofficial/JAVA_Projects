package com.health.dto;


public class MfaVerificationResponse {
    private String username;
    private String jwt;
    private boolean mfaRequired;
    private boolean authValid;
    private boolean tokenValid;
    private String message;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public boolean isMfaRequired() {
		return mfaRequired;
	}
	public void setMfaRequired(boolean mfaRequired) {
		this.mfaRequired = mfaRequired;
	}
	public boolean isAuthValid() {
		return authValid;
	}
	public void setAuthValid(boolean authValid) {
		this.authValid = authValid;
	}
	public boolean isTokenValid() {
		return tokenValid;
	}
	public void setTokenValid(boolean tokenValid) {
		this.tokenValid = tokenValid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MfaVerificationResponse(String username, String jwt, boolean mfaRequired, boolean authValid,
			boolean tokenValid, String message) {
		super();
		this.username = username;
		this.jwt = jwt;
		this.mfaRequired = mfaRequired;
		this.authValid = authValid;
		this.tokenValid = tokenValid;
		this.message = message;
	}
    
    public MfaVerificationResponse() {
		// TODO Auto-generated constructor stub
	}
}
