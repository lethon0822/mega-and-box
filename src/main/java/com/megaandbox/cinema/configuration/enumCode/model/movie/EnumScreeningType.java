package com.megaandbox.cinema.configuration.enumCode.model.movie;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumScreeningType implements EnumMapperType {

    NORMAL("moring", "조조"),
    SPECIAL("special", "일반"),
    DISABLED("night", "심야");

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<EnumScreeningType> {
        public CodeConverter() {
            super(EnumScreeningType.class, false);
        }
    }
}
