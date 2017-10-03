package com.neethu.todo.MyToDoApp.Dao;

import java.util.List;

import com.neethu.todo.MyToDoApp.Model.Task;

public interface TaskDao {

	public List<Task> getCompletedTasks();
	public List<Task> getPendingTasks();
	public Task addTask(String name);
	public Task deletetask(int id);
	public Task doneTask(int id);
}
