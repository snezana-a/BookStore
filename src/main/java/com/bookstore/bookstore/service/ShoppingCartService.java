package com.bookstore.bookstore.service;

import com.bookstore.bookstore.models.Book;
import com.bookstore.bookstore.models.ShoppingCart;
import com.bookstore.bookstore.repository.ShoppingCartRepository;

import java.util.List;

public interface ShoppingCartService {

    List<Book> listAllBooksInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addBookToShoppingCart(String username, Long bookId);
}
