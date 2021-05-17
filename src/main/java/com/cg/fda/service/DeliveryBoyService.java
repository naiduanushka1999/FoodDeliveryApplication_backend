package com.cg.fda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fda.domain.DeliveryBoy;
import com.cg.fda.exception.DeliveryBoyException;
import com.cg.fda.repository.DeliveryBoyRepository;

/**
 * Class which provide all the services related to delivery boy.
 * @author amansoni
 *
 */
@Service
public class DeliveryBoyService {
	@Autowired
	DeliveryBoyRepository deliveryBoyRepository;
	
	/**
	 * Stores the delivery boy related data in the database.
	 * @param deliveryBoy
	 * @return the saved instance of the delivery boy if successfully saved else throw suitable exception.
	 */
	public DeliveryBoy saveOrUpdate(DeliveryBoy deliveryBoy) {
		try {
			deliveryBoy.setDeliveryBoyIdentifier(deliveryBoy.getDeliveryBoyIdentifier().toUpperCase());
			return deliveryBoyRepository.save(deliveryBoy);
		}
		catch(Exception e) {
			throw new DeliveryBoyException("Delivery boy with identifier " + deliveryBoy.getDeliveryBoyIdentifier() + " already available");
		}
	}
	/**
	 * Deletes the delivery boy related data in the database.
	 * @param deliveryBoyIdentifier
	 * @return boolean value true if deleted successfully else false.
	 */

	
}
