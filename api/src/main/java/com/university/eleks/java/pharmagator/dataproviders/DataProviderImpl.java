package com.university.eleks.java.pharmagator.dataproviders;

import com.university.eleks.java.pharmagator.dataproviders.dto.MedicineDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class DataProviderImpl implements DataProvider {
    @Override
    public Stream<MedicineDto> loadData() {
        IntStream.rangeClosed(1, 100)
                .mapToObj(this::buildDto);
        return null;
    }

    private MedicineDto buildDto(int i) {
        return MedicineDto.builder()
                .externalId(String.valueOf(i))
                .title("title" + i)
                .price(BigDecimal.valueOf(Math.random()))
                        .build();
    }
}
