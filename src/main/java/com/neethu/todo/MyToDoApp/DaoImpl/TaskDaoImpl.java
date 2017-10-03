package com.neethu.todo.MyToDoApp.DaoImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neethu.todo.MyToDoApp.Dao.TaskDao;
import com.neethu.todo.MyToDoApp.Model.Task;
import com.neethu.todo.MyToDoApp.Repository.TaskRepository;



@Component
public class TaskDaoImpl implements TaskDao{

	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public List<Task> getCompletedTasks() {
		return taskRepository.getCompletedTasks();
	}

	@Override
	public List<Task> getPendingTasks() {
		return taskRepository.getPendingTasks();
	}

	@Override
	public Task addTask(String name) {
		Task task = new Task();
		task.setTaskName(name);
		return taskRepository.save(task);
	}

	@Override
	public Task deletetask(int id) {
		Task task = taskRepository.findOne(id);
		task.setFlagDeleted(1);
		return taskRepository.save(task);
	}
	@Override
	public Task doneTask(int id) {
		Task task = taskRepository.findOne(id);
		task.setFlagCompleted(1);
		return taskRepository.save(task);
	}
}
