package com.megaandbox.cinema.entity.coupon;

import com.megaandbox.cinema.configuration.enumCode.model.user.EnumCouponType;
import jakarta.persistence.*;
import lombok.*;

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
    private EnumCouponType discountType;

    @Column(nullable = false)
    private int discountAmount;

    @Column
    private int validDays;

}
