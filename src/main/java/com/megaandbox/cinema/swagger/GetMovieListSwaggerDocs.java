package com.megaandbox.cinema.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.ErrorResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(
        // 해당 API 요약, 설명
        summary = "영화 목록 조회",
        description = "현재 상영 중이거나 개봉 예정인 영화 목록을 페이징 및 정렬 조건에 맞춰 조회합니다."
)
@ApiResponses({
        // 성공 메세지 + res 답변
        @ApiResponse(
                responseCode = "200",
                description = "영화 목록 조회 성공",
                content = @Content(
                        mediaType = "application/json",
                        examples = @ExampleObject(
                                name = "SuccessResponse",
                                value = """
                                {
                                  "timestamp": "2026-10-01T15:00:00",
                                  "code": "PAY_005",
                                  "message": "예매가 성공적으로 완료되었습니다.",
                                  "data": {
                                    "content": [
                                      {
                                        "movieId": 1,
                                        "title": "듄: 파트 3",
                                        "posterUrl": "https://example.com/poster1.jpg",
                                        "releaseDate": "2026-10-15",
                                        "reservationRate": 34.5,
                                        "rating": "RATE_15"
                                      }
                                    ],
                                    "page": 0,
                                    "size": 10,
                                    "totalElements": 1,
                                    "totalPages": 1
                                  }
                                }
                                """
                        )
                )
        ),
        // 이 아래로는 발생할 수 있는 에러에 관해서 작성
        @ApiResponse(
                responseCode = "400",
                description = "잘못된 요청 파라미터 (정렬 기준 또는 상태값 오류)",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponse.class),
                        examples = @ExampleObject(
                                name = "InvalidInputResponse",
                                value = """
                                {
                                  "timestamp": "2026-10-01T15:00:00",
                                  "code": "COMMON_001",
                                  "message": "적절하지 않은 요청 값입니다.",
                                  "errors": []
                                }
                                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "500",
                description = "서버 내부 오류",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponse.class),
                        examples = @ExampleObject(
                                name = "ServerErrorResponse",
                                value = """
                                {
                                  "timestamp": "2026-10-01T15:00:00",
                                  "code": "COMMON_003",
                                  "message": "서버 내부 오류가 발생했습니다.",
                                  "errors": []
                                }
                                """
                        )
                )
        )
})
public @interface GetMovieListSwaggerDocs {
}