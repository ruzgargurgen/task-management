package com.tr.task.entity.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tr.task.constants.GlobalParameter;

@MappedSuperclass
public abstract class BaseEntity<ID extends Number> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "idGenerator", strategy = GenerationType.SEQUENCE)
	private ID id;

	@Column(name = "CREATED_BY")
	private String createdBy = GlobalParameter.WEB_USER;

	@Column(name = "CREATED_AT")
	@Temporal(TemporalType.DATE)
	private Date createdAt = new Date();

	public BaseEntity(ID id) {
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
