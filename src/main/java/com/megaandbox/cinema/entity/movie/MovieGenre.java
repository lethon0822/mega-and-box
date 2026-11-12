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
public class MovieGenre {

    @EmbeddedId
    private MovieGenreIds id;

    @MapsId("movieId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @MapsId("genreId")
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
