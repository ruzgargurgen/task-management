package com.tr.task.dto;

import java.util.Date;

import com.tr.task.dto.base.BaseDto;
import com.tr.task.enums.TaskStatus;
/**
 * TaskUpdateDto.class
 * 
 * @author ozaytunctan,rbakan,rgurgen
 * @version 1.0
 *
 */
public class TaskUpdateDto extends BaseDto<Long> {
   
	private String name;
	
    private String description;

    private TaskStatus status;

    private Long assigneeId;
    
    private Date completedDate;

    public TaskUpdateDto() {

	}

    
	public TaskUpdateDto(String name, String description, TaskStatus status, Long assigneeId, Date completedDate) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.assigneeId = assigneeId;
		this.completedDate = completedDate;
	}
	
	public TaskUpdateDto(Long id, TaskStatus status) {
		super();
		this.setId(id);
		this.status = status;
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

	public Long getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}
    
    
    
    
    
}
