package com.cg.fda.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fda.domain.AdminLogin;
import com.cg.fda.service.MainAdminService;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v2")
public class MainAdminController {
 
	
	 private static final Logger LOGGER = LogManager.getLogger(MainAdminController.class);
		
		@Autowired
		private MainAdminService mainAdminService;
		
		/**
		 * adminLogin()
		 * To validate adminId and password
		 * @param adminLogin
		 * @return String message
		 */
		@PostMapping("/adminLogin")
		String adminLogin(@Valid @RequestBody AdminLogin adminLogin) {
			LOGGER.info("Entered inside admin login in controller");
			return mainAdminService.adminLogin(adminLogin);
		}
		
}
