package com.health.dto;

public class MfaTokenData {
    private String qrCode;
    private String mfaCode;
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public String getMfaCode() {
		return mfaCode;
	}
	public void setMfaCode(String mfaCode) {
		this.mfaCode = mfaCode;
	}
	public MfaTokenData(String qrCode, String mfaCode) {
		super();
		this.qrCode = qrCode;
		this.mfaCode = mfaCode;
	}
    
    public MfaTokenData() {
		// TODO Auto-generated constructor stub
	}
}
