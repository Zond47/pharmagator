package com.university.eleks.java.pharmagator.repositories;

import com.university.eleks.java.pharmagator.entities.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
