package com.karthiklogs.blog.payloads;

import java.util.Date;

public class ErrorDetails{
    private Date timestamp;
    private String message;
    private String desciption;

    public ErrorDetails(Date timestamp, String message, String desciption) {
        this.timestamp = timestamp;
        this.message = message;
        this.desciption = desciption;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
