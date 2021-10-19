package com.university.eleks.java.pharmagator.controllers;

import com.university.eleks.java.pharmagator.controllers.dto.PriceDto;
import com.university.eleks.java.pharmagator.entities.Price;
import com.university.eleks.java.pharmagator.entities.PriceId;
import com.university.eleks.java.pharmagator.repositories.MedicineRepository;
import com.university.eleks.java.pharmagator.repositories.PharmacyRepository;
import com.university.eleks.java.pharmagator.repositories.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Controller
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {

    private final PriceRepository priceRepository;
    private final MedicineRepository medicineRepository;
    private final PharmacyRepository pharmacyRepository;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Price>> getAll() {
        return ResponseEntity.ok(priceRepository.findAll());
    }

    @GetMapping("/{pharmacyId}/{medicineId}")
    public ResponseEntity<Price> getById(@PathVariable("pharmacyId") Long pharmacyId,
                                         @PathVariable("medicineId") Long medicineId) {
        return priceRepository.findById(new PriceId(pharmacyId, medicineId))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Price> create(@RequestBody Price price) {
        return ResponseEntity.ok(priceRepository.save(price));
    }

    @PostMapping("/{pharmacyId}/{medicineId}")
    public ResponseEntity<Price> update(@RequestBody PriceDto priceDto,
                                        @PathVariable("pharmacyId") Long pharmacyId,
                                        @PathVariable("medicineId") Long medicineId) {
        PriceId priceId = new PriceId(pharmacyId, medicineId);

        Function<PriceId, Optional<Price>> create = id ->
                this.pharmacyRepository.findById(id.getPharmacyId())
                        .map(pharmacy -> Price.builder()
                                .pharmacyId(pharmacy.getId())
                        )
                        .flatMap(builder ->
                                this.medicineRepository.findById(id.getMedicineId())
                                        .map(medicine -> builder
                                                .medicineId(medicine.getId())
                                        )
                        )
                        .map(builder -> builder
                                .price(priceDto.getPrice())
                                .externalId(priceDto.getExternalId()))
                        .map(Price.PriceBuilder::build);

        return this.priceRepository.findById(priceId)
                .map(source -> {
                    source.setPrice(priceDto.getPrice());
                    source.setExternalId(priceDto.getExternalId());
                    return source;
                }).or(() -> create.apply(priceId))
                .map(this.priceRepository::save)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{pharmacyId}/{medicineId}")
    public ResponseEntity<String> deleteById(@PathVariable("pharmacyId") Long pharmacyId,
                                             @PathVariable("medicineId") Long medicineId) {
        priceRepository.deleteById(new PriceId(pharmacyId, medicineId));
        return ResponseEntity.ok("Deleted!");
    }
}
