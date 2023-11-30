package com.rmspl.app.data.service;

public class JsonParseException extends Exception {
	
	public JsonParseException() { }

    public JsonParseException(String message) {
        super(message);
    }

    public JsonParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
