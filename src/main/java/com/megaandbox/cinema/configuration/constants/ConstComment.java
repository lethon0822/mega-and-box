package com.megaandbox.cinema.configuration.constants;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

// 페이징 할 때 사용

@ConfigurationProperties(prefix = "constants.comment")
@RequiredArgsConstructor
public class ConstComment {
    public final int startIndex;
    public final int needForViewCount;
}