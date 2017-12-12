package com.embedded.workshop.exception;

import org.springframework.http.HttpStatus;

public class EventException extends Exception {
    private HttpStatus status;

    public EventException(String message) {
        super(message);
    }

    public EventException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public EventException(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
