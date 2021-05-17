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
import com.cg.fda.repository.RegistrationRepository;

 

 

@RunWith(SpringRunner.class)
@SpringBootTest
 class RegistrationServiceTest {

 

    @MockBean
    private RegistrationRepository RegistrationRepository;

 

    @Autowired
    private RegistrationService RegistrationService;

 

    @Test
    void testCreateUserData(){
         Registration data = new  Registration();
         data.setUserId("Aswitha25");
         data.setPassword("Aswitha@9");
         data.setEmailId("abcde@gmail.com");
         data.setContactNo("8999999900");
        Mockito.when(RegistrationRepository.save(data)).thenReturn(data);
        assertThat(RegistrationService.createdata(data)).isEqualTo(data);
        
    }

 

   
  
  
}