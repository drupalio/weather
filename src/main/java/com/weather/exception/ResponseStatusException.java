package com.weather.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;

public class ResponseStatusException extends NestedRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7263643760383204618L;

	private final HttpStatus status;

	private final String reason;



	public  ResponseStatusException(HttpStatus status, String reason) {
		this(status, reason, null);
	}


	public  ResponseStatusException(HttpStatus status, String reason, Throwable cause) {
		super("Request failure [status: " + status + ", reason: \"" + reason + "\"]", cause);
		this.status = status;
		this.reason = reason;
	}



	public  HttpStatus getStatus() {
		return this.status;
	}


	public  String getReason() {
		return this.reason;
	}

}
