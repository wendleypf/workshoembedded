package com.embedded.workshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EventException.class)
    public ResponseEntity<ResponseError> handleException(EventException e) {
        return new ResponseEntity<>(
                new ResponseError(e.getStatus(), e.getMessage()),
                e.getStatus());
    }
}
