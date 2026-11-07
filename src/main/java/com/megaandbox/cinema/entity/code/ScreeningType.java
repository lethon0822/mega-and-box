package com.megaandbox.cinema.entity.code;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ScreeningType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer screeningTypeId;

    @Column(nullable = false, length = 20)
    private String typeName;
}
