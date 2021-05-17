package com.cg.fda.service;

import java.util.List;

import com.cg.fda.exception.IDNotFoundException;
import com.cg.fda.domain.RestaurantDetails;

public interface AdminService {
	
	RestaurantDetails createRestaurantDetails(RestaurantDetails restaurantDetails);
	RestaurantDetails updateRestaurantDetailsById(Integer restaurantDetailsId, RestaurantDetails restaurantDetailsDetails) throws IDNotFoundException;
	boolean deleteRestaurantDetailsById(Integer restaurantDetailsId) throws IDNotFoundException;
	RestaurantDetails getRestaurantDetailsById(Integer restaurantDetailsId, RestaurantDetails restaurantDetailsDetails) throws IDNotFoundException;
	List<RestaurantDetails> getAllRestaurantDetails();
	
	

}