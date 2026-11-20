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
    private String screeningTypeId;

    @Column(nullable = false, length = 20)
    private String typeName;
}
