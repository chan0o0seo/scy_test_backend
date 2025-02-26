package com.example.scy_test_backend.common;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}