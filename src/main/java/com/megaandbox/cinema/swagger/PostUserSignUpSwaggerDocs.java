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
        summary = "회원가입",
        description = """
                **새로운 사용자가 회원가입을 합니다.**
                
                **Request**
                - userEmail : 사용자 이메일
                - userPw : 사용자 비밀번호
                - userPw : 사용자 비밀번호
                - userName : 사용자 이름
                - userGender : 사용자 성별
                - userPhone : 사용자 휴대폰 번호
                
                **Response**
                - null
                """
)
@ApiResponses({
        // 성공 메세지 + res 답변
        @ApiResponse(
                responseCode = "200",
                description = "회원가입 성공",
                content = @Content(
                        mediaType = "application/json",
                        examples = @ExampleObject(
                                name = "회원가입 성공",
                                value = """
                                {
                                  "code": "SUCCESS_001",
                                  "message": "요청이 정상적으로 처리되었습니다.",
                                  "timestamp": "2026-11-18T10:14:49.092184"
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
public @interface PostUserSignUpSwaggerDocs {
}
