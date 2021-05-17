package com.cg.fda.repository;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.fda.domain.DeliveryBoy;

/**
 * this class tests the Customer Repository Interface
 * @author Anushka
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TestDeliveryBoyRepository {
	@Autowired
	private DeliveryBoyRepository deliveryBoyRepository;
	/**
	 * this method tests the find by customer id method 
	 * @throws Exception
	*/
	
	@Test
	void testfindByDeliveryBoyId() {
		 DeliveryBoy deliveryBoy=new DeliveryBoy();
		 deliveryBoy.setDeliveryBoyIdentifier("db54");
		 deliveryBoy.setDeliveryBoyName("prakash");
		 deliveryBoy.setDeliveryBoyPhoneNumber("9563214785");
		 deliveryBoy.setDeliveryBoyEmail("prakash14@gmail.com");
		deliveryBoyRepository.save(deliveryBoy);
		int deliveryId=deliveryBoy.getDeliveryBoyId();
		assertNotNull(deliveryBoyRepository.findByDeliveryBoyId(deliveryId));
		
		
	}

}

