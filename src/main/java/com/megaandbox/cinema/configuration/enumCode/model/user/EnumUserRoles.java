package com.megaandbox.cinema.configuration.enumCode.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumUserRoles {

    ROLE_USER("USER","사용자")

    ;

    private final String code;
    private final String value;

}
