package com.tr.task.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;

public class RequestLocaleResolver implements LocaleResolver{
	

	private List<String> supportedLanguages=new ArrayList<>();


	private String defaultLanguage ;
	
	
	public void initialize() {
		LocaleContextHolder.setLocale(Locale.forLanguageTag(defaultLanguage));
	}


	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String acceptLanguage = request.getHeader("Accept-Language");
		if (!getSupportedLanguages().contains(acceptLanguage))
			acceptLanguage = getDefaultLanguage();

		return Locale.forLanguageTag(acceptLanguage);
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		LocaleContextHolder.setLocale(resolveLocale(request));
	}


	public List<String> getSupportedLanguages() {
		return supportedLanguages;
	}


	public void setSupportedLanguages(List<String> supportedLanguages) {
		this.supportedLanguages = supportedLanguages;
	}


	public String getDefaultLanguage() {
		return defaultLanguage;
	}


	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}



}
