package com.example.paystockbackend.notes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NoteDetailDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String note;

    private Long renterCode;

    public Long getId() {
        return id;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public Long getRenterCode() {
        return renterCode;
    }

    public void setRenterCode(Long renterCode) {
        this.renterCode = renterCode;
    }
}
