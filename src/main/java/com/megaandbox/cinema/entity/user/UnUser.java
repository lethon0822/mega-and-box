package com.megaandbox.cinema.entity.user;


import com.megaandbox.cinema.entity.CreatedAt;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnUser extends CreatedAt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unuserId;

    @Column(nullable = false, length = 20)
    private String unuserName;

    @Column(nullable = false, length = 20)
    private String unuserPhone;

    @Column(nullable = false, length = 10)
    private String unuserBirth;

    @Column(nullable = false, length = 20)
    private String password;


}
