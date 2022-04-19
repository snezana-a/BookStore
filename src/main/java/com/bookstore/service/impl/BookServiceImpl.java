package com.bookstore.service.impl;

import com.bookstore.enumerations.Category;
import com.bookstore.exceptions.BookNotFoundException;
import com.bookstore.models.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book create(Integer isbn, String title, String author, Integer year, Float price, Category category, String image) {
        return this.bookRepository.save(new Book(isbn, title, author, year, price, category, image));
    }

    @Override
    public Book update(Long id, Integer isbn, String title, String author, Integer year, Float price, Category category, String image) {
        Book book = this.findById(id);

        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        book.setPrice(price);
        book.setCategory(category);
        book.setImage(image);

        return this.bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = this.findById(id);
        this.bookRepository.delete(book);
        return book;
    }

    @Override
    public List<Book> filterByCategory(Category category) {
        return this.bookRepository.findByCategory(category);
    }
}
