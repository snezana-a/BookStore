package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.models.ShoppingCart;
import com.bookstore.bookstore.models.User;
import com.bookstore.bookstore.models.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus created);
}
