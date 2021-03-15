package com.tr.task.config;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tr.task.interceptors.CustomClientHttpRequestInterceptor;
import com.tr.task.properties.InternationalizationProperties;
import com.tr.task.resolver.RequestLocaleResolver;

@Configuration
public class ApplicationConfig {

//	@Value("#{'${application.internationalization.allowed.languages}'.split(',')}")
//	private List<String> supportedLanguages;
//
//	@Value("${application.internationalization.default.language}")
//	private String defaultLanguage;
	
	@Autowired
	private InternationalizationProperties internationalization;

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:i18n/messages");
		messageSource.setDefaultLocale(Locale.forLanguageTag(internationalization.getDefaultLanguage()));
		messageSource.setDefaultEncoding(StandardCharsets.UTF_8.toString());
		return messageSource;
	}

	@Bean(initMethod = "initialize")
	public LocaleResolver localeResolver() {
		RequestLocaleResolver requestLocaleResolver = new RequestLocaleResolver();
		requestLocaleResolver.setDefaultLanguage(internationalization.getDefaultLanguage());
		requestLocaleResolver.setSupportedLanguages(internationalization.getAllowedLanguages());
		return requestLocaleResolver;
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setInterceptors(Arrays.asList(new CustomClientHttpRequestInterceptor()));
		return restTemplate;
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setThreadNamePrefix("Task-Management");
		threadPoolTaskExecutor.setThreadGroupName("Task-Group");
		threadPoolTaskExecutor.setCorePoolSize(100);
		return threadPoolTaskExecutor;
	}
}
