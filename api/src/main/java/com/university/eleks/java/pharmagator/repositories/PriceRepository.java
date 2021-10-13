package com.university.eleks.java.pharmagator.repositories;

import com.university.eleks.java.pharmagator.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}
