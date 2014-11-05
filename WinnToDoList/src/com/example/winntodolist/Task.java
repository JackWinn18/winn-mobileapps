package com.example.winntodolist;

public class Task {
	// Fields to Model Task Object
	private int taskId;
	private boolean priority; 
	private String date;
	private String task;
	private boolean isCompleted;
	
	// Constructor 
	public Task() {
		
	}
	
	// Acessors and Modifiers
	public void setTaskId(int id) {
		taskId = id;
	}
	
	public void setPriority(boolean p) {
		priority = p;
	}
	
	public void setDate(String d) {
		date = d;
	}
	
	public void setTask(String t) {
		task = t;
	}
	
	public void setCompleted(boolean c) {
		isCompleted = c;
	}

}
