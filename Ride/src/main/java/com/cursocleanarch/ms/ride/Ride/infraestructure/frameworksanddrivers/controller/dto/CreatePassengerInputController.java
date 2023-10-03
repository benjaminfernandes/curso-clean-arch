package com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.controller.dto;

import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input.CreatePassengerInput;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePassengerInputController {

    @NotBlank(message = "Nome é obrigatorio")
    private final String name;
    @NotBlank(message = "email é obrigatorio")
    private final String email;
    @NotBlank(message = "document é obrigatorio")
    private final String document;

    public CreatePassengerInput convert(){
        return new CreatePassengerInput(this.name, this.email, this.document);
    }
}
