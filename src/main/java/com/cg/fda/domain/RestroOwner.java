package com.cg.fda.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class RestroOwner {	
	@Id
	private String ownerId;	
	private String email;
	private String phoneNo;
	private String password;
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RestroOwner(String ownerId, String email, String phoneNo, String password) {
		super();
		this.ownerId = ownerId;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
	}
	public RestroOwner() {
		super();
	}
	
	
	
	
}
