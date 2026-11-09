package com.megaandbox.cinema.entity.movie;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MovieScreenIds implements Serializable {

    private Long movieId;

    private Integer screeningTypeId;
}
