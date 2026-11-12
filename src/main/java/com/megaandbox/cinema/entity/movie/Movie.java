package com.megaandbox.cinema.entity.movie;

import com.megaandbox.cinema.configuration.enumCode.model.movie.EnumAgeRating;
import com.megaandbox.cinema.configuration.enumCode.model.movie.EnumMovieStatus;
import com.megaandbox.cinema.entity.CreatedAt;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Movie extends CreatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String engTitle;

    @Column(nullable = false, precision = 3, scale = 1)
    private BigDecimal score;

    @Column(nullable = false)
    private Long audienceCount;

    @Column(nullable = false)
    private String image;

    // 영상 주소
    private String preview;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    @Column(length = 20)
    private String director;

    @Column(columnDefinition = "TEXT")
    private String actor;


    private Integer runningTime;


    private EnumAgeRating ageRating;


    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumMovieStatus movieStatus;

    @Column(nullable = false)
    private Integer movieLike;

    @Column(nullable = false)
    private Boolean isExclusive;

    @Column(nullable = false, precision = 10, scale = 1)
    private BigDecimal reservationRate;

    // 영화 - 장르 연결
    @Builder.Default
    @OneToMany(mappedBy = "movie",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<MovieGenre> movieGenres = new ArrayList<>();

    // 영화 - 스틸컷 연결
    @Builder.Default
    @OneToMany(
            mappedBy = "movie",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<StillCut> stillCuts = new ArrayList<>();
}