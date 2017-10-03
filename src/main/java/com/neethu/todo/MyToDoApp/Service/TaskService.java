package com.neethu.todo.MyToDoApp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neethu.todo.MyToDoApp.Model.Task;



@Service
public interface TaskService {
	
	public List<Task> getCompletedTasks();
	public List<Task> getPendingTasks();
	public Task addTask(String name);
	public Task deletetask(int id);
	public Task doneTask(int id);
}
