package com.neethu.todo.MyToDoApp.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neethu.todo.MyToDoApp.Dao.TaskDao;
import com.neethu.todo.MyToDoApp.Model.Task;
import com.neethu.todo.MyToDoApp.Service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDao taskDao;

	@Override
	public List<Task> getCompletedTasks() {
		List<Task> taskList = taskDao.getCompletedTasks();
		return taskList;
	}

	@Override
	public List<Task> getPendingTasks() {
		List<Task> taskList = taskDao.getPendingTasks();
		return taskList;
	}

	@Override
	public Task addTask(String name) {
		return taskDao.addTask(name);
	}

	@Override
	public Task deletetask(int id) {
		return taskDao.deletetask(id);
	}
	
	@Override
	public Task doneTask(int id) {
		return taskDao.doneTask(id);
	}

}
