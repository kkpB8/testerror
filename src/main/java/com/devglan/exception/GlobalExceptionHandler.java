package com.devglan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
class CustomGlobalExceptionHandler  {
 
  @ExceptionHandler(value = DatabaseOperationError.class)
  public ResponseEntity<String> BadRequest(DatabaseOperationError e) {
    String error = "";
   
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
