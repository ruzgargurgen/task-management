package com.tr.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.tr.task.properties.ApplicationProperties;
import com.tr.task.properties.InternationalizationProperties;
import com.tr.task.properties.SchedulingProperties;
import com.tr.task.utils.FactoryUtils;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
@EnableConfigurationProperties(value = { //
		InternationalizationProperties.class, //
		ApplicationProperties.class, //
		SchedulingProperties.class })
@EnableAsync
public class TaskManagementApplication {

	private static final Logger logger = LoggerFactory.getLogger(TaskManagementApplication.class);

	public static void main(String[] args) {
		long startTime = FactoryUtils.tic();
		SpringApplication.run(TaskManagementApplication.class, args);
		logger.info("<=============TaskManagementApplication run()=============>");
		long elapsedTime = FactoryUtils.toc(startTime);
		logger.info("Elapsed time :" + elapsedTime + " ms");
	}

}
