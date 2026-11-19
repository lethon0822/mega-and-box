package com.megaandbox.cinema.user;

import com.megaandbox.cinema.common.ApiResponse;
import com.megaandbox.cinema.common.SuccessCode;
import com.megaandbox.cinema.configuration.jwt.JwtTokenManager;
import com.megaandbox.cinema.configuration.model.UserPrincipal;
import com.megaandbox.cinema.swagger.*;
import com.megaandbox.cinema.user.model.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@Tag(name = "사용자", description = "사용자 관련 API 입니다.")
public class UserController {

    private final UserService userService;
    private final JwtTokenManager jwtTokenManager;

    // 회원가입
    @PostMapping("/sign-up")
    @PostUserSignUpSwaggerDocs
    public ResponseEntity<ApiResponse<Void>> signUp (@Valid @RequestBody SignUpReqDto req) {
        userService.signUp(req);
        return ApiResponse.success(SuccessCode.OK);
    }

    @PostMapping("/sign-in")
    @PostUserSignInSwaggerDocs
    public ResponseEntity<ApiResponse<LoginDto>> login(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginReqDto req) {
        LoginDto result = userService.login(request, response, req);
        return ApiResponse.success(SuccessCode.OK, result);
    }

    @PostMapping("/sign-out")
    @PostUserSignOutSwaggerDocs
    public ResponseEntity<ApiResponse<Void>> logout(HttpServletResponse response) {
        userService.logout(response);
        return ApiResponse.success(SuccessCode.OK);
    }


    @PostMapping("/auth/confirm")
    @PostUserConformPasswordSwaggerDocs
    public ResponseEntity<ApiResponse<Void>> confirmPassword (@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody ConfirmPasswordReq req) {
        userService.confirmPassword(userPrincipal.getSignedUserId(), req);
        return ApiResponse.success(SuccessCode.OK);
    }

    @PutMapping("/auth/renewal")
    @PostUserChangePasswordSwaggerDocs
    public ResponseEntity<ApiResponse<Void>> renewalPassword (@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody ChangePasswordReq req){
        userService.renewalPassword(userPrincipal.getSignedUserId(), req);
        return ApiResponse.success(SuccessCode.OK);
    }

    @PostMapping("/auth/delete")
    public ResponseEntity<ApiResponse<Void>> deleteUser (@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody ConfirmPasswordReq req, HttpServletResponse response) {
        userService.deleteUser(userPrincipal.getSignedUserId(), req, response);
        return ApiResponse.success(SuccessCode.OK);
    }

}
