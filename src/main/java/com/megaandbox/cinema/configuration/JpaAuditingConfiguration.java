package com.megaandbox.cinema.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
* 엔티티가 생성되거나 수정된 시점을 자동으로 기록하는 기능
* CreatedAt, UpdatedAt을 사용하기 위함
* */

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfiguration {
}
