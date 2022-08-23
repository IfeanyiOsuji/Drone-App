package com.musalasoft.droneservice.Service;

import com.musalasoft.droneservice.Models.Medication2;
import com.musalasoft.droneservice.Repo.MedicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService{
    @Autowired
    private MedicationRepo medicationRepo;
    @Override
    public Medication2 saveMedication(Medication2 medication2) {
        return medicationRepo.save(medication2);
    }

    @Override
    public List<Medication2> saveAllMedications(List<Medication2> medication2s) {
        return medicationRepo.saveAll(medication2s);
    }


}
