package com.cg.fda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PaymentIdNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PaymentIdNotFoundException() {
		super();
	}

	public PaymentIdNotFoundException(String msg) {
		super(msg);
	}

}
