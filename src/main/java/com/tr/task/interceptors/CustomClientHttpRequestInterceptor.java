package com.tr.task.interceptors;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

	private final Logger LOG = LoggerFactory.getLogger(CustomClientHttpRequestInterceptor.class);

	public CustomClientHttpRequestInterceptor() {
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		requestLog(request, body);

		ClientHttpResponse response = execution.execute(request, body);

		responseLog(response);

		return response;
	}

	private void requestLog(HttpRequest request, byte[] body) throws IOException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("============================Request Begin=========================");
			LOG.debug("URI         : {}", request.getURI());
			LOG.debug("Method      : {}", request.getMethod());
			LOG.debug("Headers     : {}", request.getHeaders());
			LOG.debug("Request Body: {}", new String(body, StandardCharsets.UTF_8));
			LOG.debug("============================Request End============================");
		}
	}

	private void responseLog(ClientHttpResponse response) throws IOException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("============================Response Begin========================");
			LOG.debug("Status Code  : {}", response.getStatusCode());
			LOG.debug("Status Text  : {}", response.getStatusText());
			LOG.debug("Headers      : {}", response.getHeaders());
//			logger.debug("Response body: {}", new String(response.getBody().toString()));
			LOG.debug("============================Response End===========================");

		}
	}

}
