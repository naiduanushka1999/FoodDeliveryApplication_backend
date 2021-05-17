package com.cg.fda.exception;

/**
 * Class for exception related to delivery boy.
 * @author amansoni
 *
 */
public class DeliveryBoyException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create an instance of delivery boy exception.
	 */
	public DeliveryBoyException() {
		super();
	}
	
	/**
	 * Create an instance of DeliveryBoyException with given error message.
	 * @param errorMessage
	 */
	public DeliveryBoyException(String errorMessage) {
		super(errorMessage);
	}
	

}
