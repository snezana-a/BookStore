package com.bookstore.service;

import com.bookstore.enumerations.Category;
import com.bookstore.models.Book;

import java.util.List;

public interface BookService {

    List<Book> listAll();

    Book findById(Long id);

    Book create(Integer isbn, String title, String author, Integer year, Float price, Category category, String image);

    Book update(Long id, Integer isbn, String title, String author, Integer year, Float price, Category category, String image);

    Book delete(Long id);

    List<Book> filterByCategory(Category category);
}
