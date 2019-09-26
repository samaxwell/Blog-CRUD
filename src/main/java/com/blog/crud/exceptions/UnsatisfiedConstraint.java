package com.blog.crud.exceptions;


/*
 * Generic exception to indicate a business rule has been 
 * violated.
 * 
 * This exception should not be used for application errors.
 */
public class UnsatisfiedConstraint extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnsatisfiedConstraint() {
	}

	public UnsatisfiedConstraint(String message) {
		super(message);
	}

	public UnsatisfiedConstraint(Throwable cause) {
		super(cause);
	}

	public UnsatisfiedConstraint(String message, Throwable cause) {
		super(message, cause);
	}

	public UnsatisfiedConstraint(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
