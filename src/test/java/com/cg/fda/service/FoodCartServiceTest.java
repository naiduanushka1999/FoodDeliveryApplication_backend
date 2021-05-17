package com.cg.fda.service;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.fda.exception.FoodCartIdNotFoundException;
import com.cg.fda.domain.FoodCart;
import com.cg.fda.repository.FoodCartRepository;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * 
 * @author supriya
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class FoodCartServiceTest {
	@Autowired
	private FoodCartService foodcartService;
	@MockBean
	private FoodCartRepository foodcartRepository;
	@Test
	void addFoodCarts() {
		FoodCart foodcart=new FoodCart();
		foodcart.setFoodCartId(1);
		foodcart.setFoodItemName("biryani");
		foodcart.setFoodItemQuantity("5");
		foodcart.setFoodItemPrice(200);
		
		
		Mockito.when(foodcartRepository.save(foodcart)).thenReturn(foodcart);
        assertThat(foodcartService.addFoodCarts(foodcart)).isEqualTo(foodcart);
		
		}
	@Test
	void deleteFoodCartTest() throws FoodCartIdNotFoundException {
		FoodCart foodcart=new FoodCart();
		foodcart.setFoodCartId(1);
		foodcart.setFoodItemName("Biryani");
		foodcart.setFoodItemQuantity("2");
		foodcart.setFoodItemPrice(300);
		///product.setQuantity(34);
		int foodcartId=foodcart.getFoodCartId();
		Mockito.when(foodcartRepository.findByFoodCartId(foodcartId)).thenReturn(foodcart);
			assertThat(foodcartService.deleteFoodCart(foodcartId)).isEqualTo(foodcart);      
        
			 
	}	
	@Test
	void viewFoodCartById() throws FoodCartIdNotFoundException {
		FoodCart foodcart=new FoodCart();
		foodcart.setFoodCartId(1);
		foodcart.setFoodItemName("Biryani");
		foodcart.setFoodItemQuantity("2");
		foodcart.setFoodItemPrice(300);
		//product.setQuantity(34);
		int foodcartId=foodcart.getFoodCartId();
		Mockito.when(foodcartRepository.findByFoodCartId(foodcartId)).thenReturn(foodcart);
		assertThat(foodcartService.viewFoodCartByFoodCartId(foodcartId)).isEqualTo(foodcart);
		
	}
	
	  @Test
	  void viewAllFoodCarts() { 
		  FoodCart foodcart1=new FoodCart();
		  foodcart1.setFoodCartId(1);
		  foodcart1.setFoodItemName("Biryani");
		  foodcart1.setFoodItemQuantity("2");
		  foodcart1.setFoodItemPrice(300);
	  //product1.setQuantity(23);
	  
	  FoodCart foodcart2=new FoodCart(); 
	  foodcart2.setFoodCartId(2);
	  foodcart2.setFoodItemName("panner");
	  foodcart2.setFoodItemQuantity("1");
	  foodcart2.setFoodItemPrice(100);
	 // product2.setQuantity(300);
	  
	  List<FoodCart> foodcartList=new ArrayList<FoodCart>();
	  foodcartList.add(foodcart1);
	  foodcartList.add(foodcart2);
	  Mockito.when(foodcartRepository.findAll()).thenReturn(foodcartList);
	  assertEquals(foodcartService.viewAllFoodCarts(),foodcartList);
	   }
		

	  @Test void updateFoodCartTest() throws FoodCartIdNotFoundException {
		  FoodCart foodcart=new FoodCart();
		  foodcart.setFoodCartId(2);
		  foodcart.setFoodItemName("panner");
		  foodcart.setFoodItemQuantity("1");
		  foodcart.setFoodItemPrice(100);
		 // product.setQuantity(23);
		 Mockito.when(foodcartRepository.findByFoodCartId(2)).thenReturn(foodcart);
		 foodcart.setFoodItemPrice(200);
		 foodcart.setFoodItemQuantity("2");
		  Mockito.when(foodcartRepository.save(foodcart)).thenReturn(foodcart);
		  assertThat(foodcartService.updateFoodCart(foodcart,2)).isEqualTo(foodcart);
		

	  }
		 
	 
}

