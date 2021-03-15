package com.tr.task.dto.base;

import java.util.Date;

public class BaseDto<ID extends Number> {

	private ID id;
	
	private String createdBy;
	
	private Date createdAt;

	public BaseDto() {
	}

	public BaseDto(ID id) {
		setId(id);
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
