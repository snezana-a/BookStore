package com.bookstore.service;

import com.bookstore.enumerations.Category;
import com.bookstore.models.Book;

import java.util.List;

public interface BookService {

    List<Book> listAll();

    Book findById(Long id);

<<<<<<< HEAD
    Book create(Integer isbn, String title, String author, Integer year, Float price, String category, String image);

    Book update(Long id, Integer isbn, String title, String author, Integer year, Float price, String category, String image);
=======
    Book create(Integer isbn, String title, String author, Integer year, Float price, Category category);

    Book update(Long id, Integer isbn, String title, String author, Integer year, Float price, Category category);
>>>>>>> bb048bbe33bfdd41fe0e336a7c7c0adfa2e0faf9

    Book delete(Long id);

    List<Book> filter(String title, Integer year, Float price);

    List<Book> filterByCategory(Category category);
}
