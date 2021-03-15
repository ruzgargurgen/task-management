package com.tr.task.dto;

import com.tr.task.dto.base.BaseDto;

public class TaskHistoryDto extends BaseDto<Long>{

	
	private UserDto assignee;
	
	private TaskDto task;
	
	public TaskHistoryDto() {

	}
	
	public TaskDto getTask() {
		return task;
	}

	public void setTask(TaskDto task) {
		this.task = task;
	}

	public UserDto getAssignee() {
		return assignee;
	}

	public void setAssignee(UserDto assignee) {
		this.assignee = assignee;
	}
	
	
	
	
	
	
}
