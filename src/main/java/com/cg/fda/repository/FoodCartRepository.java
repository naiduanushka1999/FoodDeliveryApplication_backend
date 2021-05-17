package com.cg.fda.repository;

/*
 * Interface CategoryRepository for performing crud operations.
 * @author Supriya
 */
import org.springframework.data.repository.CrudRepository;
import com.cg.fda.domain.FoodCart;


public interface FoodCartRepository extends CrudRepository<FoodCart,Integer> {
    
	 FoodCart findByFoodCartId(int foodCartId);

	void deleteById(int foodCartId);

}
