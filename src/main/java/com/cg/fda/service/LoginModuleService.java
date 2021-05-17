package com.cg.fda.service;

import com.cg.fda.domain.Registration;

/*
 * ServiceLayer
 * @author Aswitha
 */
public interface LoginModuleService {
	
	public Registration findByID(String userId);
	
	
}
