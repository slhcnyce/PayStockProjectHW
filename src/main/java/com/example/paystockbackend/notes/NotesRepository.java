package com.example.paystockbackend.notes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<NotesDto, Long> {
    NotesDto findByRenterCode(Long renterCode);
}