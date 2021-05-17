package com.cg.fda.service;

import com.cg.fda.domain.DeliveryBoy;

public interface FoodDeliveryBoyService {
	/**
	 * This method will list delivery boys by id
	 * @param id
	 * @return delivery boy
	 */
	public DeliveryBoy listDeliveryBoyById(int id) ;
	/**
	 * This method will list all delivery boys 
	 * @return delivery boy list
	 */
	public Iterable<DeliveryBoy> findAllDeliveryBoys();
	/**
	 * This method will delete delivery boy by id
	 * @param id
	 * @return boolean value
	 */
	public boolean deleteDeliveryBoyById(int id);
	
	/**
	 * This method will update delivery boy by id
	 * @param deliveryboy,id
	 * @return delivery boy
	 */
	public DeliveryBoy updateDeliveryBoy(DeliveryBoy deliveryboy, int id);

}
