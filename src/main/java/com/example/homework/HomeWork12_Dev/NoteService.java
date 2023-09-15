package com.example.homework.HomeWork12_Dev;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

