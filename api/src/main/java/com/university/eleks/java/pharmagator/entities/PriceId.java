package com.university.eleks.java.pharmagator.entities;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceId implements Serializable {
    private long pharmacyId;
    private long medicineId;
}