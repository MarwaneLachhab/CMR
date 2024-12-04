package com.cmr.IMADWRGH.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorDetails> ResourceNotFoundException(ResourceNotFoundException msg) {
	        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND, msg.getMessage());
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

}
