package com.university.eleks.java.pharmagator.controllers.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceDto {
    private BigDecimal price;
    private String externalId;
}
