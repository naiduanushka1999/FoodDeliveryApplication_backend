package com.cg.fda.service;

import com.cg.fda.domain.Payment;
import com.cg.fda.exception.PaymentIdNotFoundException;

public interface IPaymentService {
	/**
	 * This method will add the payment
	 * @param payment
	 * @return payment
	 */
	public Payment addPayment(Payment payment);
	/**
	 * this method will delete the payment
	 * @param paymentId
	 */
	public Payment deletePayment(int paymentId) throws PaymentIdNotFoundException;
	/**
	 * this method will provide payment details
	 * @param paymentId
	 * @return
	 * @throws PaymentIdNotFoundException
	 */
	
	public Payment viewPaymentDetailsById(int paymentId) throws PaymentIdNotFoundException;
	public Iterable<Payment> getAllPayments();

}
