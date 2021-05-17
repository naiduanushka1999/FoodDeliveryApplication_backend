package com.cg.fda.repository;
import com.cg.fda.domain.Payment;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentRespositoryTest {
	@Autowired
	private IPaymentRepository paymentRepository;
	@Test
	void testFindByProductId() {
		Payment payment=new Payment();
		//payment.setId(1);
		payment.setPaymentMode("creditCard");
		payment.setCardNumber("12345678");
		payment.setCardHolderName("chatu");
		payment.setExpiryDate("12/12/2020");
		payment.setCvv(198);
		payment.setOtp(9033);
		paymentRepository.save(payment);
		int paymentId=payment.getId();
		assertNotNull(paymentRepository.findByPaymentId(paymentId));
	}

}
