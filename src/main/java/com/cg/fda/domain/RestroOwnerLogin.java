package com.cg.fda.domain;

public class RestroOwnerLogin {

	
	private String OwnerId;
	private String password;
	
	public RestroOwnerLogin() {
		super();
	}

	public RestroOwnerLogin(String ownerId, String password) {
		super();
		OwnerId = ownerId;
		this.password = password;
	}

	public String getOwnerId() {
		return OwnerId;
	}

	public void setOwnerId(String ownerId) {
		OwnerId = ownerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
