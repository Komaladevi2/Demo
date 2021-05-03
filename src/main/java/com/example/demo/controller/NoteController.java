package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Note;
import com.example.demo.service.NoteService;

@RestController
@RequestMapping(value = "/noteservice", produces = "application/json")
public class NoteController {
	
	@Autowired
	NoteService noteService;
	
	@GetMapping("/all")
	public List<Note> getAllNotes(){
		return noteService.getAllNotes();
	}
	
	@PostMapping("/add")
	public String addNote(@RequestBody Note note) {
		return noteService.addNote(note);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteNoteById(@PathVariable("id") int id) {
		return noteService.deleteNoteById(id);
	}
	
	@GetMapping("/note/{id}")
	public Note getNoteById(@PathVariable("id") int id) {
		return noteService.getNoteById(id);
	}
	
	@PutMapping("/update/{id}/{status}")
	public String updateNoteStatusById(@PathVariable("id") int id,@PathVariable("status") String updatedStatus) {
		return noteService.updateNoteStatus(id, updatedStatus);
	}
	
	@GetMapping("/findByAuthor/{author}")
	public List<Note> getAllNotesByAuthorName(@PathVariable("author") String authorName){
		return noteService.getNotesByAuthorName(authorName);
	} 
	
	@GetMapping("/findByStatus/{status}")
	public List<Note> getAllNotesByStatys(@PathVariable("status") String status){
		return noteService.getNotesByStatus(status);
	}
	

}
