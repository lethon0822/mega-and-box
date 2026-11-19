package com.megaandbox.cinema.configuration.model;

import com.megaandbox.cinema.configuration.enumCode.model.user.EnumUserRoles;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtUser {
    private long userId;
    private EnumUserRoles roles;
}
