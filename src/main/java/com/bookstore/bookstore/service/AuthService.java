package com.bookstore.bookstore.service;

import com.bookstore.bookstore.models.User;

public interface AuthService {

    User login(String username, String password);
}
