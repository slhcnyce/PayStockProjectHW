package com.example.paystockbackend.payment;

import java.util.ArrayList;
import java.util.List;

import com.example.paystockbackend.product.ProductDetail;

public class PaymentDto {

    private Long renterCode;

    private String date;
    private Double price;

    private List<ProductDetail> productDetails = new ArrayList<>();

    // Getter for renterCode
    public Long getRenterCode() {
        return renterCode;
    }

    // Setter for renterCode
    public void setRenterCode(Long renterCode) {
        this.renterCode = renterCode;
    }

    // Getter for date
    public String getDate() {
        return date;
    }

    // Setter for date
    public void setDate(String date) {
        this.date = date;
    }

    // Getter for price
    public Double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(Double price) {
        this.price = price;
    }

    // Getter for productDetails
    public List<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetail> details) {
        this.productDetails = details;
    }

    // Method to add a product detail to the list
    public void addProductDetail(ProductDetail productDetail) {
        this.productDetails.add(productDetail);
    }

    public void removeByProductCode(String productCode) {
        this.productDetails.removeIf(product -> product.getProductCode().equals(productCode));
    }

    public void updateProductDetail(List<ProductDetail> details) {

    }
}
