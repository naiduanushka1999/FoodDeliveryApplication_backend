package com.cg.fda.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fda.domain.RestroOwner;
import com.cg.fda.domain.RestroOwnerLogin;
import com.cg.fda.service.RestroOwnerRegistrationService;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v2")
public class RestroOwnerController {
	private static final Logger LOGGER = LogManager.getLogger(RestroOwnerController.class);
	
	@Autowired
	private RestroOwnerRegistrationService restroService;
	
	/**
	 * restroOwnerLogin()
	 * To validate owner ownerId and password
	 * @param restroOwnerLogin
	 * @return String message
	 */
	@PostMapping("/restrologin")
	String applicantLogin(@Valid @RequestBody RestroOwnerLogin restroOwnerLogin) {
		LOGGER.info("Entered inside login in controller");
		return restroService.RestroOwnerLogin(restroOwnerLogin);
	}
	
	
	/**
	 * createRestroOwner()
	 * To create new restroOwner in database
	 * @param restroOwner
	 * @return restroOwner
	 */
	@PostMapping("/createRestroOwner")
	public RestroOwner createRestroOwner(@Valid @RequestBody RestroOwner restroOwner) {
		LOGGER.info("Entered inside createRestroOwner in controller");
		return restroService.createRestroOwner(restroOwner);
	}
	
}
