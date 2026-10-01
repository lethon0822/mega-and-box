package com.megaandbox.cinema.movie;

import com.megaandbox.cinema.common.ApiResponse;
import com.megaandbox.cinema.common.SuccessCode;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
@Tag(name = "영화", description = "영화 관련 API 입니다.")
public class MovieController {

    private final MovieService movieService;

    // 1. 데이터 반환 (조회)
    @GetMapping("/{movieId}")
    public ResponseEntity<ApiResponse<MovieDto>> getMovieDetail(@PathVariable Long movieId) {
        MovieDto response = movieService.getMovie(movieId);
        return ApiResponse.success(SuccessCode.OK, response);
    }

}