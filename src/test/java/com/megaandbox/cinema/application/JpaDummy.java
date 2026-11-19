package com.megaandbox.cinema.application;

import net.datafaker.Faker;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.Locale;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaDummy {
    public static Faker koFaker = new Faker(new Locale("ko")); // 한글
    public static Faker faker = new Faker(new Locale("en")); // 영어
}
