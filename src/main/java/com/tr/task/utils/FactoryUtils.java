package com.tr.task.utils;

public final class FactoryUtils {

	public static long tic() {
		return System.currentTimeMillis();
	}
	
	public static long toc(long startTime) {
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		return elapsedTime;
	}
}
