package com.cg.fda.web;
 

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.validation.BindingResult;

import com.cg.fda.domain.DeliveryBoy;
import com.cg.fda.exception.DeliveryBoyException;
import com.cg.fda.repository.DeliveryBoyRepository;
import com.cg.fda.service.DeliveryBoyService;
import com.cg.fda.service.FoodDeliveryBoyService;
import com.cg.fda.service.FoodDeliveryBoyServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = DeliveryBoyController.class)
@AutoConfigureMockMvc
class DeliveryBoyControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	DeliveryBoyService deliveryBoyService;
	
	@MockBean
	FoodDeliveryBoyService  foodDeliveryBoyService;
	
	@MockBean
	FoodDeliveryBoyServiceImpl  foodDeliveryBoyServiceImpl;
	
	@MockBean
	MapValidationErrorService mapValidationErrorService;
	
	@InjectMocks
	DeliveryBoyController deliveryBoyController;
	
	@MockBean
	DeliveryBoyRepository deliveryBoyRepository;
	
	/**
	 * Testing the createDeliveryBoy method of the rest controller by giving the valid data of patient.
	 * @throws Exception
	 */
	@Test
	void test1_CreateNewDeliveryBoy() throws Exception{
		BindingResult result = null;
		BDDMockito.given(mapValidationErrorService.mapValidationService(result)).willReturn(null);
		DeliveryBoy deliveryBoy = new DeliveryBoy(3,"Db02","Aarush","89123456789","db02@gmail.com");
		BDDMockito.given(deliveryBoyService.saveOrUpdate(Mockito.any())).willReturn(deliveryBoy);
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson = objectMapper.writeValueAsString(deliveryBoy);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v2")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$").isMap())
				.andExpect(jsonPath("deliveryBoyName").value("Aarush"))
				.andExpect(jsonPath("deliveryBoyIdentifier").value("Db02"))
				.andExpect(jsonPath("deliveryBoyPhoneNumber").value("89123456789"))
				.andExpect(jsonPath("deliveryBoyEmail").value("db02@gmail.com"));
	}
	
	/**
	 * Testing the createDeliveryBoy method of the rest controller by giving the invalid data of patient.
	 * @throws Exception
	 */
	@Test
	void test2_CreateNewDeliveryBoy() throws Exception{
		BindingResult result = null;
		BDDMockito.given(mapValidationErrorService.mapValidationService(result)).willReturn(null);
		DeliveryBoy deliveryBoy = new DeliveryBoy(2,"Db2","Aarush","89123456789","db02@gmail.com");
		BDDMockito.given(deliveryBoyService.saveOrUpdate(Mockito.any())).willThrow(new DeliveryBoyException());
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson = objectMapper.writeValueAsString(deliveryBoy);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v2")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(inputJson))
		.andExpect(status().isBadRequest());
	}
	
	/**
	 * Testing the DeletedeliveryBoy method of the rest controller by giving valid data
	 *  
	*/
	
	@Test
	public void test3_DeleteDeliveryBoy() throws Exception {
		String URI="/api/v2/deliveryBoy/{id}";
		DeliveryBoy deliveryBoy=new DeliveryBoy(1,"kamlesh45@gmail.com","db67","kamlesh","9877565782");
		Mockito.when(deliveryBoyRepository.findByDeliveryBoyId(1)).thenReturn(deliveryBoy);
		Mockito.when(foodDeliveryBoyService.deleteDeliveryBoyById(1)).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonOutput).isEqualTo("Delivery Boy with Id : 1 Deleted!");
	}
	
	/**
	 * this method tests the update delivery boy operation
	 * @throws Exception
	 
	*/
	 @Test
	 void test4_UpdateDeliveryBoy() throws Exception {
		 String URI="/api/v2/deliveryBoy/{id}";
		  DeliveryBoy deliveryBoy=new DeliveryBoy();		 
		  deliveryBoy.setDeliveryBoyId(5);
		  deliveryBoy.setDeliveryBoyName("Paresh");
		  deliveryBoy.setDeliveryBoyPhoneNumber("9586321475");
		  deliveryBoy.setDeliveryBoyIdentifier("db45");
		  deliveryBoy.setDeliveryBoyEmail("paresh66@gmail.com");
		  String jsonInput=this.converttoJson(deliveryBoy);
		  Mockito.when(foodDeliveryBoyService.updateDeliveryBoy(deliveryBoy, 5)).thenReturn(deliveryBoy);
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,5)
                  .accept(MediaType.APPLICATION_JSON)
                  .content(jsonInput)
                  .contentType(MediaType.APPLICATION_JSON))
                  .andReturn();
		  assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		  		 
	 }
	 
	 @Test
	 void test5_FindAllDeliveryBoys() throws Exception {
		 
		 String uri="/api/v2/deliveryBoy/all";
		  DeliveryBoy deliveryBoy1=new DeliveryBoy();
		  deliveryBoy1.setDeliveryBoyId(5);
		  deliveryBoy1.setDeliveryBoyName("Paresh");
		  deliveryBoy1.setDeliveryBoyPhoneNumber("9586321475");
		  deliveryBoy1.setDeliveryBoyIdentifier("db45");
		  deliveryBoy1.setDeliveryBoyEmail("paresh66@gmail.com");
		  
		  DeliveryBoy deliveryBoy2=new DeliveryBoy();
		  deliveryBoy2.setDeliveryBoyId(6);
		  deliveryBoy2.setDeliveryBoyName("Pritam");
		  deliveryBoy2.setDeliveryBoyPhoneNumber("8523641759");
		  deliveryBoy2.setDeliveryBoyIdentifier("db34");
		  deliveryBoy2.setDeliveryBoyEmail("pritam67@gmail.com");
		  
		  
		  List<DeliveryBoy> deliveryBoyList=new ArrayList<DeliveryBoy>();
		  deliveryBoyList.add(deliveryBoy1);
		  deliveryBoyList.add(deliveryBoy2);		  
		  String jsonInput=this.converttoJson(deliveryBoyList);
		  Mockito.when(foodDeliveryBoyService.findAllDeliveryBoys()).thenReturn(deliveryBoyList);
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
                  .accept(MediaType.APPLICATION_JSON)
                  .content(jsonInput)
                  .contentType(MediaType.APPLICATION_JSON))
                  .andReturn();
                
        assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
		  
	 }

	 @Test
	 void test6_FindDeliveryBoyById() throws Exception {
		 String uri="/api/v2/deliveryBoy/{id}";
		 DeliveryBoy deliveryBoy=new DeliveryBoy();		 
		  deliveryBoy.setDeliveryBoyId(50);
		  deliveryBoy.setDeliveryBoyName("Paresh");
		  deliveryBoy.setDeliveryBoyPhoneNumber("9586321475");
		  deliveryBoy.setDeliveryBoyIdentifier("db45");
		  deliveryBoy.setDeliveryBoyEmail("paresh66@gmail.com");
		  String jsonInput=this.converttoJson(deliveryBoy);
		  
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri,50)
                  .accept(MediaType.APPLICATION_JSON)
                  .content(jsonInput)
                  .contentType(MediaType.APPLICATION_JSON))
                  .andReturn();
		 
		 assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
				 
	 }
	 
	        private String converttoJson(Object deliveryBoy) throws JsonProcessingException {
			ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(deliveryBoy);
		}
		

}
