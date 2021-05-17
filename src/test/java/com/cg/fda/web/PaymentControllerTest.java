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

import com.cg.fda.domain.Payment;
import com.cg.fda.service.IPaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	  @MockBean
	  private IPaymentService paymentService;
	  
	  @Test
	  void testAddPayment() throws Exception{
		  String uri="/api/v2/Payment";
		  Payment payment=new Payment();
		 
			payment.setId(1);
			payment.setPaymentMode("creditCard");
			payment.setCardNumber("12345678");
			payment.setCardHolderName("chatu");
			payment.setExpiryDate("12/12/2020");
			payment.setCvv(198);
			payment.setOtp(9033);
			String jsonInput=this.converttoJson(payment);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(uri)
	                  .accept(MediaType.APPLICATION_JSON)
	                  .content(jsonInput)
	                  .contentType(MediaType.APPLICATION_JSON))
	                  .andReturn();
			assertEquals(HttpStatus.CREATED.value(),mvcResult.getResponse().getStatus());
		     
		 
	  }
	  @Test
	  void testDeletePayment() throws Exception {
		  String uri="/api/v2/Payment/{paymentId}";
		  Payment payment=new Payment();
		  payment.setId(10);
			payment.setPaymentMode("DebitCard");
			payment.setCardNumber("120000678");
			payment.setCardHolderName("kaavi");
			payment.setExpiryDate("12/12/2023");
			payment.setCvv(198);
			payment.setOtp(9033);
			int paymentId=payment.getId();
			String jsonInput=this.converttoJson(payment);
		Mockito.when(paymentService.viewPaymentDetailsById(paymentId)).thenReturn( payment);
			  Mockito.when(paymentService.deletePayment(paymentId)).thenReturn(payment);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(uri,10)
	                  .accept(MediaType.APPLICATION_JSON)
	                  .content(jsonInput)
	                  .contentType(MediaType.APPLICATION_JSON))
	                  .andReturn();
			assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
		     
	  }
	  @Test
	  void testViewPayment() throws Exception {
		  String uri="/api/v2/Payment/{paymentId}";
		  Payment payment=new Payment();
		  payment.setId(10);
			payment.setPaymentMode("giftCard");
			payment.setCardNumber("10000342");
			payment.setCardHolderName("poori");
			payment.setExpiryDate("12/01/2021");
			payment.setCvv(033);
			payment.setOtp(8921);
			String jsonInput=this.converttoJson(payment);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri,10)
	                  .accept(MediaType.APPLICATION_JSON)
	                  .content(jsonInput)
	                  .contentType(MediaType.APPLICATION_JSON))
	                  .andReturn();
			assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
		  
	  }
	  @Test
		 void testViewAllPayments() throws Exception {
			 
			 String uri="/api/v2/allPayments";
			 Payment payment=new Payment();
				payment.setId(2);
				payment.setPaymentMode("giftCard");
				payment.setCardNumber("12212348");
				payment.setCardHolderName("jayasree");
				payment.setExpiryDate("09/03/2022");
				payment.setCvv(321);
				payment.setOtp(1234);
				Payment payment2=new Payment();
				payment2.setId(3);
				payment2.setPaymentMode("promo code");
				payment2.setCardNumber("12212348");
				payment2.setCardHolderName("jayasree");
				payment2.setExpiryDate("09/03/2022");
				payment2.setCvv(321);
				payment2.setOtp(1234);
				List<Payment> paymentList=new ArrayList<Payment>();
				paymentList.add(payment2);
				paymentList.add(payment);
			  String jsonInput=this.converttoJson(paymentList);
			  Mockito.when(paymentService.getAllPayments()).thenReturn(paymentList);
			  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
	                  .accept(MediaType.APPLICATION_JSON)
	                  .content(jsonInput)
	                  .contentType(MediaType.APPLICATION_JSON))
	                  .andReturn();
	                
	        assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
			  
		 }

	private String converttoJson(Object payment) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(payment);
		
	}

}
