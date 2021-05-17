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
import com.cg.fda.domain.Registration;
import com.cg.fda.service.RegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

 

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerTest {

 

    @Autowired
    private MockMvc mockMvc;

 

    @MockBean
    private RegistrationService service;

 


    @Test
     void testCreateUserData() throws Exception{
        String URI = "/userRegistration/createUserDetails";
        Registration User = new  Registration();
        User.setUserId("Aswitha25");
        User.setPassword("Aswitha@9");
        User.setEmailId("abcde@gmail.com");
        User.setContactNo("8999999900");
        String jsonInput = this.converttoJson(User);

 

      
        this.mockMvc.perform(MockMvcRequestBuilders.post(URI)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonInput)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertThat(service.createdata(User));

 


    }
    
  
    
   
    /**
     * Convert Object into Json String by using Jackson ObjectMapper
     * @param ticket
     * @return
     * @throws JsonProcessingException
     */
    private String converttoJson(Object User) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(User);
    }
    
    
}