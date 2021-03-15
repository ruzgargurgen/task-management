package com.tr.task.exceptions;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String message;
	
	private Object[] args;
	
	
	public BusinessException(String message) {
		super(message);
		this.setMessage(message);
	}
	
	public BusinessException(String message,Object ...args) {
		super(message);
		this.setMessage(message);
		this.setArgs(args);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
	
	
}
