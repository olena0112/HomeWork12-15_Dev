
package com.example.homework.HomeWork12_Dev.service;
import com.example.homework.HomeWork12_Dev.repository.NoteRepository;
import com.example.homework.HomeWork12_Dev.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
@Service
public class NoteService {
    private Map<Long, Note> noteMap = new HashMap<>();
    private long nextId = 1;

    public List<Note> listAll() {
        return new ArrayList<>(noteMap.values());
    }

    public Note add(Note note) {
        note.setId(nextId++);
        noteMap.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
        noteMap.remove(id);
    }

    public void update(Note note) {
        Long id = note.getId();
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
        noteMap.put(id, note);
    }

    public Note getById(long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
        return noteMap.get(id);
    }
}

*/
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> listAll() {
        List<Note> notes = new ArrayList<>();
        noteRepository.findAll().forEach(notes::add);
        return notes;
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        if (noteRepository.existsById(note.getId())) {
            noteRepository.save(note);
        } else {
            throw new IllegalArgumentException("Note not found with id: " + note.getId());
        }
    }

    public Note getById(long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            return note.get();
        } else {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
    }
}
