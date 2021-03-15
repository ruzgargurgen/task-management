package com.tr.task.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tr.task.dto.TaskDto;
import com.tr.task.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

	public TaskDto taskToTaskDto(Task task);
	
	public Task taskDtoToTask(TaskDto dto);
	
	public List<TaskDto> tasksToTaskDtos(List<Task> task);
	
	public List<Task> taskDtosToTasks(List<TaskDto> dto);
	
	
}
