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
@NoArgsConstructor
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String engTitle;

    @Column(nullable = false, precision = 3, scale = 1)
    private double score;

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


    private Integer ageRating;


    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumMovieStatus movieStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Integer movieLike;

    @Column(nullable = false)
    private Boolean isExclusive;

    @Column(nullable = false, precision = 10, scale = 1)
    private double reservationRate;

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