package com.megaandbox.cinema.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessCode {

    // Common
    OK(HttpStatus.OK, "SUCCESS_001", "요청이 정상적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "SUCCESS_002", "리소스가 성공적으로 생성되었습니다."),

    // User & Auth
    SIGNUP_SUCCESS(HttpStatus.CREATED, "AUTH_100", "회원가입이 완료되었습니다."),
    LOGIN_SUCCESS(HttpStatus.OK, "AUTH_110", "로그인에 성공했습니다."),

    // Movie & Reservation
    RESERVATION_SUCCESS(HttpStatus.CREATED, "PAY_005", "예매가 성공적으로 완료되었습니다."),
    RESERVATION_CANCEL_SUCCESS(HttpStatus.OK, "PAY_006", "예매가 정상적으로 취소되었습니다."),


    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
