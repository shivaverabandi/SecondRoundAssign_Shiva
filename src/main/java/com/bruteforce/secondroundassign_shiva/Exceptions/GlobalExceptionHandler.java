package com.bruteforce.secondroundassign_shiva.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductAlreadyExists.class)
    public ResponseEntity<Error> productAlreadyExists(ProductAlreadyExists e){
        Error error = new Error(LocalDateTime.now() ,e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ProductNotExists.class)
    public ResponseEntity<Error> productNotExists(ProductNotExists e){
        Error error = new Error(LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GtinAleardyExists.class)
    public ResponseEntity<Error> gtinAlreadyExists(GtinAleardyExists e){
        Error error = new Error(LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(GtinNotExists.class)
    public ResponseEntity<Error> gtinAlreadyExists(GtinNotExists e){
        Error error = new Error(LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(BatchAlreadyExists.class)
    public ResponseEntity<Error> batchAlreadyExists(BatchAlreadyExists e){
        Error error = new Error(LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(BatchNotFoundException.class)
    public ResponseEntity<Error> batchNotFoundExc(BatchNotFoundException e){
        Error error = new Error(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)

    public ResponseEntity<Error> generalException(Exception e){
        Error error = new Error(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
