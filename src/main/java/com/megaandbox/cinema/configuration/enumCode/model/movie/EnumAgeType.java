package com.megaandbox.cinema.configuration.enumCode.model.movie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumAgeType {

    ADULT("성인"),
    TEENAGER("청소년"),
    SENIOR("경로"),
    PREFERENTIAL("우대");

    private final String description;
}