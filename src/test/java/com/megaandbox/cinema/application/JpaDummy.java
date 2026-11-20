package com.megaandbox.cinema.application;

import io.github.cdimascio.dotenv.Dotenv;
import net.datafaker.Faker;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.Locale;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaDummy {
    static {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
        });
    }

    public static Faker koFaker = new Faker(new Locale("ko")); // 한글
    public static Faker faker = new Faker(new Locale("en")); // 영어
}
