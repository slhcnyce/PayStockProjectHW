package com.example.paystockbackend.notes;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paystockbackend.model.StatusModel;

@RestController
@RequestMapping("/notes")
public class NotesController {
    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping
    public StatusModel createProduct(@RequestBody NoteDetailDto noteDetailDto) {

        return notesService.createNote(noteDetailDto.getRenterCode(), noteDetailDto);
    }

    @GetMapping("/{renterCode}")

    public List<NoteDetailDto> getProductByRenterCode(@PathVariable Long renterCode) {

        return notesService.getNotesListByRenterCode(renterCode);
    }

    @DeleteMapping("/{renterCode}/{noteId}")
    public StatusModel deleteNoteDetail(@PathVariable Long renterCode, @PathVariable Long noteId) {
        return notesService.deleteNoteDetailById(renterCode, noteId);
    }
}
