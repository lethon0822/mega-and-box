package com.megaandbox.cinema.configuration.enumCode.model.movie;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumSeatType implements EnumMapperType {

    NORMAL("normal", "일반"),
    SPECIAL("special", "특별"),
    DISABLED("disable", "장애인"),
    COUPLE("couple","커플");

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<EnumSeatType> {
        public CodeConverter() {
            super(EnumSeatType.class, false);
        }
    }
}