package com.cg.fda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fda.domain.RestroOwner;
import com.cg.fda.repository.RestroOwnerRepository;

@Service
public class RestroOwnerRegistrationImpl implements RestroOwnerRegistrationService{
	@Autowired
	private RestroOwnerRepository repo;

	@Override
	public String RestroOwnerLogin(com.cg.fda.domain.RestroOwnerLogin restroOwnerLogin) {
		// TODO Auto-generated method stub
		String result="";
		RestroOwner restroOwner=repo.findByOwnerId(restroOwnerLogin.getOwnerId());
		if(restroOwner!=null) 
		{
			if(restroOwner.getPassword().equals(restroOwnerLogin.getPassword())){
				result="LOGIN SUCCESSFULL! "
						+ "WELCOME ";
			}
			else
				result="PLEASE ENTER CORRECT PASSWORD!";
		}
		else 
			result="PLEASE ENTER VALID CREDENTIALS!";
		return result;
		
	}

	@Override
	public RestroOwner createRestroOwner(RestroOwner restroOwner) {
		// TODO Auto-generated method stub
		 return repo.save(restroOwner);
	}

	@Override
	public RestroOwner findByID(String ownerId) {
		// TODO Auto-generated method stub
		return repo.findByID(ownerId);
	}

	

	
}
