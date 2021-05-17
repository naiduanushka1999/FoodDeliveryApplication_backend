package com.cg.fda.repository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.fda.domain.Registration;
import com.cg.fda.exception.ResourceNotFoundException;


/*
 * This LoginModuleRepostryTest for testing RepostryLayer
 * @author Aswitha
 */
@RunWith(SpringRunner.class)
@DataJpaTest
class LoginModuleRepostryTest {
	@Autowired
	private  LoginRepository lv;

	@Autowired
	private TestEntityManager test;
    
	//This validateUserData for checking for userData
	@Test
	void validateUserData() throws ResourceNotFoundException
	{
		boolean flag=false;
		Registration data=new Registration();
		data.setUserId("1");
		data.setPassword("Aswitha");
		test.persist(data);
		
		Registration v;
				v=lv.findByID(data.getUserId());
					if(v.getUserId().equals("1") && v.getPassword().equals(data.getPassword()))
				{
					flag=true;
				}
    assertTrue(flag);
	}

}
