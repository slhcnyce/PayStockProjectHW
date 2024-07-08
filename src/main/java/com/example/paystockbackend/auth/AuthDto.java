package com.example.paystockbackend.auth;

import jakarta.persistence.Entity; 
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class AuthDto {

	 @Id
	   
    private String username;
    private String password;
    private Long renterCode;

    // getter ve setter'lar
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Long getRenterCode() {
        return renterCode;
    }

    public void setRenterCode(Long renterCode) {
        this.renterCode = renterCode;
    }
}