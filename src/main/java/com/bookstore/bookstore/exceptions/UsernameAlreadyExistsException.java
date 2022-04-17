package com.bookstore.bookstore.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String username) {
        super(String.format("Username Exists"));
    }
}
