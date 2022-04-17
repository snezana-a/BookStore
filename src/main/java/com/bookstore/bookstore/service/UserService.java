package com.bookstore.bookstore.service;

import com.bookstore.bookstore.models.User;
import com.bookstore.bookstore.models.enumerations.Role;

public interface UserService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role userRole);
}
