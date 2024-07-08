package com.example.paystockbackend.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PaymentList")
public class PaymentListDto {

    @Id
    @GeneratedValue
    private Long id;

    private String date;
    private Double price;

    // @OneToMany(cascade = CascadeType.ALL)
    // private List<ProductDetail> productDetails = new ArrayList<>();

    public PaymentListDto() {
    }

    public PaymentListDto(String date, Double price) {

        this.date = date;
        this.price = price;
        // this.productDetails = productDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    // Getter for renterCode

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

}