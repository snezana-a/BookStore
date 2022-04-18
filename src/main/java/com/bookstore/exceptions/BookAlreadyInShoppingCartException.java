package com.bookstore.exceptions;

public class BookAlreadyInShoppingCartException extends RuntimeException{
    public BookAlreadyInShoppingCartException(Long id, String username) {
        super(String.format("The book with id %d is already in %s's shopping cart", id, username));
    }
}
