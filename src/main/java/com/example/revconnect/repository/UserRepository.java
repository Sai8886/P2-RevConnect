package com.example.revconnect.repository;

import com.example.revconnect.entity.User;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUserName(String userName);

    // Search  //partial match
    List<User> findByUserNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String userName, String email);
    
}