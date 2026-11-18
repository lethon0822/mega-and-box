package com.megaandbox.cinema.user.repository;

import com.megaandbox.cinema.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
