package com.university.eleks.java.pharmagator.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "prices")
@IdClass(PriceId.class)
public class Price {
    @Id
    private long pharmacyId;
    @Id
    private long medicineId;
    private BigDecimal price;
    private String externalId;
    private Instant updatedAt;
}
