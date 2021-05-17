package com.cg.fda.domain;



import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "admin_Login")
public class AdminLogin {
	@Id
	
    private String username;
	
    
    private String password;
    
	public AdminLogin() {
		
	}
	
	public AdminLogin(String username,String password)
	{ this.username=username;
	  this.password=password;
	}

	public String getusername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	

  
	
}

