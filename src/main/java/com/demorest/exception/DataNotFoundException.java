package com.demorest.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String message) {
        super(message);
    }

}
