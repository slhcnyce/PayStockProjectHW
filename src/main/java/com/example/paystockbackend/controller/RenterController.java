package com.example.paystockbackend.controller;

import com.example.paystockbackend.model.StatusModel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.paystockbackend.model.Renter; 

@RestController
public class RenterController {

    @Autowired
    private RenterRepository renterRepository;

    @GetMapping
    public List<Renter> getAllRenters() {
        return renterRepository.findAll();
    }

	@PostMapping("/check")
    public StatusModel checkRenter(@RequestBody Renter renter) {
    	var hasRenter =  renterRepository.existsById(renter.getId());
    	 
       
        return new StatusModel(hasRenter); 
    }

    @PostMapping("/addRenter")
    public void addRenter(@RequestBody Renter renter) {
         renterRepository.save(renter);
    }
}


