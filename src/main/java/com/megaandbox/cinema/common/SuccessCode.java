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
    AUTH_SIGNUP_SUCCESS(HttpStatus.CREATED, "AUTH_100", "회원가입이 완료되었습니다."),
    AUTH_LOGIN_SUCCESS(HttpStatus.OK, "AUTH_110", "로그인에 성공했습니다."),
    AUTH_SOCIAL_LOGIN_SUCCESS(HttpStatus.OK, "AUTH_111", "소셜 로그인에 성공했습니다."),
    AUTH_LOGOUT_SUCCESS(HttpStatus.OK, "AUTH_112", "로그아웃되었습니다."),
    AUTH_NAVER_CONNECT_SUCCESS(HttpStatus.OK, "AUTH_120", "네이버 계정이 연동되었습니다."),
    AUTH_KAKAO_CONNECT_SUCCESS(HttpStatus.OK, "AUTH_121", "카카오 계정이 연동되었습니다."),
    AUTH_PASSWORD_VERIFY_SUCCESS(HttpStatus.OK, "AUTH_130", "비밀번호 인증에 성공했습니다."),
    AUTH_PASSWORD_CHANGE_SUCCESS(HttpStatus.OK, "AUTH_300", "비밀번호가 성공적으로 변경되었습니다."),
    AUTH_WITHDRAW_SUCCESS(HttpStatus.OK, "AUTH_140", "회원 탈퇴가 정상적으로 처리되었습니다."),

    USER_MYPAGE_GET_SUCCESS(HttpStatus.OK, "USER_200", "개인정보 조회가 완료되었습니다."),
    USER_MYPAGE_UPDATE_SUCCESS(HttpStatus.OK, "USER_500", "개인정보가 성공적으로 변경되었습니다."),
    USER_PAYMENT_METHOD_CREATE_SUCCESS(HttpStatus.CREATED, "USER_150", "결제수단이 성공적으로 등록되었습니다."),
    USER_PAYMENT_METHOD_GET_SUCCESS(HttpStatus.OK, "USER_250", "결제수단 조회가 완료되었습니다."),
    USER_PAYMENT_METHOD_UPDATE_SUCCESS(HttpStatus.OK, "USER_350", "결제수단이 성공적으로 수정되었습니다."),
    USER_PAYMENT_METHOD_DELETE_SUCCESS(HttpStatus.OK, "USER_750", "결제수단이 삭제되었습니다."),

    // Movie & review
    MOVIE_LIST_GET_SUCCESS(HttpStatus.OK, "MOV_201", "영화 목록 조회에 성공했습니다."),
    MOVIE_NOW_LIST_GET_SUCCESS(HttpStatus.OK, "MOV_202", "현재 상영중인 영화 목록 조회에 성공했습니다."),
    MOVIE_SEARCH_SUCCESS(HttpStatus.OK, "MOV_220", "영화 검색이 완료되었습니다."),
    MOVIE_DETAIL_GET_SUCCESS(HttpStatus.OK, "MOV_231", "영화 상세 조회에 성공했습니다."),
    MOVIE_TRAILER_GET_SUCCESS(HttpStatus.OK, "MOV_232", "영화 스틸컷, 예고편 조회에 성공했습니다."),

    REVIEW_CREATE_SUCCESS(HttpStatus.CREATED, "REV_101", "리뷰 작성이 완료되었습니다."),
    REVIEW_GET_SUCCESS(HttpStatus.OK, "REV_201", "리뷰 조회가 완료되었습니다."),
    REVIEW_DELETE_SUCCESS(HttpStatus.OK, "REV_700", "리뷰가 삭제되었습니다."),
    REVIEW_REPORT_SUCCESS(HttpStatus.OK, "REV_102", "리뷰 신고가 접수되었습니다."),

    // theater & schedule
    THEATER_GET_SUCCESS(HttpStatus.OK, "THR_201", "극장 조회가 완료되었습니다."),
    THEATER_DETAIL_GET_SUCCESS(HttpStatus.OK, "THR_210", "극장 상세 조회가 완료되었습니다."),

    SCHEDULE_THEATER_TIMETABLE_SUCCESS(HttpStatus.OK, "SCH_100", "극장별 상영시간표 조회가 완료되었습니다."),
    SCHEDULE_THEATER_STAGE_GREETING_SUCCESS(HttpStatus.OK, "SCH_101", "극장별 무대인사일정 조회가 완료되었습니다."),
    SCHEDULE_MOVIE_TIMETABLE_SUCCESS(HttpStatus.OK, "SCH_120", "영화별 상영시간표 조회가 완료되었습니다."),
    SCHEDULE_MOVIE_STAGE_GREETING_SUCCESS(HttpStatus.OK, "SCH_121", "영화별 무대인사일정 조회가 완료되었습니다."),
    SCHEDULE_QUICK_BOOKING_FILTER_SUCCESS(HttpStatus.OK, "SCH_200", "빠른 예매 필터 조회가 완료되었습니다."),
    SCHEDULE_QUICK_BOOKING_SUCCESS(HttpStatus.OK, "SCH_220", "빠른 예매 정보 조회가 완료되었습니다."),

    // booking
    BOOKING_SEAT_GET_SUCCESS(HttpStatus.OK, "BKG_100", "좌석 조회가 완료되었습니다."),
    BOOKING_TICKET_PRICE_GET_SUCCESS(HttpStatus.OK, "BKG_120", "티켓값 조회가 완료되었습니다."),
    BOOKING_SEAT_SELECT_SUCCESS(HttpStatus.OK, "BKG_200", "좌석 선택이 완료되었습니다."),

    // pay
    PAYMENT_BENEFIT_GET_SUCCESS(HttpStatus.OK, "PAY_001", "쿠폰 및 포인트 조회가 완료되었습니다."),
    PAYMENT_NAVER_REDIRECT_SUCCESS(HttpStatus.OK, "PAY_003", "네이버 페이 결제 페이지로 이동합니다."),
    PAYMENT_KAKAO_REDIRECT_SUCCESS(HttpStatus.OK, "PAY_004", "카카오 페이 결제 페이지로 이동합니다."),
    PAYMENT_COMPLETE_SUCCESS(HttpStatus.OK, "PAY_005", "결제가 최종 완료되었습니다."),
    PAYMENT_CANCEL_SUCCESS(HttpStatus.OK, "PAY_006", "결제 취소(환불)가 정상적으로 처리되었습니다."),
    PAYMENT_MEMBERSHIP_SUCCESS(HttpStatus.OK, "PAY_101", "멤버십 결제가 완료되었습니다."),
    PAYMENT_STORE_SUCCESS(HttpStatus.OK, "PAY_102", "스토어 결제가 완료되었습니다."),
    PAYMENT_BOOKING_SUCCESS(HttpStatus.OK, "PAY_103", "예매 결제가 완료되었습니다."),

    // membership
    MEMBERSHIP_JOIN_SUCCESS(HttpStatus.CREATED, "MEM_101", "멤버십 가입이 완료되었습니다."),
    MEMBERSHIP_CANCEL_SUCCESS(HttpStatus.OK, "MEM_103", "멤버십 해지가 완료되었습니다."),
    MEMBERSHIP_GET_SUCCESS(HttpStatus.OK, "MEM_201", "멤버십 조회가 완료되었습니다."),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
