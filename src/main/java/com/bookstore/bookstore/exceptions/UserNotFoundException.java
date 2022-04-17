package com.bookstore.bookstore.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String username) {
        super(String.format("The user with username %s is not found.", username));
    }
}
