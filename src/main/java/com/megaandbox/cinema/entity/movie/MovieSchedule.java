package com.megaandbox.cinema.entity.movie;

import com.megaandbox.cinema.entity.code.Auditorium;
import com.megaandbox.cinema.entity.code.ScreeningType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MovieSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long msId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private ScreeningType screeningType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Auditorium auditorium;

    @Column(nullable = false)
    private LocalDate showDate;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false, length = 10)
    private String screeningPeriod;

    @Column(nullable = false)
    private Integer round;

    @Column(nullable = false)
    private Integer leftSeats;

    @Column(nullable = false)
    private Boolean stageCheck;
}
