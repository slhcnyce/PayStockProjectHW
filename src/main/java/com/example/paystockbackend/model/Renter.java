package com.example.paystockbackend.model;

import jakarta.persistence.*;


@Entity
@Table(name = "renters")
public class Renter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
