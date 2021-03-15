package com.tr.task.exceptions;

public class TaskNotFoundException extends RuntimeException {

	private String message;

	public TaskNotFoundException(String message) {
		super(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
