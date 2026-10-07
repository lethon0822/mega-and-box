package com.megaandbox.cinema.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 비즈니스 로직 상 발생하는 도메인 예외 처리 (영화 없음, 잔여 좌석 부족, 포인트 부족 등)
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        ErrorCode errorCode = e.getErrorCode();
        log.warn("[BusinessException] Code: {}, Message: {}", errorCode.getCode(), e.getMessage());
        ErrorResponse response = ErrorResponse.of(errorCode, e.getMessage());
        return ResponseEntity.status(errorCode.getHttpStatus()).body(response);
    }

    /**
     * @Valid, @Validated 유효성 검사 실패 (@RequestBody DTO 검증 실패)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("[MethodArgumentNotValidException] Target: {}, Errors: {}",
                e.getObjectName(), e.getBindingResult().getFieldErrors().size());

        ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return ResponseEntity.status(ErrorCode.INVALID_INPUT_VALUE.getHttpStatus()).body(response);
    }

    /**
     * @ModelAttribute 바인딩 및 쿼리 파라미터 유효성 검사 실패
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.warn("[BindException] Target: {}, Errors: {}",
                e.getObjectName(), e.getBindingResult().getFieldErrors().size());

        ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return ResponseEntity.status(ErrorCode.INVALID_INPUT_VALUE.getHttpStatus()).body(response);
    }

    /**
     * 파라미터 타입 변환 실패 (예: 숫자 ID에 문자열이 들어온 경우)
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.warn("[MethodArgumentTypeMismatchException] Name: {}, Value: {}", e.getName(), e.getValue());

        String message = String.format("'%s' 파라미터의 값('%s')이 올바른 타입이 아닙니다.", e.getName(), e.getValue());
        ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, message);
        return ResponseEntity.status(ErrorCode.INVALID_INPUT_VALUE.getHttpStatus()).body(response);
    }

    /**
     * 필수 쿼리 파라미터(@RequestParam)가 누락된 경우
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.warn("[MissingServletRequestParameterException] Param: {}", e.getParameterName());

        String message = String.format("필수 파라미터 '%s'가 누락되었습니다.", e.getParameterName());
        ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, message);
        return ResponseEntity.status(ErrorCode.INVALID_INPUT_VALUE.getHttpStatus()).body(response);
    }

    /**
     * HTTP Request Body JSON 형식이 잘못되었거나 파싱할 수 없는 경우
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.warn("[HttpMessageNotReadableException] {}", e.getMessage());

        ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, "요청 바디의 JSON 형식이 올바르지 않습니다.");
        return ResponseEntity.status(ErrorCode.INVALID_INPUT_VALUE.getHttpStatus()).body(response);
    }

    /**
     * 지원하지 않는 HTTP 메서드 호출 (예: POST 엔드포인트에 GET 호출)
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.warn("[HttpRequestMethodNotSupportedException] Method: {}", e.getMethod());

        ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
        return ResponseEntity.status(ErrorCode.METHOD_NOT_ALLOWED.getHttpStatus()).body(response);
    }

    /**
     * 잘못된 엔드포인트 경로 접근 (Spring 6 / Boot 3.2+)
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFoundException(NoResourceFoundException e) {
        log.warn("[NoResourceFoundException] Path: {}", e.getResourcePath());

        ErrorResponse response = ErrorResponse.of(ErrorCode.RESOURCE_NOT_FOUND, "요청하신 리소스 경로를 찾을 수 없습니다.");
        return ResponseEntity.status(ErrorCode.RESOURCE_NOT_FOUND.getHttpStatus()).body(response);
    }

    /**
     * Spring Security 권한 부족 (403 Forbidden)
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
        log.warn("[AccessDeniedException] {}", e.getMessage());

        ErrorResponse response = ErrorResponse.of(ErrorCode.FORBIDDEN);
        return ResponseEntity.status(ErrorCode.FORBIDDEN.getHttpStatus()).body(response);
    }

    /**
     * Spring Security 미인증/토큰 만료 (401 Unauthorized)
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationException e) {
        log.warn("[AuthenticationException] {}", e.getMessage());

        ErrorResponse response = ErrorResponse.of(ErrorCode.UNAUTHORIZED);
        return ResponseEntity.status(ErrorCode.UNAUTHORIZED.getHttpStatus()).body(response);
    }

    /**
     * 그 외 예상치 못한 모든 서버 내부 오류 (500 Internal Server Error)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("[UnhandledException] Server Error: ", e);

        ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus()).body(response);
    }
}