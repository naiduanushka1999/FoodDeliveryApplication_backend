package com.cg.fda.service;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.fda.domain.Registration;
import com.cg.fda.exception.ResourceNotFoundException;
import com.cg.fda.repository.LoginRepository;


/*
 * This LoginmoduleServicetest for testing servicelayer
 * @author Aswitha
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class LoginModuleServiceTest {
	  @MockBean
	   private LoginRepository repository;

	    @Autowired
	    private LoginModuleServiceImpl service;
	    
// This method for checking userDetails	    
	@Test
	 void validateUserData() throws ResourceNotFoundException
	{
		Registration data=new Registration();
		data.setUserId("1");
		data.setPassword("vishnu");
//		data.setType("manager");
       Mockito.when(repository.findByID("1")).thenReturn(data);
        assertThat(service.findByID("1")).isEqualTo(data);
	}

}
