package com.megaandbox.cinema.entity.movie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StageGreeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sgId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_schedule_id", nullable = false)
    private MovieSchedule movieSchedule;

    @Column(nullable = false, length = 10)
    private String sgType;

    @Column(nullable = false)
    private Integer sgExtraPrice;

    @Column(nullable = false, length = 100)
    private String sgActor;
}
