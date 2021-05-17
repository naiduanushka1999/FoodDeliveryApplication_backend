package com.cg.fda.web;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.fda.domain.FoodCart;
import com.cg.fda.service.FoodCartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	@AutoConfigureMockMvc
	public class FoodCartControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FoodCartService foodCartService;
	
	
	
	@Test
	void testAddFoodCarts() throws Exception 
	{
		
	FoodCart foodcart1= new FoodCart();
	String uri="/api/v2/Carts";
	foodcart1.setFoodCartId(1);
	foodcart1.setFoodItemName("Biryani");
	foodcart1.setFoodItemQuantity("2");
	foodcart1.setFoodItemPrice(200);
	String jsonInput=this.converttoJson(foodcart1);
	Mockito.when(foodCartService.addFoodCarts(Mockito.any(FoodCart.class))).thenReturn(foodcart1);
	MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(uri)
	.accept(MediaType.APPLICATION_JSON)
	.content(jsonInput)
	.contentType(MediaType.APPLICATION_JSON))
	.andReturn();
	
	  assertEquals(HttpStatus.CREATED.value(),mvcResult.getResponse().getStatus());
	
	}
	
	
	@Test
	void testDeleteFoodCart() throws Exception {
	FoodCart foodcart2= new FoodCart();
	String uri="/api/v2/{foodCartId}";
	foodcart2.setFoodCartId(2);
	foodcart2.setFoodItemName("panner");
	foodcart2.setFoodItemQuantity("02");
	foodcart2.setFoodItemPrice(200);
	//product.setQuantity(309);
	int foodcartId=foodcart2.getFoodCartId();
	String jsonInput=this.converttoJson(foodcart2);
	Mockito.when(foodCartService.viewFoodCartByFoodCartId(foodcartId)).thenReturn( foodcart2);
	Mockito.when(foodCartService.deleteFoodCart(foodcartId)).thenReturn(foodcart2);
	MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(uri,2)
	.accept(MediaType.APPLICATION_JSON)
	.content(jsonInput)
	.contentType(MediaType.APPLICATION_JSON))
	.andReturn();
	assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
	}
	
	
	@Test
	void testViewAllFoodCart() throws Exception {
	String uri="/api/v2/all";
	FoodCart foodcart3=new FoodCart();
	foodcart3.setFoodCartId(1);
	foodcart3.setFoodItemName("biryani");
	foodcart3.setFoodItemQuantity("02");
	foodcart3.setFoodItemPrice(300);
	// foodcart1.setQuantity(300);
	FoodCart foodcart4=new FoodCart();
	foodcart4.setFoodCartId(2);
	foodcart4.setFoodItemName("panner");
	foodcart4.setFoodItemQuantity("2");
	foodcart4.setFoodItemPrice(200);
	//product2.setQuantity(309);
	List<FoodCart> foodcartList=new ArrayList<FoodCart>();
	foodcartList.add(foodcart3);
	foodcartList.add(foodcart4);
	String jsonInput=this.converttoJson(foodcartList);
	Mockito.when(foodCartService.viewAllFoodCarts()).thenReturn(foodcartList);
	MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
	.accept(MediaType.APPLICATION_JSON)
	.content(jsonInput)
	.contentType(MediaType.APPLICATION_JSON))
	.andReturn();
	assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
	}

	 @Test
	void testViewFoodCartById() throws Exception {
	String uri="/api/v2/{foodCartId}" ;
	FoodCart foodcart5=new FoodCart();
	foodcart5.setFoodCartId(2);
	foodcart5.setFoodItemName("panner");
	foodcart5.setFoodItemQuantity("2");
	foodcart5.setFoodItemPrice(200);
	// product.setQuantity(309);
	String jsonInput=this.converttoJson(foodcart5);
	MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri,2)
	.accept(MediaType.APPLICATION_JSON)
	.content(jsonInput)
	.contentType(MediaType.APPLICATION_JSON))
	.andReturn();
	assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
	}
	@Test
	void testUpdateFoodCart() throws Exception {
	String uri= "/api/v2/{foodCartId}";
	FoodCart foodcart6=new FoodCart();
	foodcart6.setFoodCartId(1);
	foodcart6.setFoodItemName("biryani");
	foodcart6.setFoodItemQuantity("2");
	foodcart6.setFoodItemPrice(300);
	//product.setQuantity(309);
	String jsonInput=this.converttoJson(foodcart6);
	Mockito.when(foodCartService.updateFoodCart(foodcart6, 2)).thenReturn(foodcart6);
	MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(uri,5)
	.accept(MediaType.APPLICATION_JSON)
	.content(jsonInput)
	.contentType(MediaType.APPLICATION_JSON))
	.andReturn();
	assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	 private String converttoJson(Object foodcart) throws JsonProcessingException {
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(foodcart);
	}
	
	}