package com.neethu.todo.MyToDoApp.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neethu.todo.MyToDoApp.Model.Task;
import com.neethu.todo.MyToDoApp.Service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	public TaskService taskService;
	
	
	
	@RequestMapping(value="/addTask",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> addTask(@RequestBody String taskName) {
		taskName = taskName.split("taskName=")[1];
		Map<String, String>  resultMap = null;
		Task savedTask = null;
		savedTask = taskService.addTask(taskName);
		if(savedTask != null) {
			resultMap= new HashMap<String,String>();
			resultMap.put("id", Integer.toString(savedTask.getId()));
			resultMap.put("name", savedTask.getTaskName());
		}
		return resultMap;
	}
	
	@RequestMapping(value="/deleteTask",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> deleteTask(@RequestBody String taskId) {
		taskId = taskId.split("taskId=")[1];
		Map<String, String>  resultMap = null;
		Task deletedTask = null;
		deletedTask = taskService.deletetask(Integer.parseInt(taskId));
		if(deletedTask != null) {
			resultMap= new HashMap<String,String>();
			resultMap.put("id", Integer.toString(deletedTask.getId()));
			resultMap.put("name", deletedTask.getTaskName());
		}
		return resultMap;
	}
	
	@RequestMapping(value="/doneTask",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> doneTask(@RequestBody String taskId) {
		taskId = taskId.split("taskId=")[1];
		Map<String, String>  resultMap = null;
		Task doneTask = null;
		doneTask = taskService.doneTask(Integer.parseInt(taskId));
		if(doneTask != null) {
			resultMap= new HashMap<String,String>();
			resultMap.put("id", Integer.toString(doneTask.getId()));
			resultMap.put("name", doneTask.getTaskName());
		}
		return resultMap;
	}
	
	
	@RequestMapping(value="/pendingTasks",method=RequestMethod.GET)
	public List<Map<String,String>> getAllPendingTasks() {
		List<Task> taskList= taskService.getPendingTasks();
		List<Map<String, String>> taskMapList = new ArrayList<>();
		Map<String, String>  resultMap = null;
		for (Task task : taskList) {
			resultMap= new HashMap<String,String>();
			resultMap.put("id", Integer.toString(task.getId()));
			resultMap.put("name", task.getTaskName());
			taskMapList.add(resultMap);
		}
		return taskMapList;
	}
	
	@RequestMapping(value="/completedTasks",method=RequestMethod.GET)
	public List<Map<String,String>> getAllCompletedTasks() {
		List<Task> taskList= taskService.getCompletedTasks();
		List<Map<String, String>> taskMapList = new ArrayList<>();
		Map<String, String>  resultMap = null;
		for (Task task : taskList) {
			resultMap= new HashMap<String,String>();
			resultMap.put("id", Integer.toString(task.getId()));
			resultMap.put("name", task.getTaskName());
			taskMapList.add(resultMap);
		}
		return taskMapList;
	}
}
