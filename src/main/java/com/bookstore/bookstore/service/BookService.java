package com.bookstore.bookstore.service;

import com.bookstore.bookstore.models.Book;

import java.util.List;

public interface BookService {

    List<Book> listAll();

    Book findById(Long id);

    Book create(Integer isbn, String title, String author, Integer year, Float price);

    Book update(Long id, Integer isbn, String title, String author, Integer year, Float price);

    Book delete(Long id);

    List<Book> filter(String title, Integer year, Float price);
}
