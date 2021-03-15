package com.tr.task.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tr.task.entity.Task;
import com.tr.task.enums.TaskStatus;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	Page<Task> findByStatus(TaskStatus status, Pageable of);

	Page<Task> findByAssigneeId(Long assigneeId, Pageable of);
	
	Task findFirstByName(String name);
	
	List<Task> findByNameAndStatus(String name,TaskStatus status);

}
