package com.example.paystockbackend.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class ProductDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String productName;

	private String productCode;
	private int productQuantity;
	private String productPrice;

	private Long renterCode;

	public String getProductName() {
		return productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public String getProductPrice() {
		return productPrice;
	}

	// Setters
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public Long getRenterCode() {
		return renterCode;
	}

	public void setRenterCode(Long renterCode) {
		this.renterCode = renterCode;
	}

}