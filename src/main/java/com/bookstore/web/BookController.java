package com.bookstore.web;

import com.bookstore.models.Book;
import com.bookstore.service.BookService;
import com.bookstore.service.ShoppingCartService;
import com.bookstore.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public BookController(BookService bookService, ShoppingCartService shoppingCartService, UserService userService) {
        this.bookService = bookService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Book> books = this.bookService.listAll();
        model.addAttribute("books", books);
        model.addAttribute("bodyContent", "books");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.bookService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        if (this.bookService.findById(id) !=null) {
            Book book = this.bookService.findById(id);
            model.addAttribute("book", book);
            model.addAttribute("bodyContent", "add-book");
            return "master-template";
        }
        return "redirect:/books?error=BookNotFound";
    }

    @GetMapping("/add-form")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addProductPage(Model model) {
        model.addAttribute("bodyContent", "add-book");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Long id,
            @RequestParam Integer isbn,
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam Integer year,
            @RequestParam Float price) {
        if (id != null) {
            this.bookService.update(id, isbn, title, author,  year,  price);
        } else {
            this.bookService.create(isbn, title, author,  year,  price);
        }
        return "redirect:/books";
    }
}
