package com.megaandbox.cinema.user;

import com.megaandbox.cinema.configuration.enumCode.model.user.EnumUserGrade;
import com.megaandbox.cinema.configuration.enumCode.model.user.EnumUserStatus;
import com.megaandbox.cinema.configuration.exception.CustomException;
import com.megaandbox.cinema.configuration.exception.ErrorCode;
import com.megaandbox.cinema.entity.user.User;
import com.megaandbox.cinema.user.model.SignUpReqDto;
import com.megaandbox.cinema.user.repository.UserRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp (@RequestBody SignUpReqDto req) {
        List<String> emailList = userRepository.findAll().stream().map(User::getEmail).toList();
        for (String email : emailList) {
            if (req.getUserEmail().equals(email)) {
                throw new CustomException(ErrorCode.USER_FOUND);
            }
        }

        String EncodingPw = passwordEncoder.encode(req.getUserPw());
        User user = User.builder()
                .email(req.getUserEmail())
                .password(EncodingPw)
                .name(req.getUserName())
                .birth(req.getUserBirth())
                .gender(req.isUserGender())
                .phone(req.getUserPhone())
                .userStatus(EnumUserStatus.ACTIVE)
                .grade((EnumUserGrade.BRONZE))
                .profile(null)
                .pwUpdatedAt(LocalDate.from(LocalDateTime.now()))
                .naverAccount(null)
                .kakaoAccount(null)
                .build();
        userRepository.save(user);
    }

}
