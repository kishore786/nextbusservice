package com.nextbus.nextbusservice.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Kishore Kar
 */
public class NextBusServiceException extends RuntimeException {
	
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

	/**
	 * Constructs a new runtime exception with the specified detail message. The
	 * cause is not initialized, and may subsequently be initialized by a call
	 * to {@link #initCause}.
	 * 
	 * @param message
	 *            the detail message. The detail message is saved for later
	 *            retrieval by the {@link #getMessage()} method.
	 */
	public NextBusServiceException(Exception exception) {
		this(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");

	}

	public NextBusServiceException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
