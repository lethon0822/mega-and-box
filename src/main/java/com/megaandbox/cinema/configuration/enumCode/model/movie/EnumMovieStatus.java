package com.megaandbox.cinema.configuration.enumCode.model.movie;


import com.megaandbox.cinema.configuration.enumCode.AbstractEnumCodeConverter;
import com.megaandbox.cinema.configuration.enumCode.EnumMapperType;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumMovieStatus implements EnumMapperType
{
      NOW_SHOWING("now","상영중")
    , COMING_SOON("yet","개봉예정")
    , END_OF_SHOWING("done","상영종료");

    private final String code;
    private final String value;

    @Converter(autoApply = true)
    public static class CodeConverter extends AbstractEnumCodeConverter<EnumMovieStatus> {
        public CodeConverter() { super(EnumMovieStatus.class, false); }
    }
}
