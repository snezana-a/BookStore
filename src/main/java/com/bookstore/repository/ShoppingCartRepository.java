package com.bookstore.repository;

import com.bookstore.models.ShoppingCart;
import com.bookstore.models.User;
import com.bookstore.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus created);
}
