package com.tr.task.service;

import java.util.List;

import com.tr.task.dto.TaskHistoryDto;
import com.tr.task.dto.PagedResultDto;
import com.tr.task.enums.TaskStatus;

public interface TaskHistoryService {

	List<TaskHistoryDto> getAssignTasksByAssigneeId(Long assignId);
	
	PagedResultDto<TaskHistoryDto> getAllAssignedTasks(Integer page,Integer size);
	
	PagedResultDto<TaskHistoryDto> getAllAssignedTasks(TaskStatus status,Integer page,Integer size);
	
	TaskHistoryDto createAssignedTask(TaskHistoryDto assignedTaskDto);
	
	TaskHistoryDto updateAssignedTask(Long assignedTaskId,TaskHistoryDto assignedTaskDto);
	
	boolean deleteAssignedTask(Long assignedTaskId);
	
	
	
}
