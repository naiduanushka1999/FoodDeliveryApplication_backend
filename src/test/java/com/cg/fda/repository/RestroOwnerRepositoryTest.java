package com.cg.fda.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.fda.domain.RestroOwner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RestroOwnerRepositoryTest {
	
	@Autowired
	private RestroOwnerRepository restroOwnerRepository;
	
	@Test
	void testfindByOwnerId() {
		 RestroOwner restroOwner=new RestroOwner();
		 restroOwner.setOwnerId("97");
		 restroOwner.setEmail("prakash14@gmail.com");
		 restroOwner.setPhoneNo("9675432456");
		 restroOwner.setPassword("Prakash@1234");
		 restroOwnerRepository.save(restroOwner);
		String ownerId=restroOwner.getOwnerId();
		assertNotNull(restroOwnerRepository.findByOwnerId(ownerId));
		
		
	}

}
