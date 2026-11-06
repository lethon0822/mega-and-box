package com.megaandbox.cinema.configuration.enumCode.model;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SeatType implements EnumMapperType {

    NORMAL("01", "일반"),
    SPECIAL("02", "특별"),
    DISABLED("03", "장애인");

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<SeatType> {
        public CodeConverter() {
            super(SeatType.class, false);
        }
    }
}