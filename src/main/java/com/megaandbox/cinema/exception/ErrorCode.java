package com.megaandbox.cinema.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "COMMON_001", "적절하지 않은 요청 값입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "COMMON_002", "지원하지 않는 HTTP 메서드입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_003", "서버 내부 오류가 발생했습니다."),

    // User & Auth
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_001", "사용자를 찾을 수 없습니다."),
    EMAIL_DUPLICATION(HttpStatus.CONFLICT, "USER_002", "이미 존재하는 이메일입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "AUTH_001", "인증 자격 증명이 유효하지 않습니다."),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "AUTH_002", "접근 권한이 없습니다."),

    // Movie & Reservation
    MOVIE_ERROR(HttpStatus.BAD_REQUEST, "MOVIE_001", "영화를 찾는 중 오류가 발생했습니다."),
    MOVIE_NOT_FOUND(HttpStatus.NOT_FOUND, "MOVIE_002", "영화가 존재하지 않습니다."),
    SEAT_ALREADY_RESERVED(HttpStatus.CONFLICT, "SEAT_001", "이미 예매된 좌석입니다."),
    PAYMENT_FAILED(HttpStatus.BAD_REQUEST, "PAY_001", "결제 처리에 실패했습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}