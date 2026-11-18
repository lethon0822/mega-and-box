package com.megaandbox.cinema.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SignUpReqDto {

    private String userEmail;
    private String userPw;
    private String userName;
    private LocalDate userBirth;
    private boolean userGender;
    private String userPhone;

}
