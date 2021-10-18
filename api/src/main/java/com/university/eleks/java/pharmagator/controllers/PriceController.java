package com.university.eleks.java.pharmagator.controllers;

import com.university.eleks.java.pharmagator.entities.Price;
import com.university.eleks.java.pharmagator.repositories.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {

    private final PriceRepository priceRepository;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Price>> getAll() {
        return ResponseEntity.ok(priceRepository.findAll());
    }

    //TODO
}
