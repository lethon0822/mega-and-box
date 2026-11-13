package com.megaandbox.cinema.entity.movie;

import com.megaandbox.cinema.configuration.enumCode.model.movie.EnumScreeningPeriod;
import com.megaandbox.cinema.entity.UpdatedAt;
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
public class MovieSchedule extends UpdatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long msId;

    @ManyToOne
    @JoinColumn(nullable = false ,name ="movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(nullable = false ,name ="screening_type_id")
    private ScreeningType screeningType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name ="auditorium_id")
    private Auditorium auditorium;

    @Column(nullable = false)
    private LocalDate showDate;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false, length = 10)
    private EnumScreeningPeriod screeningPeriod;

    @Column(nullable = false)
    private Integer round;

    @Column(nullable = false)
    private Integer leftSeats;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean stageCheck;
}
