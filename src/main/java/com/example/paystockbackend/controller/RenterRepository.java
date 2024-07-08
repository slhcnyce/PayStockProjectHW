
package com.example.paystockbackend.controller;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.paystockbackend.model.Renter;

@RepositoryRestResource
public interface RenterRepository extends JpaRepository<Renter, Long> {
 
}