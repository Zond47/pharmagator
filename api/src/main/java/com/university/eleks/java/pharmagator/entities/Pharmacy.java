package com.university.eleks.java.pharmagator.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Entity
@Data
@AllArgsConstructor
@Table(name = "pharmacies")
public class Pharmacy {
    @Id
    private long id;
    private String name;
    private String medicineLinkTemplate;
}
