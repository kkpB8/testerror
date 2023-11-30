package com.rmspl.app.data.service;

public class ApkVersionMismatchException extends Exception {
	
	/**
	 * Default Serial version
	 */
	private static final long serialVersionUID = 1L;

	public ApkVersionMismatchException() { }

    public ApkVersionMismatchException(String message) {
        super(message);
    }

    public ApkVersionMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
