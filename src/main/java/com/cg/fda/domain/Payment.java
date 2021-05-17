package com.cg.fda.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes="auto generated payment id")
	private int paymentId;
	@NotBlank(message="Payment mode should be selected")
	@ApiModelProperty(notes="Mode of Payment should be selected")
	private String paymentMode;
	@NotBlank(message="Card number should be given")
	@ApiModelProperty(notes="Card Number should be given")
	private String cardNumber;
	@NotBlank(message="Card holder name is required")
	@ApiModelProperty(notes="Card Holder Name should be given")
	private String cardHolderName;
	@NotBlank(message="expiry date is must")
	@ApiModelProperty(notes="Expiry Date of card")
	private String expiryDate;
	@NotNull(message="give the cvv")
	@ApiModelProperty(notes="Enter the CVV of the card")
	private int cvv;
	@NotNull(message="Property should not be null")
	@ApiModelProperty(notes="OTP should be given")
	private int otp;
	/**
	 * return the payment id
	 * @return
	 */
	public int getId() {
		return paymentId;
	}
	/**
	 * set the payment
	 * @param paymentId
	 */
	public void setId(int paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * get the payment mode
	 * @return
	 */
	public String getPaymentMode() {
		return paymentMode;
	}
	/**
	 * set the payment mode
	 * @param paymentMode
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	/**
	 * get the card number
	 * @return
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * set the card number
	 * @param cardNumber
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * get the card holder name
	 * @return
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}
	/**
	 * set the card holder name
	 * @param cardHolderName
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	/**
	 * get the Expiry date
	 * @return
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * set the expiry date
	 * @param expiryDate
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	/**
	 * get the cvv number
	 * @return
	 */
	public int getCvv() {
		return cvv;
	}
	/**
	 * set the cvv number
	 * @param cvv
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	/**
	 * get the otp number
	 * @return
	 */
	public int getOtp() {
		return otp;
	}
	/**
	 * set the otp number
	 * @param otp
	 */
	public void setOtp(int otp) {
		this.otp = otp;
	}

}
