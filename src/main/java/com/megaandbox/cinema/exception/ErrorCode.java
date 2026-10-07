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
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON_004", "요청한 리소스를 찾을 수 없습니다."),

    // User & Auth
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "AUTH_001", "존재하지 않는 사용자입니다."),
    DUPLICATE_EMAIL(HttpStatus.CONFLICT, "AUTH_002", "이미 사용 중인 이메일 계정입니다."),
    PASSWORD_MISMATCH(HttpStatus.BAD_REQUEST, "AUTH_003", "비밀번호가 일치하지 않습니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "AUTH_004", "인증 자격 증명이 유효하지 않습니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "AUTH_005", "접근 권한이 없습니다."),
    SOCIAL_ACCOUNT_ALREADY_LINKED(HttpStatus.CONFLICT, "AUTH_006", "이미 다른 계정에 연동된 소셜 계정입니다."),
    SOCIAL_ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "AUTH_007", "연동된 소셜 계정 정보를 찾을 수 없습니다."),

    PAYMENT_METHOD_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_001", "등록된 결제수단을 찾을 수 없습니다."),
    PAYMENT_METHOD_LIMIT_EXCEEDED(HttpStatus.BAD_REQUEST, "USER_002", "등록 가능한 결제수단 최대 개수를 초과했습니다."),

    // Movie & review
    MOVIE_NOT_FOUND(HttpStatus.NOT_FOUND, "MOV_001", "해당 영화 정보를 찾을 수 없습니다."),
    INVALID_MOVIE_STATUS(HttpStatus.BAD_REQUEST, "MOV_002", "유효하지 않은 상영 상태값입니다."),

    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REV_001", "존재하지 않는 리뷰입니다."),
    REVIEW_NOT_OWNER(HttpStatus.FORBIDDEN, "REV_002", "본인이 작성한 리뷰만 수정 또는 삭제할 수 있습니다."),
    ALREADY_REVIEWED(HttpStatus.CONFLICT, "REV_003", "이미 해당 영화에 작성한 리뷰가 있습니다."),
    ALREADY_REPORTED_REVIEW(HttpStatus.CONFLICT, "REV_004", "이미 신고 접수된 리뷰입니다."),

    // theater & booking
    THEATER_NOT_FOUND(HttpStatus.NOT_FOUND, "THR_001", "존재하지 않는 극장입니다."),
    SCREEN_NOT_FOUND(HttpStatus.NOT_FOUND, "THR_002", "상영관 정보를 찾을 수 없습니다."),
    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "SCH_001", "상영 일정을 찾을 수 없습니다."),
    SCHEDULE_ALREADY_STARTED(HttpStatus.BAD_REQUEST, "SCH_002", "이미 상영이 시작되었거나 종료된 일정입니다."),

    SEAT_NOT_FOUND(HttpStatus.NOT_FOUND, "BKG_001", "선택한 좌석 정보를 찾을 수 없습니다."),
    SEAT_ALREADY_RESERVED(HttpStatus.CONFLICT, "BKG_002", "이미 예매된 좌석입니다."),
    EXCEED_MAX_TICKET_COUNT(HttpStatus.BAD_REQUEST, "BKG_003", "1회 최대 예매 가능 인원을 초과했습니다."),
    BOOKING_NOT_FOUND(HttpStatus.NOT_FOUND, "BKG_004", "예매 내역을 찾을 수 없습니다."),

    // pay
    INSUFFICIENT_POINT(HttpStatus.BAD_REQUEST, "PAY_001", "보유 포인트가 부족합니다."),
    COUPON_NOT_FOUND(HttpStatus.NOT_FOUND, "PAY_002", "유효한 쿠폰을 찾을 수 없습니다."),
    COUPON_ALREADY_USED(HttpStatus.BAD_REQUEST, "PAY_003", "이미 사용된 쿠폰입니다."),
    COUPON_EXPIRED(HttpStatus.BAD_REQUEST, "PAY_004", "사용 기간이 만료된 쿠폰입니다."),
    PAYMENT_FAILED(HttpStatus.BAD_REQUEST, "PAY_005", "결제 승인 처리에 실패했습니다."),
    PAYMENT_AMOUNT_MISMATCH(HttpStatus.BAD_REQUEST, "PAY_006", "결제 요청 금액과 실제 검증 금액이 일치하지 않습니다."),
    REFUND_NOT_ALLOWED(HttpStatus.BAD_REQUEST, "PAY_007", "상영 시작 시간 이후에는 결제 취소(환불)가 불가능합니다."),

    // membership
    MEMBERSHIP_ALREADY_JOINED(HttpStatus.CONFLICT, "MEM_001", "이미 가입된 멤버십이 존재합니다."),
    MEMBERSHIP_NOT_FOUND(HttpStatus.NOT_FOUND, "MEM_002", "가입된 멤버십 정보를 찾을 수 없습니다."),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}