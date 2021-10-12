package com.university.eleks.java.pharmagator.repositories;

import com.university.eleks.java.pharmagator.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
