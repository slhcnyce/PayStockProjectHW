package com.example.paystockbackend.notes;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notes")
public class NotesDto {

    @Id
    @Column(nullable = false, unique = true)
    private Long renterCode;

    @OneToMany(cascade = CascadeType.ALL)
    private List<NoteDetailDto> noteDetailDto = new ArrayList<>();

    public Long getRenterCode() {
        return renterCode;
    }

    public void setRenterCode(Long renterCode) {
        this.renterCode = renterCode;
    }

    public List<NoteDetailDto> getNotes() {
        return noteDetailDto;
    }

    public void addNote(NoteDetailDto noteDetailDto) {

        this.noteDetailDto.add(noteDetailDto);
    }

    public void removeNoteById(Long noteId) {
        this.noteDetailDto.removeIf(note -> note.getId().equals(noteId));
    }
}