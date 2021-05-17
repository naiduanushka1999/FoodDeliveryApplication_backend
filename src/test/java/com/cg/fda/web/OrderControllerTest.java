package com.cg.fda.web;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.fda.domain.Order;
import com.cg.fda.repository.OrderRepository;
import com.cg.fda.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

 

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OrderController.class)
public class OrderControllerTest {

 

    @Autowired
    MockMvc mockMvc;

 

    @MockBean
    OrderService orderService;
    
    @MockBean
    OrderRepository orderRepository;

 


    @Test
    public void testCreateOrder() throws Exception {
        Order order = new Order(3, "shivani", "9550355319", "shivani@gmail.com", "125/B");
        String jsonInput = this.converttoJson(order);
        Mockito.when(orderService.createOrder(Mockito.any(Order.class))).thenReturn(order);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/Order")
                .accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }

 

    @Test
    public void testDeleteOrderById() throws Exception {
    	String uri="/Order/{id}";
		  Order order=new Order();
		    order.setorderId(10);
			order.setUserName("Akash");
			order.setUserPhone("9654345678");
			order.setUserEmailId("akash12@gmail.com");
			order.setUserAddress("pune");
			
			Mockito.when(orderRepository.findByOrderId(1)).thenReturn(order);
			Mockito.when(orderService.deleteOrderById(1)).thenReturn(true);
	       this.mockMvc.perform(MockMvcRequestBuilders.delete(uri, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
	      
	        
    }

 

   @Test
    public void testUpdateOrder() throws Exception {
	   String URI="/Order/{id}";
	   Order order=new Order();
	    order.setorderId(20);
		order.setUserName("Anushka");
		order.setUserPhone("9645367823");
		order.setUserEmailId("anushka12@gmail.com");
		order.setUserAddress("pune");
		  String jsonInput=this.converttoJson(order);
		  Mockito.when(orderService.updateOrderById(20, order)).thenReturn(order);
		  this.mockMvc.perform(MockMvcRequestBuilders.put(URI,20)
               .accept(MediaType.APPLICATION_JSON)
               .content(jsonInput)
               .contentType(MediaType.APPLICATION_JSON))
               .andReturn();
		 
    }

 

    @Test
    public void testGetAllOrder() throws Exception {

 

        Order order1 = new Order(4, "Kumar", "9573304286", "kumar@gmail.com", "Tirupathi");
        Order order2 = new Order(4, "Kumar", "9573304286", "kumar@gmail.com", "Tirupathi");
        List<Order> orderlist = new ArrayList<>();
        orderlist.add(order1);
        orderlist.add(order2);
        String jsonInput = this.converttoJson(orderlist);

 

        Mockito.when(orderService.getAllOrder()).thenReturn(orderlist);
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v2/Order").accept(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
    }

    private String converttoJson(Object order) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(order);
    }
}
