package com.example.paystockbackend.model;

public class StatusModel {
    private Boolean isSuccess;
    private String message; // String is nullable by default in Java

    // Constructors
    public StatusModel(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public StatusModel(Boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    // Getters and Setters
    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}