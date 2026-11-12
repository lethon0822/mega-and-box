package com.megaandbox.cinema.entity.code;

import com.megaandbox.cinema.configuration.enumCode.model.movie.EnumAgeType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tkTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name="screening_type_id")
    private ScreeningType screeningType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumAgeType ageType;

    @Column(nullable = false)
    private Integer basePrice;
}
