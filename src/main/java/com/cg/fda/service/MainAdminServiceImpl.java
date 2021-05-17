package com.cg.fda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fda.domain.AdminLogin;
import com.cg.fda.repository.LoginRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Service
public class MainAdminServiceImpl implements MainAdminService {
	 private static final Logger logger = LogManager.getLogger(MainAdminServiceImpl.class);
	 
	 @Autowired
	 private LoginRepository repository;


	@Override
	public String adminLogin(AdminLogin adminLogin) {
	
		logger.info("Inside admin login in service");
		String result="";
		AdminLogin login=repository.findByAdminUsername(adminLogin.getusername());
		if(login!=null) 
		{
			if(login.getPassword().equals(adminLogin.getPassword())){
				result="LOGIN SUCCESSFULL! ";
			}
			else
				result="PLEASE ENTER CORRECT PASSWORD!";
		}
		else 
			result="PLEASE ENTER VALID CREDENTIALS!";
		return result;
	
		
	}

}
