package com.cg.fda.repository;
import com.cg.fda.domain.Registration;

 

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@DataJpaTest
public class RegistrationRepositoryTest {
    @Autowired
    private RegistrationRepository repo;
    @Test
    void testRegistration() {

 

        
        Registration data = new Registration();
      data.setUserId("Aswitha25");
      data.setPassword("Aswitha@9");
      data.setEmailId("abcde@gmaill.com");
      data.setContactNo("9083749900");
      repo.save(data);
      assertNotNull(RegistrationRepository.class);
     

 

}
}