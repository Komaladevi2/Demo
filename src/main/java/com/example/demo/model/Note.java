package com.example.demo.model;

public class Note {
	
	//Auto incremented value in notes_table
	private int id;
	
	private String name;
	private String title;
	private String description;
	private String initialStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInitialStatus() {
		return initialStatus;
	}
	public void setInitialStatus(String initialStatus) {
		this.initialStatus = initialStatus;
	}
	@Override
	public String toString() {
		return "Note [name=" + name + ", title=" + title + ", description=" + description + ", initialStatus="
				+ initialStatus + "]";
	}
	
	
}
