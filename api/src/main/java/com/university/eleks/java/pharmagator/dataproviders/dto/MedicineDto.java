package com.university.eleks.java.pharmagator.dataproviders.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MedicineDto {
    private String title;
    private BigDecimal price;
    private String externalId;
}