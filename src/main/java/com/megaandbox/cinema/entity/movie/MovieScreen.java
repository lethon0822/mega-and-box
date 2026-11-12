package com.megaandbox.cinema.entity.movie;

import com.megaandbox.cinema.entity.code.ScreeningType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MovieScreen {

    @EmbeddedId
    private MovieScreenIds movieScreenIds;

    @MapsId("movieId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name ="movie_id")
    private Movie movie;

    @MapsId("screeningTypeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name ="screening_type_id")
    private ScreeningType screeningType;
}
