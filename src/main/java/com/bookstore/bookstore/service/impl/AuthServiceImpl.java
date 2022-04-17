package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.exceptions.InvalidArgumentsException;
import com.bookstore.bookstore.exceptions.InvalidUserCredentialsException;
import com.bookstore.bookstore.models.User;
import com.bookstore.bookstore.repository.UserRepository;
import com.bookstore.bookstore.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

}
