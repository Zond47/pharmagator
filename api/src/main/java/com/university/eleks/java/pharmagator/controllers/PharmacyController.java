package com.university.eleks.java.pharmagator.controllers;

import com.university.eleks.java.pharmagator.controllers.dto.PharmacyDto;
import com.university.eleks.java.pharmagator.entities.Pharmacy;
import com.university.eleks.java.pharmagator.repositories.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pharmacies")
public class PharmacyController {

    private final PharmacyRepository pharmacyRepository;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Pharmacy>> getAll() {
        return ResponseEntity.ok(pharmacyRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pharmacy> getById(@PathVariable("id") Long id){
        return pharmacyRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pharmacy> create(@RequestBody PharmacyDto pharmacyDto){
        Pharmacy pharmacy = modelMapper.map(pharmacyDto, Pharmacy.class);

        return ResponseEntity.ok(pharmacyRepository.save(pharmacy));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pharmacy> update(@RequestBody PharmacyDto pharmacyDto,
                       @PathVariable Long id){
        return pharmacyRepository.findById(id)
                .map(source -> {
                    source = modelMapper.map(pharmacyDto, Pharmacy.class);
                    return ResponseEntity.ok(pharmacyRepository.save(source));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        pharmacyRepository.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
