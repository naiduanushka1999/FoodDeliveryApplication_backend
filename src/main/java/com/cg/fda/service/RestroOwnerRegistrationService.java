package com.cg.fda.service;


import com.cg.fda.domain.RestroOwner;
import com.cg.fda.domain.RestroOwnerLogin;

public interface RestroOwnerRegistrationService  {

	  public String RestroOwnerLogin(RestroOwnerLogin restroOwnerLogin);
	//public String restroOwnerRegistration(RestroOwner restroOwner);
	  public RestroOwner createRestroOwner(RestroOwner restroOwner);
	  public RestroOwner findByID(String ownerId);
}
