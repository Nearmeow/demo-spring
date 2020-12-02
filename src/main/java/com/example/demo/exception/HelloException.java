package com.example.demo.exception;

public class HelloException extends Exception {

    private String message;

    public HelloException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
