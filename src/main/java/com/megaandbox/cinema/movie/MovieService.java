package com.megaandbox.cinema.movie;

import com.megaandbox.cinema.exception.CustomException;
import com.megaandbox.cinema.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {
    public MovieDto getMovie(Long movieId) {
        if (movieId == null) {
            throw new CustomException(ErrorCode.MOVIE_NOT_FOUND);
        }
        else if (movieId == 1) {
            return new MovieDto(1, "에바니 노리나사이", 4);
        }
        else {
            throw new CustomException(ErrorCode.MOVIE_NOT_FOUND);
        }
    }
}
