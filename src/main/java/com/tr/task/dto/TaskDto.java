package com.tr.task.dto;

import java.util.Date;

import com.tr.task.dto.base.BaseDto;
import com.tr.task.entity.User;
import com.tr.task.enums.TaskStatus;


public class TaskDto extends BaseDto<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String description;
	
	private TaskStatus status=TaskStatus.TODO;
	
	private Date completedDate;
	
	private UserDto assignee;
	
	public TaskDto() {

	}

	public TaskDto(String name, String description, TaskStatus status, Date completedDate) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.setCompletedDate(completedDate);
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}



	public Date getCompletedDate() {
		return completedDate;
	}



	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public UserDto getAssignee() {
		return assignee;
	}

	public void setAssignee(UserDto assignee) {
		this.assignee = assignee;
	}

	
	
}
