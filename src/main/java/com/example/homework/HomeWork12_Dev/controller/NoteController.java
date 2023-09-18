package com.example.homework.HomeWork12_Dev.controller;
import com.example.homework.HomeWork12_Dev.service.NoteService;
import com.example.homework.HomeWork12_Dev.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public String listNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes", notes);
        return "list";
    }
    @GetMapping("/add")
    public String showAddNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "add";
    }

    @PostMapping("/add")
    public String addNote(@ModelAttribute Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam Long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "edit";
    }

    @PostMapping("/edit")
    public String saveNote(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
