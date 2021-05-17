package com.cg.fda.service;

 

import java.util.List;

 

import javax.transaction.Transactional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.cg.fda.exception.IDNotFoundException;
import com.cg.fda.domain.RestaurantDetails;
import com.cg.fda.repository.RestaurantDetailsRepository;

 

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

 

    @Autowired
    private RestaurantDetailsRepository restaurantDetailsRepository;

 

        public RestaurantDetails createRestaurantDetails(@RequestBody RestaurantDetails restaurantDetails) {
        return restaurantDetailsRepository.save(restaurantDetails);
    }
    public RestaurantDetails updateRestaurantDetailsById(@PathVariable Integer restaurantDetailsId,
            @RequestBody RestaurantDetails restaurantDetails) throws IDNotFoundException{
        RestaurantDetails restaurantDetailsFound = restaurantDetailsRepository.findById(restaurantDetailsId)
                    .orElseThrow(() -> new IDNotFoundException(
                            "RestaurantDetailsIdentifier : " + restaurantDetailsId + " not available!!!"));
        
        restaurantDetailsFound.setRestaurantDetailsId(restaurantDetails.getRestaurantDetailsId());
        restaurantDetailsFound.setRestaurantOwnerName(restaurantDetails.getRestaurantOwnerName());
        restaurantDetailsFound.setRestaurantName(restaurantDetails.getRestaurantName());
        restaurantDetailsFound.setRestaurantPhone(restaurantDetails.getRestaurantPhone());
        restaurantDetailsFound.setRestaurantAddress(restaurantDetails.getRestaurantAddress());
        restaurantDetailsFound.setRestaurantFoodItems(restaurantDetails.getRestaurantFoodItems());
        restaurantDetailsFound.setFoodItemsPrice(restaurantDetails.getFoodItemsPrice());
        restaurantDetailsFound.setDeliveryBoyId(restaurantDetails.getDeliveryBoyId());
        restaurantDetailsFound.setDeliveryBoyName(restaurantDetails.getDeliveryBoyName());
        restaurantDetailsFound.setDeliveryBoyPhone(restaurantDetails.getDeliveryBoyPhone());
        return restaurantDetailsRepository.save(restaurantDetailsFound);
    }

 

    public boolean deleteRestaurantDetailsById(@PathVariable Integer restaurantDetailsId) throws IDNotFoundException{
        RestaurantDetails restaurantDetails = restaurantDetailsRepository.findById(restaurantDetailsId)
                    .orElseThrow(() -> new IDNotFoundException(
                            "RestaurantDetailsIdentifier : " + restaurantDetailsId + " not available!!!"));
        restaurantDetailsRepository.delete(restaurantDetails);
        return true;
    }

 

    public List<RestaurantDetails> getAllRestaurantDetails() {
        return (List<RestaurantDetails>) restaurantDetailsRepository.findAll();
    }
    @Override
    public RestaurantDetails getRestaurantDetailsById(Integer restaurantDetailsId,
            RestaurantDetails restaurantDetailsDetails) throws IDNotFoundException {
        
        return null;
    }

 

}