package com.cg.fda.web;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.cg.fda.domain.RestaurantDetails;
import com.cg.fda.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AdminController.class)
public class AdminControllerTest {


    @Autowired
    MockMvc mockMvc;

     @MockBean
    AdminService adminService;

    @Test
    public void testCreateRestaurantDetails() throws Exception {


        RestaurantDetails restaurantdetails = new RestaurantDetails(106, "Janani", "janani", "8512518301", "Mysore", "pizza", "100", "01", "Amrutha", "8521479637");
        String jsonInput = this.converttoJson(restaurantdetails);

        Mockito.when(adminService.createRestaurantDetails(Mockito.any(RestaurantDetails.class))).thenReturn(restaurantdetails);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/RestaurantDetail")
                .accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }

 

 

 


    @Test
    public void testUpdateRestaurantDetails() throws Exception {
        RestaurantDetails restaurantdetails = new RestaurantDetails(106, "Janani", "janani", "8512518301", "Mysore", "pizza", "100", "01", "Amrutha", "8521479637");
        String jsonInput = this.converttoJson(restaurantdetails);


        Mockito.when(adminService.updateRestaurantDetailsById(Mockito.any(), Mockito.any(RestaurantDetails.class)))
                .thenReturn(restaurantdetails);
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.put("/api/v2/RestaurantDetail/{id}", 106)
                        .accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }
 
 
    private String converttoJson(Object restaurantdetails) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(restaurantdetails);
    }
}
