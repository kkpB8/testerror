package com.devglan.exception;

//@ResponseStatus(value= HttpStatus.NO_CONTENT, reason="User with given state Not Found") //204
public class DatabaseOperationError extends RuntimeException {

    public DatabaseOperationError(String id) {
        super(id);
    }

}
