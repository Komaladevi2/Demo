package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Note;

public interface NoteService {

	List<Note> getAllNotes();

	String addNote(Note note);

	String deleteNoteById(int id);

	Note getNoteById(int id);

	String updateNoteStatus(int id, String updatedStatus);

	List<Note> getNotesByAuthorName(String authorName);

	List<Note> getNotesByStatus(String status);

}
