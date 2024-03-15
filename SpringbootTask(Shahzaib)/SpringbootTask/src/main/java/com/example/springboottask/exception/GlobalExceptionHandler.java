package com.example.springboottask.exception;

import com.example.springboottask.response.ResponseUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
    @ExceptionHandler(ResourseNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleAllUncaughtException(
            RuntimeException exception,
            WebRequest request) {
        return ResponseUtil.returnResponse(exception);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> handleAllUncaughtException(
            NumberFormatException exception,
            WebRequest request) {
        return ResponseUtil.returnResponse(exception);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleAllUncaughtException(
            NullPointerException exception,
            WebRequest request) {
        return ResponseUtil.returnResponse(exception);
    }

    /*@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleAllUncaughtException(Exception exception){
        return ResponseUtil.returnResponse(exception);
    }*/
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleAllUncaughtException(
            EntityNotFoundException exception,
            WebRequest request) {
        return ResponseUtil.returnResponse(exception);
    }
}
