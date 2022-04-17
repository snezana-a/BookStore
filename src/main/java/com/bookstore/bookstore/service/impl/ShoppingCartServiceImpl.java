package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.exceptions.BookAlreadyInShoppingCartException;
import com.bookstore.bookstore.exceptions.BookNotFoundException;
import com.bookstore.bookstore.exceptions.ShoppingCartNotFoundException;
import com.bookstore.bookstore.exceptions.UserNotFoundException;
import com.bookstore.bookstore.models.Book;
import com.bookstore.bookstore.models.ShoppingCart;
import com.bookstore.bookstore.models.User;
import com.bookstore.bookstore.models.enumerations.ShoppingCartStatus;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.repository.ShoppingCartRepository;
import com.bookstore.bookstore.repository.UserRepository;
import com.bookstore.bookstore.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Book> listAllBooksInShoppingCart(Long cartId) {
        if(!this.shoppingCartRepository.findById(cartId).isPresent())
            throw new ShoppingCartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getBooks();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        return this.shoppingCartRepository
                .findByUserAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    @Override
    public ShoppingCart addBookToShoppingCart(String username, Long bookId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Book book = this.bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        if(shoppingCart.getBooks()
                .stream().filter(i -> i.getId().equals(bookId))
                .collect(Collectors.toList()).size() > 0)
            throw new BookAlreadyInShoppingCartException(bookId, username);
        shoppingCart.getBooks().add(book);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
