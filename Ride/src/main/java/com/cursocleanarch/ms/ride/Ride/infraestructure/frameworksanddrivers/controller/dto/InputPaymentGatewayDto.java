package com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.controller.dto;

import com.cursocleanarch.ms.ride.Ride.application.dto.gateway.InputPaymentGateway;
import jakarta.validation.constraints.NotBlank;

public class InputPaymentGatewayDto {

    @NotBlank
    private final String name;
    @NotBlank
    private final String email;
    @NotBlank
    private final double number;

    public InputPaymentGatewayDto(String name, String email, double number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getNumber() {
        return number;
    }

    public InputPaymentGateway toModelUseCase(){
        return new InputPaymentGateway(getName(), getEmail(), getNumber());
    }
}
