package com.megaandbox.cinema.configuration.model;

import com.megaandbox.cinema.configuration.enumCode.model.user.EnumUserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtUser {
    private Long userId;
    private EnumUserStatus status;
}
