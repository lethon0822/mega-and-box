package com.megaandbox.cinema.user;

import com.megaandbox.cinema.configuration.enumCode.model.user.EnumUserGrade;
import com.megaandbox.cinema.configuration.enumCode.model.user.EnumUserRoles;
import com.megaandbox.cinema.configuration.enumCode.model.user.EnumUserStatus;
import com.megaandbox.cinema.configuration.exception.CustomException;
import com.megaandbox.cinema.configuration.exception.ErrorCode;
import com.megaandbox.cinema.configuration.jwt.JwtTokenManager;
import com.megaandbox.cinema.configuration.model.JwtUser;
import com.megaandbox.cinema.configuration.model.UserPrincipal;
import com.megaandbox.cinema.entity.user.User;
import com.megaandbox.cinema.user.model.*;
import com.megaandbox.cinema.user.repository.UserRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenManager jwtTokenManager;

    public void signUp (@RequestBody SignUpReqDto req) {
        List<String> emailList = userRepository.findAll().stream().map(User::getEmail).toList();
        for (String email : emailList) {
            if (req.getUserEmail().equals(email)) {
                throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
            }
        }

        String encodingPw = passwordEncoder.encode(req.getUserPw());
        User user = User.builder()
                .email(req.getUserEmail())
                .password(encodingPw)
                .name(req.getUserName())
                .birth(req.getUserBirth())
                .gender(req.isUserGender())
                .phone(req.getUserPhone())
                .userStatus(EnumUserStatus.ACTIVE)
                .grade(EnumUserGrade.BRONZE)
                .profile(null)
                .pwUpdatedAt(LocalDate.from(LocalDateTime.now()))
                .naverAccount(null)
                .kakaoAccount(null)
                .build();
        userRepository.save(user);
    }

    public LoginDto login (HttpServletRequest request, HttpServletResponse response, @RequestBody LoginReqDto req) {
        User user = userRepository.findByEmail(req.getUserEmail());
        if(user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        LoginResDto res = new LoginResDto(user.getEmail(), user.getPassword());
        if(!passwordEncoder.matches(req.getPassword(), res.getPassword())) {
            throw new CustomException(ErrorCode.PASSWORD_MISMATCH);
        }

        // 보안상 노출 방지
        res.setPassword(null);
        JwtUser jwtUser = new JwtUser(user.getUserId(), EnumUserRoles.ROLE_USER);
        jwtTokenManager.issue(response, jwtUser);

        return LoginDto.builder()
                .loginRes(res)
                .accessToken(jwtTokenManager.getAccessTokenFromCookie(request))
                .build();
    }

    public void logout (HttpServletResponse response) {
        jwtTokenManager.signOut(response);
    }


    public void confirmPassword(Long userId, ConformPasswordReq req) {
        String encodedPw = userRepository.findPasswordByUserId(userId);

        if (encodedPw == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        if (!passwordEncoder.matches(req.getPassword(), encodedPw)) {
            throw new CustomException(ErrorCode.PASSWORD_MISMATCH);
        }
    }

}
