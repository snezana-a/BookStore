package com.bookstore.models;

import com.bookstore.enumerations.Category;
import com.bookstore.enumerations.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Integer isbn;

    private String title;

    private String author;

    private Integer year;

    private Float price;

<<<<<<< HEAD
    private String category;

    private String image;



    public Book(Integer isbn, String title, String author, Integer year, Float price, String category, String image) {
=======
    @Enumerated(value = EnumType.STRING)
    private Category category;

    public Book(Integer isbn, String title, String author, Integer year, Float price, Category category) {
>>>>>>> bb048bbe33bfdd41fe0e336a7c7c0adfa2e0faf9
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.category = category;
<<<<<<< HEAD
        this.image = image;
=======
>>>>>>> bb048bbe33bfdd41fe0e336a7c7c0adfa2e0faf9
    }

    public Book() {
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
