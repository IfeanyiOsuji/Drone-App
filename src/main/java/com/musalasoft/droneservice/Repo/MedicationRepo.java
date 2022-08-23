package com.musalasoft.droneservice.Repo;

import com.musalasoft.droneservice.Models.Medication2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepo extends JpaRepository<Medication2, Long> {
}
