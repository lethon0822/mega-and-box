package com.megaandbox.cinema.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResDto {
    private String userEmail;

    @JsonIgnore
    private String password;
}
