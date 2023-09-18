package com.example.homework.HomeWork12_Dev.repository;
import com.example.homework.HomeWork12_Dev.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}

