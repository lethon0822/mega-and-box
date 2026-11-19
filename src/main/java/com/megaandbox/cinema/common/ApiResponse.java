package com.megaandbox.cinema.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
public class ApiResponse<T> {

    @Builder.Default
    @Schema(description = "응답 시간")
    private final LocalDateTime timestamp = LocalDateTime.now();

    @Schema(description = "응답 코드", example = "SUCCESS_001")
    private final String code;

    @Schema(description = "응답 메시지", example = "요청이 정상적으로 처리되었습니다.")
    private final String message;

    @Schema(description = "응답 데이터")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    // 데이터가 없는 단순 성공 응답 (예: 삭제, 기본 200 OK)
    public static ResponseEntity<ApiResponse<Void>> success(SuccessCode successCode) {
        return ResponseEntity
                .status(successCode.getHttpStatus())
                .body(ApiResponse.<Void>builder()
                        .code(successCode.getCode())
                        .message(successCode.getMessage())
                        .build());
    }

    // 데이터를 함께 반환하는 성공 응답
    public static <T> ResponseEntity<ApiResponse<T>> success(SuccessCode successCode, T data) {
        return ResponseEntity
                .status(successCode.getHttpStatus())
                .body(ApiResponse.<T>builder()
                        .code(successCode.getCode())
                        .message(successCode.getMessage())
                        .data(data)
                        .build());
    }
}
