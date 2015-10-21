package com.ebelli.mandsprobe.model;

/**
 * The message sent from the submitData call
 */

public class Message {
    private String Message;
    private int StatusCode;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Message='" + Message + '\'' +
                ", StatusCode=" + StatusCode +
                '}';
    }
}
