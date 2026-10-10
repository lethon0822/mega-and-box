package com.megaandbox.cinema;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        // 스프링 컨텍스트가 초기화되기 전에 OS 시스템 프로퍼티에 강제 세팅
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
        });
        SpringApplication.run(CinemaApplication.class, args);
    }

}
