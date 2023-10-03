package com.cursocleanarch.ms.ride.Ride.application.usecase.passenger;

import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input.CreatePassengerInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.output.CreatePassengerOutput;
import com.cursocleanarch.ms.ride.Ride.application.repository.PassengerRepository;
import com.cursocleanarch.ms.ride.Ride.application.usecase.UseCase;
import com.cursocleanarch.ms.ride.Ride.domain.passenger.Passenger;

public class CreatePassenger implements UseCase<CreatePassengerInput, CreatePassengerOutput> {
    private final PassengerRepository passengerRepository;

    public CreatePassenger(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public CreatePassengerOutput execute(CreatePassengerInput input) {
        var passenger = Passenger.create(input.getName(), input.getEmail(), input.getDocument());
        passenger = this.passengerRepository.save(passenger);
        return new CreatePassengerOutput(passenger.getPassengerId());
    }
}
