package com.example.paystockbackend.payment;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    private Long renterCode;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentListDto> paymentDetails = new ArrayList<>();

    // Getters and setters...

    public void addPaymentDetail(PaymentListDto paymentListDto) {

        this.paymentDetails.add(paymentListDto);
    }

    public void removePaymentDetail(PaymentListDto paymentListDto) {

        this.paymentDetails.remove(paymentListDto);
    }

    // Getters and setters for id and renterCode...

    public Long getRenterCode() {
        return renterCode;
    }

    public void setRenterCode(Long renterCode) {
        this.renterCode = renterCode;
    }

    public List<PaymentListDto> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentListDto> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
