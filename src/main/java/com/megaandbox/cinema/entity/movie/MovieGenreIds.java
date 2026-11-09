package com.megaandbox.cinema.entity.movie;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MovieGenreIds implements Serializable {

    private Long movieId;

    private Long genreId;
}
