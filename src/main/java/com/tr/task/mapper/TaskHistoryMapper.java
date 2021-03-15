package com.tr.task.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tr.task.dto.TaskHistoryDto;
import com.tr.task.dto.TaskDto;
import com.tr.task.entity.TaskHistory;
import com.tr.task.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskHistoryMapper {

	public TaskHistoryDto assignedTaskToAssignedTaskDto(TaskHistory assignedTask);

	public TaskHistory assignedTaskDtoToAssignedTask(TaskHistoryDto assignedTaskDto);

	public List<TaskHistoryDto> assignedTasksToAssignedTaskDtos(List<TaskHistory> assignedTasks);

	public List<TaskHistory> assignedTaskDtosToAssignedTasks(List<TaskHistoryDto> assignedTaskDtos);

}
