package com.cg.fda.service;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fda.domain.Registration;
import com.cg.fda.repository.LoginRepository;


/*
 * This service for sending request to DAO
 * 
 *@author Aswitha
 */
@Service
public class LoginModuleServiceImpl implements LoginModuleService{
@Autowired
private LoginRepository repository;

//This method for validating userId is present or not
public Registration findByID(String userId) {
	Logger logger=Logger.getLogger(LoginModuleServiceImpl.class);
	logger.info("entering services");
	return repository.findByID(userId);	
}




}
