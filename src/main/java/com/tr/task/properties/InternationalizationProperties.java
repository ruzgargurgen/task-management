package com.tr.task.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(ignoreUnknownFields = true, prefix="application.internationalization")
public class InternationalizationProperties {

	private List<String> allowedLanguages;

	private String defaultLanguage;

	public InternationalizationProperties() {
		// TODO Auto-generated constructor stub
	}

	public String getDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}

	public List<String> getAllowedLanguages() {
		return allowedLanguages;
	}

	public void setAllowedLanguages(List<String> allowedLanguages) {
		this.allowedLanguages = allowedLanguages;
	}

}
