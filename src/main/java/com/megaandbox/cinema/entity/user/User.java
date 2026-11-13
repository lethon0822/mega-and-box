package com.megaandbox.cinema.entity.user;


import com.megaandbox.cinema.configuration.enumCode.model.user.EnumUserGrade;
import com.megaandbox.cinema.configuration.enumCode.model.user.EnumUserStatus;
import com.megaandbox.cinema.entity.CreatedAt;
import com.megaandbox.cinema.entity.UpdatedAt;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.sql.Update;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User extends UpdatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 30, nullable = false, unique = true)
    private String email;

    @Column(length = 30, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false, length = 10)
    private LocalDate birth;

    @Column(nullable = false)
    private boolean gender;

    @Column(length = 20, nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private EnumUserStatus userStatus;

    @Column(nullable = false)
    private Long point;

    @Column(nullable = false, length = 20)
    private EnumUserGrade grade;

    @Column(length = 200)
    private String profile;

    @Column(nullable = false)
    private LocalDate pwUpdatedAt;
}