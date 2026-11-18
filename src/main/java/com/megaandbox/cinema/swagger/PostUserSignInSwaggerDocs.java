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
        summary = "로그인",
        description = """
                **사용자가 로그인을 합니다.**
                
                **Request**
                - userEmail : 사용자 이메일
                - password : 사용자 비밀번호
                
                **Response**
                - userId : 사용자 PK
                - status : 사용자 등급
                """
)
@ApiResponses({
        // 성공 메세지 + res 답변
        @ApiResponse(
                responseCode = "200",
                description = "로그인 성공",
                content = @Content(
                        mediaType = "application/json",
                        examples = @ExampleObject(
                                name = "로그인 성공",
                                value = """
                                {
                                   "code": "SUCCESS_001",
                                   "data": {
                                     "accessToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIke0pXVF9JU1N9IiwiaWF0IjoxNzk0OTY4MjExLCJleHAiOjE3OTQ5NjkxMTEsInNpZ25lZFVzZXIiOiJ7XCJ1c2VySWRcIjoyLFwic3RhdHVzXCI6XCLsnKDtmqhcIn0ifQ.GS6U7qfXwYJjJj_jTwlukEXdasbB33Ob6Ng8lMY990U",
                                     "loginRes": {
                                       "userEmail": "cjftn0104@gmail.com",
                                       "status": "유효"
                                     }
                                   },
                                   "message": "요청이 정상적으로 처리되었습니다.",
                                   "timestamp": "2026-11-18T11:16:51.2720972"
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
public @interface PostUserSignInSwaggerDocs {
}
