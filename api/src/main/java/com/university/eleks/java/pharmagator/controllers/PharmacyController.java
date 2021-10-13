package com.university.eleks.java.pharmagator.controllers;

import com.university.eleks.java.pharmagator.entities.Pharmacy;
import com.university.eleks.java.pharmagator.repositories.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pharmacies")
public class PharmacyController {

    private final PharmacyRepository pharmacyRepository;

    @GetMapping
    public ResponseEntity<List<Pharmacy>> getAll() {
        return ResponseEntity.ok(pharmacyRepository.findAll());
    }

    // Add maping
    public ResponseEntity<Pharmacy> getById(long id){
        return ResponseEntity.ok(pharmacyRepository.getById(id));
    }

    public void create(String name, String medicine_link_template){
        pharmacyRepository.save(Pharmacy.builder()
                        .name(name)
                        .medicineLinkTemplate(medicine_link_template)
                        .build());
    }

    public void update(long id, String name, String link){
        Pharmacy updated = pharmacyRepository.getById(id);
        updated.setName(name);
        updated.setMedicineLinkTemplate(link);
        pharmacyRepository.deleteById(id);
        pharmacyRepository.save(updated);
    }

    public void deleteById(long id){
        pharmacyRepository.deleteById(id);
    }
}
