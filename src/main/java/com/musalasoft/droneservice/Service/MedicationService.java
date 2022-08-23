package com.musalasoft.droneservice.Service;

import com.musalasoft.droneservice.Models.Medication2;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MedicationService {
    public Medication2 saveMedication(Medication2 medication2);
    public List<Medication2> saveAllMedications(List<Medication2>medication2s);
}
