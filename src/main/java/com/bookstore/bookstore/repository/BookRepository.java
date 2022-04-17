package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    List<Book> findByPrice(Float price);

    List<Book> findByYear(Integer year);
}
