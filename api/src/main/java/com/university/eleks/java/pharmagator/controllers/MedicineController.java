package com.university.eleks.java.pharmagator.controllers;

import com.university.eleks.java.pharmagator.dataproviders.dto.MedicineDto;
import com.university.eleks.java.pharmagator.entities.Medicine;
import com.university.eleks.java.pharmagator.repositories.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/medicines")
public class MedicineController {

    private final MedicineRepository medicineRepository;

    private final ModelMapper modelMapper;

    @GetMapping
    public List<Medicine> getAll() {
        return medicineRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getById(@PathVariable("id") Long id) {
        return medicineRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medicine> create(@RequestBody MedicineDto medicineDto){
        Medicine medicine = modelMapper.map(medicineDto, Medicine.class);

        return ResponseEntity.ok(medicineRepository.save(medicine));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Medicine> update(@RequestBody MedicineDto medicineDto,
                                            @PathVariable("id") Long id) {
        return medicineRepository.findById(id)
                .map(source -> {
                    source = modelMapper.map(medicineDto, Medicine.class);
                    return  ResponseEntity.ok(medicineRepository.save(source));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        medicineRepository.deleteById(id);
        return ResponseEntity.ok("Deleted!");
    }
}
