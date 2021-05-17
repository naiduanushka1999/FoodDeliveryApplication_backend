package com.cg.fda.service;



import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.*;

import com.cg.fda.domain.DeliveryBoy;
import com.cg.fda.exception.DeliveryBoyException;
import com.cg.fda.exception.ResourceNotFoundException;
import com.cg.fda.repository.DeliveryBoyRepository;


/**
 * A class to test the various methods of the delivery boy service layer.
 * @author anushka
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class DeliveryBoyServiceTest {
		
	@MockBean
	private DeliveryBoyRepository deliveryBoyRepository;
	
	@Autowired
	FoodDeliveryBoyService foodDeliveryBoyService;
	
	@InjectMocks
	DeliveryBoyService deliveryBoyService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	/**
	 * Testing the saveOrUpdate method of service class by giving correct inputs.
	 */
	@Test
	void test1_saveOrUpdate() {
		DeliveryBoy deliveryBoy = new DeliveryBoy(3,"Db02","Aarush","89123456789","db02@gmail.com");
		BDDMockito.given(deliveryBoyRepository.save(deliveryBoy)).willReturn(deliveryBoy);
		DeliveryBoy deliveryBoyGot = deliveryBoyService.saveOrUpdate(deliveryBoy);
		assertNotNull(deliveryBoyGot);
	}
	
	/**
	 * Testing the saveOrUpdate method of service class by giving incorrect input.
	 */
	@Test
	void test2_saveOrUpdate() {
		DeliveryBoy deliveryBoy = new DeliveryBoy(10,"Db2","Aarush","89123456789","db02@gmail.com");
		BDDMockito.given(deliveryBoyRepository.save(deliveryBoy)).willThrow(new DeliveryBoyException("Delivery boy identifier"));
		assertThrows(DeliveryBoyException.class, ()->deliveryBoyService.saveOrUpdate(deliveryBoy));
	}
	
	 @Test
	    public void test3_DeleteDeliveryBoyById() throws Exception{
		 DeliveryBoy deliveryBoy=new DeliveryBoy();		 
		  deliveryBoy.setDeliveryBoyId(2);
		  deliveryBoy.setDeliveryBoyName("Paresh");
		  deliveryBoy.setDeliveryBoyPhoneNumber("9586321475");
		  deliveryBoy.setDeliveryBoyIdentifier("db45");
		  deliveryBoy.setDeliveryBoyEmail("paresh66@gmail.com");
	        try {
	        Mockito.when(deliveryBoyRepository.save(deliveryBoy)).thenReturn(deliveryBoy);
	        Mockito.when(deliveryBoyRepository.findById(2).get()).thenReturn(deliveryBoy);
	        deliveryBoyRepository.deleteById(deliveryBoy.getDeliveryBoyId());
	        Mockito.when(deliveryBoyRepository.findById(2).get()).thenReturn(deliveryBoy);
	        assertNotEquals(deliveryBoy, new DeliveryBoy());
	        assertEquals(foodDeliveryBoyService.deleteDeliveryBoyById(2), false);
	      }catch(Exception e) { 	 
	    }
	    }
	
	@Test
	void test4_FindDeliveryBoyById() throws ResourceNotFoundException {
		DeliveryBoy deliveryBoy=new DeliveryBoy();		 
		  deliveryBoy.setDeliveryBoyId(8);
		  deliveryBoy.setDeliveryBoyName("vinod");
		  deliveryBoy.setDeliveryBoyPhoneNumber("8523945214");
		  deliveryBoy.setDeliveryBoyIdentifier("db34");
		  deliveryBoy.setDeliveryBoyEmail("vinod32@gmail.com");
		  int deliveryBoyId=deliveryBoy.getDeliveryBoyId();
		Mockito.when(deliveryBoyRepository.findByDeliveryBoyId(deliveryBoyId)).thenReturn(deliveryBoy);
		assertThat(foodDeliveryBoyService.listDeliveryBoyById(deliveryBoyId)).isEqualTo(deliveryBoy);
		
	}
	
	  @Test
	  void test5_FindAllDeliveryBoys() { 
		  DeliveryBoy deliveryBoy1=new DeliveryBoy();		 
		  deliveryBoy1.setDeliveryBoyId(7);
		  deliveryBoy1.setDeliveryBoyName("rakesh");
		  deliveryBoy1.setDeliveryBoyPhoneNumber("9857463145");
		  deliveryBoy1.setDeliveryBoyIdentifier("db12");
		  deliveryBoy1.setDeliveryBoyEmail("rakesh55@gmail.com");
	  
		  DeliveryBoy deliveryBoy2=new DeliveryBoy();		 
		  deliveryBoy2.setDeliveryBoyId(12);
		  deliveryBoy2.setDeliveryBoyName("ram");
		  deliveryBoy2.setDeliveryBoyPhoneNumber("9857456321");
		  deliveryBoy2.setDeliveryBoyIdentifier("db22");
		  deliveryBoy2.setDeliveryBoyEmail("ram77@gmail.com");
	  
	  
	      List<DeliveryBoy> deliveryBoyList=new ArrayList<DeliveryBoy>();
	      deliveryBoyList.add(deliveryBoy1);
	      deliveryBoyList.add(deliveryBoy2);
	      Mockito.when(deliveryBoyRepository.findAll()).thenReturn(deliveryBoyList);
	      assertEquals(foodDeliveryBoyService.findAllDeliveryBoys(),deliveryBoyList);
	   }
		

	  @Test void test6_updateDeliveryBoy() throws ResourceNotFoundException {
		  DeliveryBoy deliveryBoy=new DeliveryBoy();		 
		  deliveryBoy.setDeliveryBoyId(8);
		  deliveryBoy.setDeliveryBoyName("vinod");
		  deliveryBoy.setDeliveryBoyPhoneNumber("8523945214");
		  deliveryBoy.setDeliveryBoyIdentifier("db34");
		  deliveryBoy.setDeliveryBoyEmail("vinod32@gmail.com");
		 Mockito.when(deliveryBoyRepository.findByDeliveryBoyId(8)).thenReturn(deliveryBoy);
		  deliveryBoy.setDeliveryBoyEmail("vinod67@gmail.com");
		  deliveryBoy.setDeliveryBoyPhoneNumber("7541236958");
		  Mockito.when(deliveryBoyRepository.save(deliveryBoy)).thenReturn(deliveryBoy);
		  assertThat(foodDeliveryBoyService.updateDeliveryBoy(deliveryBoy,8)).isEqualTo(deliveryBoy);
		

	  }
		 
	 
}
