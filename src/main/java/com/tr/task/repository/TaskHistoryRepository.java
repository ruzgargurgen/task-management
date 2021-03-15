package com.tr.task.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tr.task.entity.TaskHistory;
import com.tr.task.enums.TaskStatus;

@Repository
public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Long>{

	List<TaskHistory> findByAssigneeId(Long assigneeId);
	
	Page<TaskHistory> findByTaskStatus(TaskStatus status, Pageable pageRequest);

	
}
