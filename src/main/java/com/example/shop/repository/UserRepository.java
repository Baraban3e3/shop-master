package com.example.shop.repository;

import com.example.shop.domein.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

@EnableAutoConfiguration
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
}
