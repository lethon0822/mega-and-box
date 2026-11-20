package com.megaandbox.cinema.application.user.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SignUpReqDto {

    private String userEmail;
    private String userPw;
    private String userName;
    private LocalDate userBirth;
    private boolean userGender;
    private String userPhone;

}
