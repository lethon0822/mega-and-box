package com.megaandbox.cinema.user.repository;

import com.megaandbox.cinema.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query("""
        SELECT u.password
        FROM User u 
        WHERE u.userId = :userId
    """)
    String findPasswordByUserId(Long userId);

    Optional<User> findByUserId(Long userId);
}
