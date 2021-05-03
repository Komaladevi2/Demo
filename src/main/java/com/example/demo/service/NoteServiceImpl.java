package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Note;
import com.example.demo.repo.NoteRepository;


@Service
public class NoteServiceImpl implements NoteService{
	
	@Autowired
	NoteRepository noteRepo;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Note> getAllNotes() {
		
		List<Note> notesList= noteRepo.getAllNotes();
		return notesList;
	}

	@Override
	public String addNote(Note note) {
		noteRepo.addNote(note);
		return "Note Added Successfully";
	}

	@Override
	public String deleteNoteById(int id) {
		noteRepo.deleteNote(id);
		return "Deleted Successfully";
	}

	@Override
	public Note getNoteById(int id) {
		Note note=noteRepo.getNoteById(id);
		return note;
	}

	@Override
	public String updateNoteStatus(int id, String updatedStatus) {
		Note note = noteRepo.getNoteById(id);
		String result= noteRepo.updateNoteStatus(note, updatedStatus);
		return result;
	}

	@Override
	public List<Note> getNotesByAuthorName(String authorName) {
		List<Note> notes=noteRepo.getNotesByAuthorName(authorName);
		return notes;
	}

	@Override
	public List<Note> getNotesByStatus(String status) {
		List<Note> notesByStatus = noteRepo.getNotesByStatus(status);
		return notesByStatus;
	}

}
