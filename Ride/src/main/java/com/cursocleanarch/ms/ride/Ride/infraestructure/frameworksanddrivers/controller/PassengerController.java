package com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.controller;

import com.cursocleanarch.ms.ride.Ride.application.usecase.ProcessPayment;
import com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.controller.dto.InputPaymentGatewayDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PassengerController {

    @Autowired
    private ProcessPayment processPayment;

    @PostMapping
    public void processPayment(@RequestBody @Valid InputPaymentGatewayDto input) {
        this.processPayment.execute(input.toModelUseCase());
    }

}
