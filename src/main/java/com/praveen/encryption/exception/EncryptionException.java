package com.praveen.encryption.exception;

public class EncryptionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int statusCode;

	public EncryptionException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

}
