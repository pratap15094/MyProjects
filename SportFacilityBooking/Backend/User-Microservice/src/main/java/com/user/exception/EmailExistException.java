package com.user.exception;

public class EmailExistException extends RuntimeException{

	public EmailExistException() {
		super();
	}

	public EmailExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmailExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailExistException(String message) {
		super(message);
	}

	public EmailExistException(Throwable cause) {
		super(cause);
	}

}