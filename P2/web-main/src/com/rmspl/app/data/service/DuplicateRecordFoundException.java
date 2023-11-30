package com.rmspl.app.data.service;

public class DuplicateRecordFoundException extends Exception {
	
	/**
	 * Default Serial version
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateRecordFoundException() { }

    public DuplicateRecordFoundException(String message) {
        super(message);
    }

    public DuplicateRecordFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
