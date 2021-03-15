package com.tr.task.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tr.task.entity.base.BaseEntity;
import com.tr.task.enums.TaskStatus;

/**
 * Görevler
 * 
 * 
 * @author otunctan.rgurgen,rbakan
 *
 */
@Entity
@Table(name = "TASK")
@SequenceGenerator(name = "idGenerator",sequenceName = "SQ_TASK",initialValue = 1,allocationSize = 60)
public class Task extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Görev adı
	 */
	@Column(name = "NAME")
	private String name;
	
	/**
	 * Görev açıklama
	 */
	@Column(name = "DESCRIPTION")
	private String description;
	
	/**
	 * Görev durumu
	 */
	@Column(name = "STATUS")
	private TaskStatus status=TaskStatus.TODO;
	
	/**
	 * Görev atanmış kişi
	 */
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSIGNEE_ID",referencedColumnName = "ID")
	private User assignee;
	
	/**
	 * Görev tamamlanma zamanı
	 */
	@Column(name = "COMPLETED_DATE")
    @Temporal(TemporalType.DATE)
	private Date completedDate;
	
	
	
	public Task() {
		super(0l);
		// TODO Auto-generated constructor stub
	}
	
	public Task(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

}
