package com.neethu.todo.MyToDoApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neethu.todo.MyToDoApp.Model.Task;


@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Integer>{

	@Query(value="select id as id,task_name as task_name, flag_completed as flag_completed,flag_deleted as flag_deleted from Task where flag_completed = 1 and flag_deleted != 1",nativeQuery=true)
	public List<Task> getCompletedTasks();
	
	
	@Query(value="select id as id,task_name as task_name, flag_completed as flag_completed,flag_deleted as flag_deleted from Task where flag_completed = 0 and flag_deleted != 1",nativeQuery=true)
	public List<Task> getPendingTasks();
}
