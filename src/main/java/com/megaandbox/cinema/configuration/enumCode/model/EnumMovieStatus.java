package com.megaandbox.cinema.configuration.enumCode.model;


import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

//@Getter
//@RequiredArgsConstructor
public enum EnumMovieStatus//implements EnumMapperType
{
      NOW_SHOWING
    , COMING_SOON
    , END_OF_SHOWING;

//    private final String code;
//    private final String value;
//
//    @Converter(autoApply = true)
//    public static class CodeConverter extends AbstractEnumCodeConverter<EnumMovieStatus> {
//        public CodeConverter() { super(EnumMovieStatus.class, false); }
//    }
}
