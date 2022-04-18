package com.bookstore.exceptions;

public class ShoppingCartNotFoundException extends RuntimeException{
    public ShoppingCartNotFoundException(Long id) {
        super(String.format("The Shopping cart with id %d does not exist", id));
    }
}
