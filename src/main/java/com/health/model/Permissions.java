package com.health.model;

public enum Permissions {

	WRITE("to_write"),
	READ("to_read"),
	UPDATE("to_update"),
	DELETE("to_delete");
	
	private final String permission;
	
	private Permissions(String permission) {
		this.permission=permission;
	}
}
