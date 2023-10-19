package com.praveen.encryption.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EncryptionExceptionHandler {

	/**
	 * Handling EncryptionException thrown in the application
	 */
	@ExceptionHandler(EncryptionException.class)
	public ResponseEntity<String> handleCustomRuntimeException(EncryptionException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.valueOf(ex.getStatusCode()));
	}

}
