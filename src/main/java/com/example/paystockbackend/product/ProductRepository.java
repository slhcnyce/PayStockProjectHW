package com.example.paystockbackend.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDto, Long> {
    ProductDto findByRenterCode(Long renterCode);
}