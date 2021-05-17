package com.cg.fda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fda.domain.Registration;
import com.cg.fda.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService{
@Autowired
private RegistrationRepository repo;
	@Override
	public Registration createdata(Registration data) {
		
		return repo.save(data);
	}
		
}
