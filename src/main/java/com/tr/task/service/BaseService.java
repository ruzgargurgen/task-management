package com.tr.task.service;

import javax.persistence.MappedSuperclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MappedSuperclass
public  class BaseService {

	protected Logger logger;
	
	protected int a=5;
	
	public BaseService(Class<?> clazz) {
		this.logger=LoggerFactory.getLogger(clazz);
	}
}
