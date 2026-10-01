package com.megaandbox.cinema.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
public class ApiResponse<T> {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private final String code;
    private final String message;

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
