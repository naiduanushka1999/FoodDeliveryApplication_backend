package com.cg.fda.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.service.spi.ServiceException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

import com.cg.fda.service.DeliveryBoyService;
import com.cg.fda.service.FoodDeliveryBoyServiceImpl;
import com.cg.fda.domain.DeliveryBoy;

/**
 * A rest controller which handles all the URL request given by the application for the various services.
 * @author anushka
 *
 */
@RestController
@RequestMapping("/api/v2")

@CrossOrigin
public class DeliveryBoyController {
	private static final Logger LOGGER = LogManager.getLogger(DeliveryBoyController.class);
	@Autowired
	private DeliveryBoyService deliveryBoyService;
	
	@Autowired
	private FoodDeliveryBoyServiceImpl  foodDeliveryBoyServiceImpl;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorservice;
	
	@PostMapping("")
	public ResponseEntity<?> createNewDeliveryBoy(@Valid @RequestBody DeliveryBoy deliveryBoy, BindingResult result){
		LOGGER.info("Entered inside post method in controller");
		ResponseEntity<?> errorMap = mapValidationErrorservice.mapValidationService(result);
		if(errorMap!=null) return errorMap;
		DeliveryBoy newDeliveryBoy = deliveryBoyService.saveOrUpdate(deliveryBoy);
		return new ResponseEntity<DeliveryBoy>(newDeliveryBoy,HttpStatus.CREATED);
	}
	
	/**
     * this method shows the delivery boy details withrespective to id
     * @param id of delivery boy
     * @return delivery boy object 
     * @throws DeliveryBoyException 
     */
	@GetMapping("/deliveryBoy/{id}")
	public ResponseEntity<?> findDeliveryBoyById(@PathVariable int id){
		LOGGER.info("Entered inside get method in controller");
		return new ResponseEntity<DeliveryBoy>(foodDeliveryBoyServiceImpl.listDeliveryBoyById(id),HttpStatus.OK);
	}
	/**
	 * this method returns list of the delivery boy details
	 * @return list of delivery boy
	 */
	@GetMapping("/deliveryBoy/all")
	public Iterable<DeliveryBoy> findAllDeliveryBoys(){
		LOGGER.info("Entered inside get all method in controller");
		return foodDeliveryBoyServiceImpl.findAllDeliveryBoys();
	}
	/**
	 * this method deletes delivery boy from data base
	 * @param id of delivery boy
	 * @return string 
	 */

	@DeleteMapping("/deliveryBoy/{id}")
	public ResponseEntity<?> deleteDeliveryBoyById(@PathVariable int id){
		LOGGER.info("Entered inside delete method in controller");
		foodDeliveryBoyServiceImpl.deleteDeliveryBoyById(id);
		return new ResponseEntity<String> ("Delivery Boy with Id : "+id+" Deleted!",HttpStatus.OK);
	}
	/**
	 * this method updates delivery boy in to data base
	 * @param id of delivery boy
	 * @param delivery object to be updated 
	 * @return string
	 *  
	 */
	@PutMapping("/deliveryBoy/{id}")
	public ResponseEntity<DeliveryBoy> updateDeliveryBoy(@RequestBody DeliveryBoy deliveryBoy ,@PathVariable int id) {
		LOGGER.info("Entered inside update method in controller");
		DeliveryBoy updatedDeliveryBoy=foodDeliveryBoyServiceImpl.updateDeliveryBoy(deliveryBoy, id);
		return new ResponseEntity<DeliveryBoy>(updatedDeliveryBoy,HttpStatus.OK);
		
	}
	
	
}

	
	
	
	


