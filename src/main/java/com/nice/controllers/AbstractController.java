package com.nice.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AbstractController {
	
	@ModelAttribute
	default void setHeaders(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "True");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Location,Link,ETag");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
				"Origin, X-Requested-With, Content-Type, Accept,username,x-ibm-client-id,x-ibm-client-secret,iPlanetDirectoryPro");
		response.setHeader(HttpHeaders.CONTENT_LANGUAGE, "en");
		response.setHeader(HttpHeaders.LOCATION, request.getRequestURL().toString());
		response.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, sdch");
		response.setHeader(HttpHeaders.CACHE_CONTROL, "private, no-store, no-cache, must-revalidate");
		response.setHeader(HttpHeaders.CONNECTION, "Keep-Alive");
		response.setHeader(HttpHeaders.VARY, "Accept-Encoding");
	}
	
}
