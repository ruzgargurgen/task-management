package com.tr.task.service;

import java.util.Date;
import java.util.List;

import com.tr.task.dto.PagedResultDto;
import com.tr.task.dto.TaskDto;
import com.tr.task.dto.TaskUpdateDto;
import com.tr.task.enums.TaskStatus;

public interface TaskService {

	List<TaskDto> getAllTasks();
	
	PagedResultDto<TaskDto> getAllTasks(Integer page,Integer size);
	
	PagedResultDto<TaskDto> getTasksByTaskStatus(TaskStatus status,Integer page,Integer size);
	
	PagedResultDto<TaskDto> getTasksByAssigneeId(Long assigneeId,Integer page,Integer size);
	
	TaskDto save(TaskDto dto);
	
	TaskUpdateDto updateTask(Long id,TaskUpdateDto dto);
	
	TaskUpdateDto updateTaskCompletedDate(Long id,Date completedDate);
	
	boolean deleteTaskById(Long id);

	TaskUpdateDto updateTaskStatus(Long taskId,TaskStatus taskStatus);

}
