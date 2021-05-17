package com.cg.fda.exception;

/**
 * A class for creating the response of various delivery boy related exception.
 * @author amansoni
 *
 */
public class DeliveryBoyExceptionResponse {
	
	String responseMessage;
	
	/**
	 * Create the instance of DeliveryBoyExceptionResponse with given response message.
	 * @param responseMessage
	 */
	public DeliveryBoyExceptionResponse(String responseMessage) {
		super();
		this.responseMessage = responseMessage;
	}
	
	/**
	 * GETTERS AND SETTERS.
	 *
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

}
