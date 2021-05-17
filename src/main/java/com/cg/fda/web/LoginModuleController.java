package com.cg.fda.web;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fda.domain.Registration;
import com.cg.fda.exception.ResourceNotFoundException;
import com.cg.fda.exception.UserValidate;
import com.cg.fda.service.LoginModuleService;


/*
 * This Controller for testing in postman
 * 
 * @author Aswitha
 * 
 */
@CrossOrigin(origins = "*",allowedHeaders="*")
@RestController
@RequestMapping("/api/v2")
public class LoginModuleController {
	// creating variable
private	static Registration data; //static data
	
	@Autowired
	private LoginModuleService service;
	
	/*
	 * This get Method for checking userId,password
	 */
	@GetMapping("/Login/{userId}/{password}")
	public ResponseEntity<String> validateUser(@PathVariable(value = "userId") String userId,@PathVariable(value="password") String password)
			throws ResourceNotFoundException {
		
		UserValidate validate=new UserValidate();
		boolean userValidate=validate.validateUser(userId);
		boolean passwordValidate=validate.validatePassword(password,userId); //validating password
		if(userValidate )
		{
			if(passwordValidate)
			{
		Logger logger=Logger.getLogger(Registration.class);
			data =  service.findByID(userId);
			
			logger.info("ending services");
			logger.debug("running");
					
			if(data!=null)
			{
			if(data.getPassword().equals(password) && data.getUserId().equals(userId))
			{
				logger.info("sucess");
				
				
				
				return ResponseEntity.ok().body("sucess login");
			}
			}else
			{
				throw new ResourceNotFoundException("User not found for this id :: " + userId);
				}
		
		return ResponseEntity.ok().body("invalid login");
	}else 
	{
		if(password.substring(0,6).equals(userId.subSequence(0,6)))
		{
			return ResponseEntity.ok().body("invalid user Id does not match with userName ");
		}
		else { 
	return ResponseEntity.ok().body("invalid Password");
	}
		}
		}
		else {
			
		return ResponseEntity.ok().body("invalid userId Enter Valid userId ");
		}
}
	
}