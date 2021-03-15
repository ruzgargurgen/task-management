package com.tr.task.dto;

import java.util.List;

public class PagedResultDto<T> {
	
	/**
	 * Başlangıc Index 
	 */
	private Integer offset;
	
	/**
	 * Sınır 
	 */
	private Integer limit;
	
	/**
	 * 
	 */
	private List<T> elements;
	
	/**
	 * 
	 */
	private Long totalElement;
	
	
	public PagedResultDto() {
	}

	

	public PagedResultDto(List<T> elements,Integer offset, Integer limit, Long totalElement) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.elements = elements;
		this.totalElement = totalElement;
	}



	public Integer getOffset() {
		return offset;
	}


	public void setOffset(Integer offset) {
		this.offset = offset;
	}


	public Integer getLimit() {
		return limit;
	}


	public void setLimit(Integer limit) {
		this.limit = limit;
	}


	public List<T> getElements() {
		return elements;
	}


	public void setElements(List<T> elements) {
		this.elements = elements;
	}


	public Long getTotalElement() {
		return totalElement;
	}


	public void setTotalElement(Long totalElement) {
		this.totalElement = totalElement;
	}
	
	
	
}
