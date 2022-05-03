package com.samuelspringboot.dronespringboot.service;

import com.samuelspringboot.dronespringboot.dto.DroneDto;
import com.samuelspringboot.dronespringboot.entity.Drone;
import com.samuelspringboot.dronespringboot.entity.Medication;
import com.samuelspringboot.dronespringboot.repository.Dronerepository;
import com.samuelspringboot.dronespringboot.repository.MedicationRepository;
import com.samuelspringboot.dronespringboot.serviceException.DroneLimitExceededException;
import com.samuelspringboot.dronespringboot.serviceException.DroneNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DroneServiceImp implements DroneService {
    @Autowired
    private Dronerepository dronerepository;
    @Autowired
    private MedicationRepository medicationRepository;
    private static final Long batteryLimit = 25L;
    private static final String stateForLoading = "idle";


    //REGISTER NEW DRONE
    @Override
    public Drone registerDrone(DroneDto droneDto) {
        Drone drone = new Drone();
        drone.setState(droneDto.getState());
        drone.setBatteryPercentage(droneDto.getBatteryPercentage());
        drone.setModel(droneDto.getModel());
        drone.setWeightLimit(droneDto.getWeightLimit());


        return dronerepository.save(drone);
    }

    //LOAD DRONE WITH MEDICATION/S

    @Override
    public Drone loadDroneWithMed(Long droneId, List<Long> medicationId) throws DroneNotAvailableException, DroneLimitExceededException {
        Drone drone = dronerepository.findById(droneId).orElseThrow(() -> new DroneNotAvailableException("drone with "
                + " " + droneId + " " + " not available"));
        Long droneLimit = drone.getWeightLimit();
        String droneState = drone.getState();

        List<Medication> medications = (medicationRepository.findAllById(medicationId));

        Long medicationWeight = 0L;
        for (Medication med : medications) {
            medicationWeight += med.getWeight();
        }
        if (drone.getBatteryPercentage() > 25L) {
            if (medicationWeight < droneLimit || droneState.equals(stateForLoading)) {
                drone.setState("loading");
                drone.setMedicationList(medications);
                drone.setState("loaded");
            }
            else  {
                throw new DroneLimitExceededException("Drone with id " + droneId + "is loaded with more medication" +
                        medicationWeight + " than it can carry");
            }

        }
        return drone;
    }

        @Override
        public List<Drone> findAllDrone () {
            return new ArrayList<>(dronerepository.findAll());
        }

        //GET DRONES AVAILABLE FOR LOADING

        @Override
        public List<Drone> getAvailableDrone () {

            List<Drone> drone = dronerepository.findAll();
            List<Drone> AvailableDroneList = drone.stream()
                    .filter(d -> d.getBatteryPercentage() > batteryLimit || d.getState().equals(stateForLoading)).toList();


            return new ArrayList<>(AvailableDroneList);
        }



        //CHECK DRONE BATTERY PERCENTAGE BY DRONE ID

        @Override
        public Long checkBatteryPercentage (Long id) throws DroneNotAvailableException {
            Drone drone = dronerepository.findById(id).orElseThrow(() -> new DroneNotAvailableException("drone with " + " " + id + " " + " not available"));


            return drone.getBatteryPercentage();
        }

        @Override
        public Drone checkLoadedItems (Long droneId) throws DroneNotAvailableException {

            Drone drone = dronerepository.findById(droneId).orElseThrow(() -> new DroneNotAvailableException("drone with "
                    + " " + droneId + " " + " not available"));
            drone.getMedicationList();

            return drone;
        }
    }




