package com.bookstore.service.impl;

import com.bookstore.exceptions.InvalidArgumentsException;
import com.bookstore.exceptions.InvalidUserCredentialsException;
import com.bookstore.models.User;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.AuthService;
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
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }

}
