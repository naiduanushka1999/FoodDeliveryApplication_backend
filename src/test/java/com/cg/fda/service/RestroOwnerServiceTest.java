package com.cg.fda.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.fda.domain.RestroOwner;
import com.cg.fda.repository.RestroOwnerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestroOwnerServiceTest {

	
	 @MockBean
	    private RestroOwnerRepository restroOwnerRepository;

	 

	    @Autowired
	    private RestroOwnerRegistrationService restroOwnerRegistrationService;
	    
	   
	    
	    @Test
	    void testCreateRestroOwner(){
	         RestroOwner restroOwner = new  RestroOwner();
	         restroOwner.setOwnerId("Prakash@12");
			 restroOwner.setEmail("prakash14@gmail.com");
			 restroOwner.setPhoneNo("9675432456");
			 restroOwner.setPassword("Prakash@1234");
	        Mockito.when(restroOwnerRepository.save(restroOwner)).thenReturn(restroOwner);
	        assertThat(restroOwnerRegistrationService.createRestroOwner(restroOwner)).isEqualTo(restroOwner);
	        
	    }
	    
	  
	
}
