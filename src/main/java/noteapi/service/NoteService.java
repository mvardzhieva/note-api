package noteapi.service;

import noteapi.exception.NotFoundException;
import noteapi.model.dto.AddRequestNoteDTO;
import noteapi.model.entity.Note;
import noteapi.model.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    @Autowired
    public NoteService (NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note create(AddRequestNoteDTO addNoteDTO) {
        Note note = new Note(addNoteDTO);
        noteRepository.save(note);
        return note;
    }

    public List<Note> retrieveNotes() {
        List<Note> notes = noteRepository.findAll();
        return Collections.unmodifiableList(notes);
    }

    public List<Note> filterNotes(String keyword) {
        List<Note> notes = noteRepository.findByTextContaining(keyword);
        return Collections.unmodifiableList(notes);
    }

    public Note delete(int noteId) {
        Optional<Note> optionalNote = noteRepository.findById(noteId);
        if (optionalNote.isEmpty()) {
            throw new NotFoundException("Note with this id does not exists.");
        }
        Note note = optionalNote.get();
        noteRepository.deleteById(noteId);
        return note;
    }
}
