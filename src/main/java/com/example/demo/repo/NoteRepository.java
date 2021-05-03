package com.example.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Note;

@SuppressWarnings({"unchecked","rawtypes", "deprecation"})
@Repository
public class NoteRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Note> getAllNotes() {
		String getNotesQuery="select * from notes_table";
		List<Note> notesList = jdbcTemplate.query(getNotesQuery, new BeanPropertyRowMapper(Note.class));
		return notesList;
	}

	public void addNote(Note note) {
		String addNoteQuery="insert into notes_table(name, title, description, initial_status) values (?,?,?,?)";
		jdbcTemplate.update(addNoteQuery, note.getName(), note.getTitle(), note.getDescription(), note.getInitialStatus());	
	}

	public void deleteNote(int id) {
		String deleteQuery="delete from notes_table where id=?";
		jdbcTemplate.update(deleteQuery, id);
		
	}

	public Note getNoteById(int id) {
		String getNoteQuery="select * from notes_table where id=?";
		Note note=(Note) jdbcTemplate.queryForObject(getNoteQuery, new Object[]{id}, new BeanPropertyRowMapper(Note.class));
		return note;
	}

	public String updateNoteStatus(Note note, String updatedStatus) {
		String queryForUpdateStatus="update notes_table set initial_status=? where id=?";
		jdbcTemplate.update(queryForUpdateStatus, updatedStatus, note.getId());
		return "Status Updated";
	}

	public List<Note> getNotesByAuthorName(String authorName) {
		String queryForNotes="select * from notes_table where author_name=?";
		List<Note> notesByAuthorName = jdbcTemplate.query(queryForNotes, new Object[] {authorName}, new BeanPropertyRowMapper(Note.class));
		return notesByAuthorName;
	}

	public List<Note> getNotesByStatus(String status) {
		String getNoteQuery="select * from notes_table where status=?";
		List<Note> notesList=jdbcTemplate.query(getNoteQuery, new Object[]{status}, new BeanPropertyRowMapper(Note.class));
		return notesList;
	}

}
