package com.megaandbox.cinema.entity.movie;

import com.megaandbox.cinema.configuration.enumCode.model.EnumMovieStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@Getter
@AllArgsConstructor
//@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;

    private String engTitle;

    private double score;

    private Long audienceCount;

    private String image;

    private String preview;

    private String synopsis;

    private String director;

    private String actor;

    private Integer runningTime;

    private Integer ageRating;

    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private EnumMovieStatus movieStatus;

    private LocalDateTime createdAt;

    private Integer movieLike;

    private Boolean isExclusive;

    private double reservationRate;

    // 영화 - 장르 연결
    @Builder.Default
    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> movieGenres = new ArrayList<>();

    // 영화 - 스틸컷
    @OneToMany(
            mappedBy = "movie",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<StillCut> stillCuts = new ArrayList<>();
}
