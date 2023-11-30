package com.rmspl.app.data.service;

public class NoRecordFoundException extends Exception {
	
	public NoRecordFoundException() { }

    public NoRecordFoundException(String message) {
        super(message);
    }

    public NoRecordFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
