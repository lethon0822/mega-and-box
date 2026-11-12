package com.megaandbox.cinema.configuration.enumCode.model.socialpay;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumPayMethod implements EnumMapperType {

    NAVER("naver", "네이버"),
    KAKAO("kakao", "카카오");


    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class EnumPaymentStatusConverter
            extends AbstractEnumCodeConverter<EnumPayMethod> {

        public EnumPaymentStatusConverter() {
            super(EnumPayMethod.class, false);
        }
    }
}

