package com.bookstore.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException{
    public InvalidUsernameOrPasswordException() {
        super(String.format("Invalid"));
    }
}
