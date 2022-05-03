package com.samuelspringboot.dronespringboot.controller;

import com.samuelspringboot.dronespringboot.dto.DroneDto;
import com.samuelspringboot.dronespringboot.entity.Drone;
import com.samuelspringboot.dronespringboot.service.DroneService;
import com.samuelspringboot.dronespringboot.serviceException.DroneLimitExceededException;
import com.samuelspringboot.dronespringboot.serviceException.DroneNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DroneController {

    @Autowired
    private DroneService droneService;

    @PostMapping("/Drones/register")
    public ResponseEntity<Drone> registerDrone(@Valid @RequestBody DroneDto droneDto)  {
        return  new ResponseEntity<>(droneService.registerDrone(droneDto), HttpStatus.CREATED);
    }




    @PostMapping("/loadDroneWithMed/{Id}")
    public ResponseEntity<Drone> loadDroneWithMedication(@PathVariable("Id") Long Id ,@RequestBody List<Long> medicationId ) throws DroneNotAvailableException, DroneLimitExceededException {
        return  new ResponseEntity<>(droneService.loadDroneWithMed(Id,medicationId),HttpStatus.ACCEPTED);
    }
    @GetMapping("/findAllDrone")
    public List<Drone> findAllDrone(){
        return droneService.findAllDrone();
    }
    @GetMapping("/checkBattery/{id}")
    public Long getBateryPercentage(@PathVariable("id") Long id) throws DroneNotAvailableException {
        return droneService.checkBatteryPercentage(id);
    }

    @GetMapping("/checkLoadedItems/{Id}")
    public ResponseEntity<Drone> checkLoadedItems(@PathVariable("Id") Long Id) throws DroneNotAvailableException {
        return new ResponseEntity<>(droneService.checkLoadedItems(Id),HttpStatus.OK);
    }
    @GetMapping("/checkAvaliableDrone")
    public ResponseEntity<List<Drone>> checkAvaliableDrone(){
        return new ResponseEntity<>(droneService.getAvailableDrone(),HttpStatus.OK);
    }
}
