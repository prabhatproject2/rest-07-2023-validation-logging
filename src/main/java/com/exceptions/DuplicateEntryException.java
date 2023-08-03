package com.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class DuplicateEntryException  extends RuntimeException{
   
	
	 public DuplicateEntryException(String msg) {
	        super(msg);
		 
		
	    }
	 
	 

}
