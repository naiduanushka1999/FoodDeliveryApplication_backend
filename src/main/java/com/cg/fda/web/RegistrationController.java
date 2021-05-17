package com.cg.fda.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fda.domain.Registration;
import com.cg.fda.exception.ResourceNotFoundException;
import com.cg.fda.exception.UserValidate;
import com.cg.fda.service.RegistrationService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/api/v2")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/userRegistration/createUserDetails")
	public Registration createdata(@RequestBody Registration data) throws ResourceNotFoundException {
		UserValidate vali = new UserValidate();
		Registration data1;
		boolean v = vali.validateUser(data.getUserId());
		boolean v1 = vali.validatePassword(data.getPassword());
		if (data.getUserId().equals("") || data.getPassword().equals("") || data.getEmailId().equals("")) {
			throw new ResourceNotFoundException("Enter Valid Data");
		}
		if (v) {
			if (v1) {
				data1 = registrationService.createdata(data);
			} else {
				throw new ResourceNotFoundException("Enter Valid Password ");
			}
		} else {
			throw new ResourceNotFoundException("Enter Valid UserId ");
		}
		return data1;
	}

}
