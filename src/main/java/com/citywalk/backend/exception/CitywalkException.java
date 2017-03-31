package com.citywalk.backend.exception;

public class CitywalkException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CitywalkException() {
		super();
	}

	public CitywalkException(String message) {
		super(message);
	}

	public CitywalkException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
