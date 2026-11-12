package com.megaandbox.cinema.configuration.enumCode.model.socialpay;


import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumPaymentStatus implements EnumMapperType {

    COMPLETED("success", "결제 완료"),
    CANCELLED("cancel", "결제 취소"),
    FAILED("fail", "결제 실패");

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class EnumPaymentStatusConverter
            extends AbstractEnumCodeConverter<EnumPaymentStatus> {

        public EnumPaymentStatusConverter() {
            super(EnumPaymentStatus.class, false);
        }
    }
}

