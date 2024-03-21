package com.health.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uId;
	
	@Column(nullable = false,unique = true)
	private String username;
	private String password;
	
	@ManyToOne
	private Role role;
	
	 @JsonIgnore
	    private String secretKey;
	    boolean mfaEnabled;

	private boolean enabled;
	public Long getId() {
		return uId;
	}
	public void setId(Long uId) {
		this.uId = uId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Long getuId() {
		return uId;
	}
	public void setuId(Long uId) {
		this.uId = uId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User(String username, String password, Role role, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public boolean isMfaEnabled() {
		return mfaEnabled;
	}
	public void setMfaEnabled(boolean mfaEnabled) {
		this.mfaEnabled = mfaEnabled;
	}
	public User(String username, String password, Role role, String secretKey, boolean mfaEnabled, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.secretKey = secretKey;
		this.mfaEnabled = mfaEnabled;
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", secretKey=" + secretKey + ", mfaEnabled=" + mfaEnabled + ", enabled=" + enabled + "]";
	}
	
	
}
