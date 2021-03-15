package com.tr.task.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.scheduling", ignoreUnknownFields = true)
public class SchedulingProperties {

	private TaskProperties task = new TaskProperties();


	public TaskProperties getTask() {
		return task;
	}
	
	
	public static class TaskProperties {

		private boolean enable;

		private long fixedDelayInMilliSecond;

		public boolean isEnable() {
			return enable;
		}

		public void setEnable(boolean enable) {
			this.enable = enable;
		}

		public long getFixedDelayInMilliSecond() {
			return fixedDelayInMilliSecond;
		}

		public void setFixedDelayInMilliSecond(long fixedDelayInMilliSecond) {
			this.fixedDelayInMilliSecond = fixedDelayInMilliSecond;
		}

	}

}
