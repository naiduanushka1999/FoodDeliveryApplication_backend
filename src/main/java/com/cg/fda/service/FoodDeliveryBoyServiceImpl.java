package com.cg.fda.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fda.domain.DeliveryBoy;
import com.cg.fda.exception.DeliveryBoyException;
import com.cg.fda.repository.DeliveryBoyRepository;


@Service
public class FoodDeliveryBoyServiceImpl implements FoodDeliveryBoyService {
	private static final Logger logger = LoggerFactory.getLogger(FoodDeliveryBoyServiceImpl.class);
	
	@Autowired
	private DeliveryBoyRepository deliveryBoyRepository;
	
	/**
	 * this method shows delivery boy which has given id
	 * @param Id of delivery Boy to be shown
	 * @return deliveryBoy
	 * @throws DeliveryBoyException
	 * */
	public DeliveryBoy listDeliveryBoyById(int id) {
		
		DeliveryBoy deliveryBoy = deliveryBoyRepository.findByDeliveryBoyId(id);
		if (deliveryBoy == null) {
			logger.error("Delivery Boy Id " + id+ " not available");
			throw new DeliveryBoyException("Supplier Id " + id + " not available");
		}
		return deliveryBoy;

	}
	/**
     * this method shows all delivery boy Details present in the database
     * @return list of delivery boys
     */
	public Iterable<DeliveryBoy> findAllDeliveryBoys(){
		return deliveryBoyRepository.findAll();
	}
	/**
	 * this method deletes a delivery boy details from database
	 * @param Id of delivery boy to be deleted
	 * @throws DeliveryBoyException
	 */
	public boolean deleteDeliveryBoyById(int deliveryBoyId) {
		DeliveryBoy deliveryBoy=listDeliveryBoyById(deliveryBoyId);
		if(deliveryBoy==null) {
			logger.error("Delivery Boy Id " + deliveryBoyId + " not available");
			throw new DeliveryBoyException("Delivery Boy Id" + deliveryBoyId + " not available");
		}
		deliveryBoyRepository.delete(deliveryBoy);
		return true;
	}
	/**
	 * this method updates a delivery boy to database		
	 * @param delivery boy,id to be updated
	 * @return delivery boy
	 * @throws DeliveryBoyException 
	 */
	 public DeliveryBoy updateDeliveryBoy(DeliveryBoy deliveryBoy, int id) { 
		 DeliveryBoy fetchedDeliveryBoy=deliveryBoyRepository.findByDeliveryBoyId(id);
		  if(fetchedDeliveryBoy!=null) {
		 fetchedDeliveryBoy.setDeliveryBoyName(deliveryBoy.getDeliveryBoyName());
		 fetchedDeliveryBoy.setDeliveryBoyEmail(deliveryBoy.getDeliveryBoyEmail());
		 fetchedDeliveryBoy.setDeliveryBoyPhoneNumber(deliveryBoy.getDeliveryBoyPhoneNumber());
		  return deliveryBoyRepository.save(fetchedDeliveryBoy);
		  }
		  else {
			  logger.error("Unable to find Delivery Boy for given id ");
				throw new DeliveryBoyException("Unable to find delivery boy for given id ");
			}
		  }

}

