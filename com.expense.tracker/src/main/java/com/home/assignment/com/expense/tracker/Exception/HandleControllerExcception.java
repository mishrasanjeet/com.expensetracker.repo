package com.home.assignment.com.expense.tracker.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleControllerExcception {

    @ExceptionHandler(ExpenseNotFoundException.class)
    public ResponseEntity<String> HandleusernotfoundException(ExpenseNotFoundException ex){
        return  new ResponseEntity <>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> HandleusernotfoundException(Exception ex){
        return  new ResponseEntity <>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
