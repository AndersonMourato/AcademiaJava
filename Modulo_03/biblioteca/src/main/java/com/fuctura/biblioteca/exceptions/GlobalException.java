package com.fuctura.biblioteca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ObjectNotFoundExeption.class)
    public ResponseEntity<StandardError> objectNotFoundExeption(ObjectNotFoundExeption err, HttpServletRequest request){
        StandardError se = new StandardError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                err.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException err, HttpServletRequest request){
        StandardError se = new StandardError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                err.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException err, HttpServletRequest request){
        StandardError se = new StandardError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                err.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

}
