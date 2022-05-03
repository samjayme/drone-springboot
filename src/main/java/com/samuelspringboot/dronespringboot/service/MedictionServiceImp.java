package com.samuelspringboot.dronespringboot.service;

import com.samuelspringboot.dronespringboot.dto.MedicationDto;
import com.samuelspringboot.dronespringboot.entity.Medication;
import com.samuelspringboot.dronespringboot.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedictionServiceImp implements MedictionService{
    @Autowired
    private MedicationRepository medicationRepository;

    @Override
    public Medication saveMedication(MedicationDto medicationDto) {
        Medication medication = new Medication();
        medication.setCode(medicationDto.getCode());
        medication.setName(medicationDto.getName());
        medication.setImage(medicationDto.getImage());
        medication.setWeight(medicationDto.getWeight());

        return medicationRepository.save(medication) ;
    }
}
