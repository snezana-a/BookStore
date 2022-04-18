package com.bookstore.service;

import com.bookstore.models.Book;
import com.bookstore.models.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Book> listAllBooksInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addBookToShoppingCart(String username, Long bookId);
}
