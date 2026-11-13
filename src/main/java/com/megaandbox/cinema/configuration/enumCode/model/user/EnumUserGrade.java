package com.megaandbox.cinema.configuration.enumCode.model.user;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumUserGrade implements EnumMapperType {

    BRONZE("bronze", "브론즈"),
    SILVER ("silver", "실버"),
    GOLD ("gold", "골드"),
    PLATINUM ("platinum", "플래티넘"),
    DIAMOND("diamond", "다이아몬드");

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<EnumUserGrade> {
        public CodeConverter() {
            super(EnumUserGrade.class, false);
        }
    }

}
