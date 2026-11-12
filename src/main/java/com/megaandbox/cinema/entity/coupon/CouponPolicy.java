package com.megaandbox.cinema.entity.coupon;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@EqualsAndHashCode
public class CouponPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cpId;

    @Column(nullable = false, length = 20)
    private String cpName;

    @Column(nullable = false)
    // 0: FIXED, 1: PERCENT
    private boolean discountType;

    @Column(nullable = false)
    private int discountAmount;

    @Column
    private int validDays;

}
