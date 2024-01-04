package com.example.shopee_security.repository;

import com.example.shopee_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findUsersByUsername(String username) ;
}
