package com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.controller;

import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.output.CreatePassengerOutput;
import com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.controller.dto.CreatePassengerInputController;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.adapter.PassengerAdapter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerAdapter passengerAdapter;

    @PostMapping
    public CreatePassengerOutput createPassenger(@RequestBody @Valid CreatePassengerInputController input) {
        return passengerAdapter.createPassenger(input.convert());
    }

}
