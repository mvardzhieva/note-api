package noteapi.controller;

import noteapi.model.dto.AddRequestNoteDTO;
import noteapi.model.entity.Note;
import noteapi.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NoteController extends AbstractController {
    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/notes")
    public Note create(@Valid @RequestBody AddRequestNoteDTO addNoteDTO) {
        return noteService.create(addNoteDTO);
    }

    @GetMapping("/notes")
    public List<Note> retrieveNotes() {
        return noteService.retrieveNotes();
    }

    @GetMapping("/notes/{keyword}")
    public List<Note> filterNotesByKeyword(@PathVariable String keyword) {
        return noteService.filterNotes(keyword);
    }

    @DeleteMapping("/notes/{note_id}")
    public Note delete(@PathVariable(name = "note_id") int noteId) {
        return noteService.delete(noteId);
    }
}
