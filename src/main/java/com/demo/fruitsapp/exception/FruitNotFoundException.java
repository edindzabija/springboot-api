package com.demo.fruitsapp.exception;

public class FruitNotFoundException extends RuntimeException {
    public FruitNotFoundException(String message) {
        super(message);
    }
}
