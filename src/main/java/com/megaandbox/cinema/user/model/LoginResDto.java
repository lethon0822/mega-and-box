package com.megaandbox.cinema.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.megaandbox.cinema.configuration.enumCode.model.user.EnumUserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResDto {
    private String userEmail;
    private EnumUserStatus status;

    @JsonIgnore
    private String password;
}
