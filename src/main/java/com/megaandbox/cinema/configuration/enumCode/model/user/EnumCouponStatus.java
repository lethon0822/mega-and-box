package com.megaandbox.cinema.configuration.enumCode.model.user;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumCouponStatus implements EnumMapperType {
    ACTIVE("01","유효")
    , USED("02","사용완료")
    , EXPIRED("03","기간만료");

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<EnumCouponStatus> {
        public CodeConverter() { super(EnumCouponStatus.class, false); }
    }
}
