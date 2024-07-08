package com.example.paystockbackend.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

 

@RepositoryRestResource
public interface AuthRepository extends JpaRepository<AuthDto, String> {
	Optional<AuthDto> findByUsername(String username);
}