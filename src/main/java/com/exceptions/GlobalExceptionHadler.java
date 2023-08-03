package com.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHadler  {
	
	
	 @ExceptionHandler(MethodArgumentNotValidException.class) //for handling validation errors
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {				 
	       Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach((error) ->{
	            String fieldName = ((FieldError)error).getField();
	            String message = error.getDefaultMessage(); 
	            errors.put(fieldName, message);     
	           
	            
	        });

	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
	 
	 
		/*
		 * @ExceptionHandler(DataIntegrityViolationException.class) public
		 * ResponseEntity<String>
		 * handleDuplicateEntryException(DataIntegrityViolationException ex) { String
		 * errorMessage = "email already in database"; return
		 * ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage); }
		 */
	 
	 @ExceptionHandler(DuplicateEntryException.class)
	    public ResponseEntity<ErrorDetails> handleDuplicateEntryException(DuplicateEntryException ex, WebRequest webRequest) {
		 ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), webRequest.getDescription(false));
	                
	        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	    }
	 
	 
	 
	 
	 

}
