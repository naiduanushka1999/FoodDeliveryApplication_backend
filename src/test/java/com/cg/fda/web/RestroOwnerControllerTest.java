package com.cg.fda.web;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.fda.domain.RestroOwner;
import com.cg.fda.service.RestroOwnerRegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestroOwnerControllerTest {

	
	    @Autowired
	    private MockMvc mockMvc;

	 

	    @MockBean
	    private RestroOwnerRegistrationService restroOwnerRegistrationService;

	    @Test
	     void testCreateRestroOwner() throws Exception{
	        String URI = "/api/v2/createRestroOwner";
	        RestroOwner restroOwner = new  RestroOwner();
	         restroOwner.setOwnerId("Anushka@12");
			 restroOwner.setEmail("anushka14@gmail.com");
			 restroOwner.setPhoneNo("8736524356");
			 restroOwner.setPassword("Anushka@1234");
	        String jsonInput = this.converttoJson(restroOwner);

	     
	           this.mockMvc.perform(MockMvcRequestBuilders.post(URI)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(jsonInput)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	       assertThat(restroOwnerRegistrationService.createRestroOwner(restroOwner));
	             
	 


	    }
	    
	  
	    
	   
	    /**
	     * Convert Object into Json String by using Jackson ObjectMapper
	     * @param ticket
	     * @return
	     * @throws JsonProcessingException
	     */
	    private String converttoJson(Object restroOwner) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(restroOwner);
	    }
	    
}
