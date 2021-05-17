package com.cg.fda.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.fda.domain.Payment;
import com.cg.fda.exception.PaymentIdNotFoundException;
import com.cg.fda.repository.IPaymentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTest {
	@Autowired
	private IPaymentService paymentService;
	@MockBean
	private IPaymentRepository paymentRepository;
	@Test
	void addPayment() {
		Payment payment=new Payment();
		payment.setId(1);
		payment.setPaymentMode("creditCard");
		payment.setCardNumber("12345678");
		payment.setCardHolderName("chatu");
		payment.setExpiryDate("12/12/2020");
		payment.setCvv(198);
		payment.setOtp(9033);
		Mockito.when(paymentRepository.save(payment)).thenReturn(payment);
		assertThat(paymentService.addPayment(payment)).isEqualTo(payment);
			
		}
	@Test
	void deletePaymentTest() throws PaymentIdNotFoundException {
		Payment payment=new Payment();
		payment.setId(4);
		payment.setPaymentMode("debitCard");
		payment.setCardNumber("12346528");
		payment.setCardHolderName("kavya");
		payment.setExpiryDate("12/07/2022");
		payment.setCvv(121);
		payment.setOtp(0033);
		int paymentId=payment.getId();
		Mockito.when(paymentRepository.findByPaymentId(paymentId)).thenReturn(payment);
			assertThat(paymentService.deletePayment(paymentId)).isEqualTo(payment);    
        			 
	}	
	@Test
	void viewPaymentById() throws PaymentIdNotFoundException {
		Payment payment=new Payment();
		payment.setId(2);
		payment.setPaymentMode("giftCard");
		payment.setCardNumber("12212348");
		payment.setCardHolderName("jayasree");
		payment.setExpiryDate("09/03/2022");
		payment.setCvv(321);
		payment.setOtp(1234);
		int paymentId=payment.getId();
		Mockito.when(paymentRepository.findByPaymentId(paymentId)).thenReturn(payment);
		assertThat(paymentService.viewPaymentDetailsById(paymentId)).isEqualTo(payment);
		
	}
	@Test
	void getAllPaymentsTest () {
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
		Mockito.when(paymentRepository.findAll()).thenReturn(paymentList);
		assertThat(paymentService.getAllPayments()).isEqualTo(paymentList);
		
	}
}
