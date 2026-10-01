package com.megaandbox.cinema.movie;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private long movieId;
    private String title;
    private int rating;
}
