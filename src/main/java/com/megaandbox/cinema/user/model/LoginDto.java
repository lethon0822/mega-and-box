package com.megaandbox.cinema.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class LoginDto {
    private LoginResDto loginRes; // 응답용
    private String accessToken; // 액세스 토큰
}