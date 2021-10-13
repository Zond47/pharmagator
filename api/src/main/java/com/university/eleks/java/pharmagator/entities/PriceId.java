package com.university.eleks.java.pharmagator.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class PriceId implements Serializable {
    private long pharmacyId;
    private long medicineId;
}
