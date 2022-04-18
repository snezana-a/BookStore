package com.bookstore.service;

import com.bookstore.models.User;

public interface AuthService {

    User login(String username, String password);
}
