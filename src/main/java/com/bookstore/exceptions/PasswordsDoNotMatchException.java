package com.bookstore.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super(String.format("Invalid password"));
    }
}
