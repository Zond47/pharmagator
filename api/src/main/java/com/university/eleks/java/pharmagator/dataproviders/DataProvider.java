package com.university.eleks.java.pharmagator.dataproviders;

import com.university.eleks.java.pharmagator.dataproviders.dto.MedicineDto;

import java.util.stream.Stream;

public interface DataProvider {
    Stream<MedicineDto> loadData();
}
