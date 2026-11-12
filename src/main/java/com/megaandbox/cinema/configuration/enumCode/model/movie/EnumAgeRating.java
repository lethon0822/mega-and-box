package com.megaandbox.cinema.configuration.enumCode.model.movie;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum EnumAgeRating implements EnumMapperType {
    ALL("ALL", "전체관람가"),
    AGE_12("AGE_12", "12세 이상 관람가"),
    AGE_15("AGE_15", "15세 이상 관람가"),
    AGE_19("AGE_19", "청소년 관람불가");

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<EnumAgeRating> {
        public CodeConverter() { super(EnumAgeRating.class, false); }
    }
}

