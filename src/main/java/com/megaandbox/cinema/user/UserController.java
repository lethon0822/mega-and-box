package com.megaandbox.cinema.user;

import com.megaandbox.cinema.common.ApiResponse;
import com.megaandbox.cinema.common.SuccessCode;
import com.megaandbox.cinema.example.MovieService;
import com.megaandbox.cinema.swagger.PostUserSignUpSwaggerDocs;
import com.megaandbox.cinema.user.model.SignUpReqDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@Tag(name = "사용자", description = "사용자 관련 API 입니다.")
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/sign-up")
    @PostUserSignUpSwaggerDocs
    public ResponseEntity<ApiResponse<Void>> signUp (@RequestBody SignUpReqDto req) {
        userService.signUp(req);
        return ApiResponse.success(SuccessCode.OK);
    }

}
