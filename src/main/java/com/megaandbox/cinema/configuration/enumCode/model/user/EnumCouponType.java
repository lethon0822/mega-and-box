package com.megaandbox.cinema.configuration.enumCode.model.user;

import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.model.socialpay.EnumPayMethod;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumCouponType {

    FIXED("fixed", "고정값"),
    PERCENT("percent", "변동값");


    private final String code;
    private final String value;

}
