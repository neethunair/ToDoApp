package com.neethu.todo.MyToDoApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Task {

	@Id
	@GeneratedValue
	private int id;
	private String taskName;
	private int flagCompleted;
	private int flagDeleted;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String task_name) {
		this.taskName = task_name;
	}
	public int getFlagCompleted() {
		return flagCompleted;
	}
	public void setFlagCompleted(int flag_completed) {
		this.flagCompleted = flag_completed;
	}
	public int getFlagDeleted() {
		return flagDeleted;
	}
	public void setFlagDeleted(int flag_deleted) {
		this.flagDeleted = flag_deleted;
	}
}
