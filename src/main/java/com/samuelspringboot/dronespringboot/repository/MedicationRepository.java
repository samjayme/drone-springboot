package com.samuelspringboot.dronespringboot.repository;

import com.samuelspringboot.dronespringboot.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
