package com.tr.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.support.BeanDefinitionDsl.Role;

import com.tr.task.entity.base.BaseEntity;
import com.tr.task.enums.UserRole;


@Entity
@Table(name="KULLANICI")
@SequenceGenerator(name = "idGenerator",sequenceName = "SQ_User",initialValue = 1,allocationSize = 60)
public class User extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name="USER_NAME",unique = true,nullable = false)
	private String userName;
	
	@Column(name="PASSWORD",nullable = false,unique = true)
	private String password;
	
	@Column(name="EMAIL",unique = true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ROLE")
	private UserRole role=UserRole.STANDART_USER;
	
	public User(Long id) {
		super(id);
	}
	
	public User() {
		super(0L);
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
