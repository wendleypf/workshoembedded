package com.embedded.workshop.exception;

import org.springframework.http.HttpStatus;

public class ResponseError {
    private HttpStatus status;
    private Integer status_value;
    private String message;

    public ResponseError(HttpStatus status, String message) {
        this.status = status;
        this.status_value = status.value();
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Integer getStatus_value() {
        return status_value;
    }

    public void setStatus_value(Integer status_value) {
        this.status_value = status_value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
