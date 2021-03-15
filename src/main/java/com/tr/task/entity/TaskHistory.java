package com.tr.task.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tr.task.entity.base.BaseEntity;

/*
 * Atanmış tasklar
 */
@Entity
@Table(name="TASK_HISTORY")
@SequenceGenerator(name = "idGenerator",sequenceName = "SQ_ASSIGNED_TASK",initialValue = 1,allocationSize = 60)
public class TaskHistory extends BaseEntity<Long> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_ID",referencedColumnName = "ID")
	private Task task;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID",referencedColumnName = "ID")
	private User assignee;
	
	
	public TaskHistory() {
		super(0L);
	}
	
	public TaskHistory(Long id) {
		super(id);
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	
}
