package com.tr.task.dto;

import javax.validation.constraints.NotNull;

import com.tr.task.dto.base.BaseDto;
import com.tr.task.validations.UniqueUsername;

public class UserDto extends BaseDto<Long> {

	@NotNull ()
	@UniqueUsername(message = "error.username.exists")
	private String userName;

	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	private String fullName;
	
	
	public UserDto() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	

}
