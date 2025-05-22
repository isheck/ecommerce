package com.ecommerce.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex) {
		return "Exception occurred: " + ex.getMessage();
	}
}
