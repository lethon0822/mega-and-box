package com.megaandbox.cinema.entity.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 125, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    private int gender;

    @Column(length = 20, nullable = false, unique = true)
    private String phone;

    // Enum으로 처리할지 고민
    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private long point;

    @Column(length = 200)
    private String profile;

    @Column(length = 20)
    private String cardNumber;

    @Column(length = 200)
    private String cardPassword;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private LocalDate pwUpdatedAt;
}