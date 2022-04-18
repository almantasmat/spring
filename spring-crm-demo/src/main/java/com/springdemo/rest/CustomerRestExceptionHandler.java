package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
//    add Exception for customer not found exception
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception){
//        create customer error response
        CustomerErrorResponse error = new CustomerErrorResponse(
                HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
//        return response entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
//    add another Exception to catch any exception
    @ExceptionHandler
    public  ResponseEntity<CustomerErrorResponse> handleException(Exception exception){
        CustomerErrorResponse error = new CustomerErrorResponse(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
