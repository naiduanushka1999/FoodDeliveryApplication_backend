package com.cg.fda.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Delivery boy POJO to carry all data related to delivery boy.
 * @author anushka
 *
 */
@Entity
public class DeliveryBoy {
	/**
	 * Variable to store id of delivery boy which is auto generated.
	 */
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int deliveryBoyId;
	
	/**
	 * Variable to kept the delivery boy identifier which is unique and it's size must be between 4 to 5 characters.
	 */
	@Column(unique = true)
	@Size(min=4,max=5,message = " It can't be blank and size must be between 4 to 5 characters")
	@NotBlank(message = "Delivery boy identifier can't be blank")
	private String deliveryBoyIdentifier;
	
	/**
	 * Variable to store the name of the delivery boy.
	 */
	//@NotBlank(message="*Delivery boy name is required")
	private String deliveryBoyName;
	
	/**
	 * Variable to store the phone number of the delivery boy.
	 */
	@Pattern(regexp="([987][0-9]{9})")
	@NotBlank(message = "Delivery boy phone number can't be blank")
	private String deliveryBoyPhoneNumber;
	
	/**
	 * Variable to store the email address of delivery boy.
	 */
	@NotBlank(message = "Delivery boy email can't be blank")
	@Pattern(regexp = "[a-zA-Z0-9+_.-]{5,15}[@][a-zA-Z]{1,8}[.][a-z]{2,5}",message = "Email should start with alphanumeric characters contain one @, one (.) and (com) in last")
	private String deliveryBoyEmail;
	
	
	/**
	 * Default constructor.
	 */
	public DeliveryBoy() {
		
	}


	/**
	 * A parameterized constructor to create a new delivery boy.
	 * @param deliveryBoyId
	 * @param deliveryBoyIdentifier
	 * @param deliveryBoyName
	 * @param deliveryBoyPhoneNumber
	 * @param deliveryBoyEmail
	 */
	public DeliveryBoy (int deliveryBoyId,@NotBlank(message = "Delivery boy identifier can't be blank") @Size(min = 4, max = 5, message = "Size must be between 4 to 5 characters") String deliveryBoyIdentifier,
			@NotBlank(message = "Delivery boy name is required") String deliveryBoyName,
			@NotBlank(message = "Delivery boy phone number can't be blank") String deliveryBoyPhoneNumber,
			@NotBlank(message = "Delivery boy email can't be blank") String deliveryBoyEmail) {
		super();
		this.deliveryBoyId =deliveryBoyId;
		this.deliveryBoyIdentifier = deliveryBoyIdentifier;
		this.deliveryBoyName = deliveryBoyName;
		this.deliveryBoyPhoneNumber = deliveryBoyPhoneNumber;
		this.deliveryBoyEmail = deliveryBoyEmail;
	}
	
    /**
     * GETTERS AND SETTERS.
     * 
     */
	
	public int getDeliveryBoyId() {
		return deliveryBoyId;
	}


	public void setDeliveryBoyId(int deliveryBoyId) {
		this.deliveryBoyId = deliveryBoyId;
	}


	
	public String getDeliveryBoyIdentifier() {
		return deliveryBoyIdentifier;
	}



	public void setDeliveryBoyIdentifier(String deliveryBoyIdentifier) {
		this.deliveryBoyIdentifier = deliveryBoyIdentifier;
	}



	public String getDeliveryBoyName() {
		return deliveryBoyName;
	}



	public void setDeliveryBoyName(String deliveryBoyName) {
		this.deliveryBoyName = deliveryBoyName;
	}



	public String getDeliveryBoyPhoneNumber() {
		return deliveryBoyPhoneNumber;
	}



	public void setDeliveryBoyPhoneNumber(String deliveryBoyPhoneNumber) {
		this.deliveryBoyPhoneNumber = deliveryBoyPhoneNumber;
	}



	public String getDeliveryBoyEmail() {
		return deliveryBoyEmail;
	}



	public void setDeliveryBoyEmail(String deliveryBoyEmail) {
		this.deliveryBoyEmail = deliveryBoyEmail;
	}
	
}
