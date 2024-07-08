package com.example.paystockbackend.notes;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.paystockbackend.model.StatusModel;

@Service
public class NotesService {
    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public StatusModel createNote(Long renterCode, NoteDetailDto noteDetailDto) {
        try {
            NotesDto notes = getNotesByRenterCode(renterCode);

            if (notes != null) {
                notes.addNote(noteDetailDto);
                notesRepository.save(notes);
                return new StatusModel(true);
            } else {
                NotesDto newNote = new NotesDto();
                newNote.setRenterCode(renterCode);
                newNote.addNote(noteDetailDto);
                notesRepository.save(newNote);
                return new StatusModel(true);
            }

        } catch (DataIntegrityViolationException e) {
            // Handle specific exception for data integrity violation (e.g., unique
            // constraint violation)
            // You can log the exception or return an appropriate response/status here
            e.printStackTrace(); // Example: Print the stack trace
            return new StatusModel(false);
        } catch (Exception e) {
            // Handle generic exception
            e.printStackTrace();
            return new StatusModel(false);
        }
    }

    public NotesDto getNotesByRenterCode(Long renterCode) {
        try {
            return notesRepository.findById(renterCode).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<NoteDetailDto> getNotesListByRenterCode(Long renterCode) {
        try {
            return notesRepository.findById(renterCode).orElse(null).getNotes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public StatusModel deleteNoteDetailById(Long renterCode, Long noteId) {
        NotesDto notes = notesRepository.findByRenterCode(renterCode);
        if (notes != null) {
            notes.removeNoteById(noteId);
            notesRepository.save(notes);
            return new StatusModel(true, "Note deleted successfully");
        } else {
            return new StatusModel(false, "Notes not found for renter code");
        }
    }

}
