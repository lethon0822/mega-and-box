package com.megaandbox.cinema.configuration.enumCode.model;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumPaymentType implements EnumMapperType {

    STORE("01", "매점"),
    BOOKING("02", "예매"),
    MEMBERSHIP("03", "멤버십");

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class EnumPaymentTypeConverter
            extends AbstractEnumCodeConverter<EnumPaymentType> {

        public EnumPaymentTypeConverter() {
            super(EnumPaymentType.class, false);
        }
    }
}