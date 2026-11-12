package com.megaandbox.cinema.configuration.enumCode.model.socialpay;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumPaymentType implements EnumMapperType {

    STORE("store", "매점"),
    BOOKING("booking", "예매"),
    MEMBERSHIP("membership", "멤버십");

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