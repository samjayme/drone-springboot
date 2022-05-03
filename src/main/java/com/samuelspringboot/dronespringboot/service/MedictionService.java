package com.samuelspringboot.dronespringboot.service;

import com.samuelspringboot.dronespringboot.dto.MedicationDto;
import com.samuelspringboot.dronespringboot.entity.Medication;


public interface MedictionService {
    public Medication saveMedication(MedicationDto medicationDto) ;
}
