package ru.skypro.lessons.springboot.weblibrary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        return new ResponseEntity<>(employeeNotFoundException,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<?> handleIOException(IOException ioException){
        return new ResponseEntity<>(ioException,HttpStatus.NOT_FOUND);
    }
}
