package com.megaandbox.cinema.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReqDto {

    private String userEmail;
    private String password;

}
