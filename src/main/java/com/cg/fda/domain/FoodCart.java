package com.cg.fda.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;




/**
 * @author supriya
 *
 */
@Entity
public class FoodCart {
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id	
	private int foodCartId; 
	
	@NotBlank(message="Name should not be null.")
	//@ApiModelProperty(required=true)
	private String foodItemName;	
	
	@NotBlank(message="There will be always some quantity.")
	//@ApiModelProperty(required=true)
	private String foodItemQuantity;	
	
	@NotNull(message="There won't be a food item will zero price. ")
	private int foodItemPrice;

	public FoodCart() {
		super();
		
	}

	public FoodCart(int foodCartId, @NotBlank(message = "Name should not be null.") String foodItemName,
			@NotBlank(message = "There will be always some quantity.") String foodItemQuantity,
			@NotNull(message = "There won't be a food item will zero price. ") int foodItemPrice) {
		super();
		this.foodCartId = foodCartId;
		this.foodItemName = foodItemName;
		this.foodItemQuantity = foodItemQuantity;
		this.foodItemPrice = foodItemPrice;
	}

	public int getFoodCartId() {
		return foodCartId;
	}

	public void setFoodCartId(int foodCartId) {
		this.foodCartId = foodCartId;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public String getFoodItemQuantity() {
		return foodItemQuantity;
	}

	public void setFoodItemQuantity(String foodItemQuantity) {
		this.foodItemQuantity = foodItemQuantity;
	}

	public int getFoodItemPrice() {
		return foodItemPrice;
	}

	public void setFoodItemPrice(int foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}

	@Override
	public String toString() {
		return "FoodCart [foodCartId=" + foodCartId + ", foodItemName=" + foodItemName + ", foodItemQuantity="
				+ foodItemQuantity + ", foodItemPrice=" + foodItemPrice + "]";
	}

	
}