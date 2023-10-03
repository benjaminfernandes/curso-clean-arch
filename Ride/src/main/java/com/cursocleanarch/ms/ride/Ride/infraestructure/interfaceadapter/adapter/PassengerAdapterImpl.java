package com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.adapter;

import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input.CreatePassengerInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input.GetPassengerInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.output.CreatePassengerOutput;
import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.output.GetPassengerOutput;
import com.cursocleanarch.ms.ride.Ride.application.factory.UseCaseFactory;
import com.cursocleanarch.ms.ride.Ride.application.usecase.passenger.CreatePassenger;
import com.cursocleanarch.ms.ride.Ride.application.usecase.passenger.GetPassenger;

//Camada Interface adapters
public class PassengerAdapterImpl implements PassengerAdapter {

    private final CreatePassenger createPassenger;
    private final GetPassenger getPassenger;

    public PassengerAdapterImpl(UseCaseFactory useCaseFactory) {
        this.createPassenger = useCaseFactory.createCreatePassenger();
        this.getPassenger = useCaseFactory.createGetPassenger();
    }

    @Override
    public CreatePassengerOutput createPassenger(CreatePassengerInput input) {
       return this.createPassenger.execute(input);
    }

    @Override
    public GetPassengerOutput getPassenger(GetPassengerInput input) {
        return this.getPassenger.execute(input);
    }

}
