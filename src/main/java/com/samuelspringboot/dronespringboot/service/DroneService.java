package com.samuelspringboot.dronespringboot.service;

import com.samuelspringboot.dronespringboot.dto.DroneDto;
import com.samuelspringboot.dronespringboot.entity.Drone;
import com.samuelspringboot.dronespringboot.serviceException.DroneLimitExceededException;
import com.samuelspringboot.dronespringboot.serviceException.DroneNotAvailableException;


import java.util.List;


public interface DroneService {

    Drone registerDrone(DroneDto droneDto) ;

   Drone loadDroneWithMed(Long droneId , List<Long> medicationId) throws DroneNotAvailableException, DroneLimitExceededException;

   List<Drone> findAllDrone();


    List<Drone> getAvailableDrone();

    Long checkBatteryPercentage(Long id) throws DroneNotAvailableException;

    Drone checkLoadedItems(Long droneId) throws DroneNotAvailableException;

}
