package com.megaandbox.cinema.configuration.enumCode.model.movie;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumAgeType implements EnumMapperType {

    ADULT("AGE_AD","성인"),
    TEENAGER("AGE_TE","청소년"),
    SENIOR("AGE_SE","경로"),
    PREFERENTIAL("AGE_PR","우대");

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<EnumAgeType> {
        public CodeConverter() { super(EnumAgeType.class, false); }
    }
}