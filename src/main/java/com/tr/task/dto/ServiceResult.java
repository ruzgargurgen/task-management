package com.tr.task.dto;

import java.util.List;

import com.tr.task.enums.ServiceResultType;
/**
 * 
 * @author otunctan
 *
 * @param <T>
 */
public class ServiceResult<T> {

	private T data;
	
	private List<ErrorDetail> errors;
	
	private ServiceResultType resultType;
	
	
	public ServiceResult(List<ErrorDetail> errors) {
		this(null, errors, ServiceResultType.ERROR);
	}
	
	public ServiceResult(T data, ServiceResultType resultType) {
		this(data, null, resultType);
	}
	
	public ServiceResult(ServiceResultType resultType,List<ErrorDetail> errors) {
		this(null, errors, resultType);
	}

	public ServiceResult(T data, List<ErrorDetail> errors, ServiceResultType resultType) {
		super();
		this.data = data;
		this.errors = errors;
		this.resultType = resultType;
	}

	public ServiceResultType getResultType() {
		return resultType;
	}

	public void setResultType(ServiceResultType resultType) {
		this.resultType = resultType;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<ErrorDetail> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDetail> errors) {
		this.errors = errors;
	}

}
