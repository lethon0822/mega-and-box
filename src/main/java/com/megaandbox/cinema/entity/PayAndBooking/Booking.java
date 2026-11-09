package com.megaandbox.cinema.entity.PayAndBooking;


import com.megaandbox.cinema.entity.movie.MovieSchedule;
import com.megaandbox.cinema.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private UnUser unUser;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private MovieSchedule movieSchedule;

    @Column(nullable = false, unique = true, length = 16)
    private String tkNum;

    @Column(nullable = false, length = 20)
    private String movieTitle;

    @Column(nullable = false, length = 20)
    private String theaterName;

    @Column(nullable = false, length = 10)
    private String auditoriumName;

    @Column(nullable = false)
    private Integer finalPrice;

    @Column(nullable = false)
    private LocalDate paymentDate;

    @Column
    private LocalDateTime printedAt;

    @Column
    private Integer rewardPoint;

    @Column
    private LocalDateTime pointIssuedAt;

    @Column(nullable = false)
    private Boolean reStatus;
}

