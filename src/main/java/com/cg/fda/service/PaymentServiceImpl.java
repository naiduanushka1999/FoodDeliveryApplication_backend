package com.cg.fda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fda.domain.Payment;
import com.cg.fda.exception.PaymentIdNotFoundException;
import com.cg.fda.repository.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService{
	@Autowired
	private IPaymentRepository paymentRepository;

	/**
	 * overriden the add payment method
	 * 
	 */
	public Payment addPayment(Payment payment) {
		
		return paymentRepository.save(payment);
	}

	/**
	 * overriden the delete payment method
	 */

	public Payment deletePayment(int paymentId) throws PaymentIdNotFoundException{
		Payment payment=paymentRepository.findByPaymentId(paymentId);
		paymentRepository.deleteById(paymentId);
		return payment;
			}

	/**
	 * overriden the view payment details by id
	 */
	public Payment viewPaymentDetailsById(int paymentId)throws PaymentIdNotFoundException {
		return paymentRepository.findByPaymentId(paymentId);
		
	}

	@Override
	public Iterable<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}


}
