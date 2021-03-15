package com.tr.task.enums;

public enum TaskStatus {
	
	/**
	 * Yapılacak
	 */
	TODO(),
	
	/**
	 * Yapılıyor, Devam Ediyor
	 */
	IN_PROGRESS,

	/**
	 * Ertelendi
	 */
	POSTPONED,

	/**
	 * İptal
	 */
	CANCELLED,

	/**
	 * Tamamlandı
	 */
	DONE;
	

}
