package com.tr.task.dto;

public class ErrorDetail {

	private String code;

	private String message;
	
	private String field;

	public ErrorDetail() {
	}
	
	public ErrorDetail(String message) {
		this.message=message;
	}
	
	public ErrorDetail(String code, String field, String message) {
		super();
		this.code = code;
		this.message = message;
		this.field = field;
	}
	
	public ErrorDetail(String field, String message) {
		this(null, field,message);
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	
	
	
}
