package com.karthiklogs.blog.exceptions;

import org.springframework.http.HttpStatus;

public class BlogApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public BlogApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public BlogApiException(String customMessage, String message, HttpStatus status, String message1) {
        super(customMessage);
        this.status = status;
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
