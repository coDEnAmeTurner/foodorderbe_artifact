package com.foodorderbe.foodorderbe_artifact.exceptions;

import java.util.NoSuchElementException;

public class OrderNotFoundException extends NoSuchElementException{
    public OrderNotFoundException(String message) {
        super(message);
    }
}
