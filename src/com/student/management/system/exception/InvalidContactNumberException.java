package com.student.management.system.exception;

public class InvalidContactNumberException extends RuntimeException{
    public InvalidContactNumberException(String message) {
        super(message);
    }
}
