package com.cg.fda.web;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fda.domain.Payment;
import com.cg.fda.exception.PaymentIdNotFoundException;
import com.cg.fda.service.IPaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value="Operations on Payment")
@RequestMapping("/api/v2")
public class PaymentController {
	private static final Logger LOGGER = LogManager.getLogger(PaymentController.class);
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	/**
	 * method to add payment
	 * @param payment
	 * @param result
	 * @return either errormap or payment
	 */
	@ApiOperation(value="Making a Payment")
	@PostMapping("/Payment")
	public ResponseEntity<?> addPayment(@Valid @RequestBody Payment payment,BindingResult result){
		LOGGER.info("Entered inside add method of payment controller");
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationService(result);
		if(errorMap!=null) {
			return errorMap;
		}
		Payment newPayment=paymentService.addPayment(payment);
		return new ResponseEntity<>(newPayment,HttpStatus.CREATED);
		
	}
	
	@ApiOperation(value="Deleting a Payment")
	@DeleteMapping("/Payment/{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable int paymentId) throws PaymentIdNotFoundException{
		LOGGER.info("Entered inside delete method of payment controller");
		paymentService.deletePayment(paymentId);
		return new ResponseEntity<>("Payment with Id : "+paymentId+" id deleted.....", HttpStatus.OK);
		
	}
	@ApiOperation(value="Getting a Payment Details")
	@GetMapping("/Payment/{paymentId}")
	public ResponseEntity<Payment> viewPaymentById(@PathVariable int paymentId) throws PaymentIdNotFoundException{
		LOGGER.info("Entered inside get method of payment controller");
		return new ResponseEntity<>(paymentService.viewPaymentDetailsById(paymentId),HttpStatus.OK);
		
	}
	
	@ApiOperation(value="getting all Payments")
	@GetMapping("/allPayments")
	public Iterable<Payment> getAllPayments(){
		LOGGER.info("Entered inside get all method of payment controller");
		return paymentService.getAllPayments();
	}

}
