package com.megaandbox.cinema.configuration.enumCode.model.user;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;

import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumUserStatus implements EnumMapperType
{
    ACTIVE("01","유효")
    , TERMINATED("02","탈퇴")
    , TERMINATION_SCHEDULED("03","탈퇴예정");

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<EnumUserStatus> {
        public CodeConverter() { super(EnumUserStatus.class, false); }
    }
}
