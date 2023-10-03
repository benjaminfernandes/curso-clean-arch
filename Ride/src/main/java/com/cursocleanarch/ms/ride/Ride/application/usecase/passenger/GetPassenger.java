package com.cursocleanarch.ms.ride.Ride.application.usecase.passenger;

import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input.GetPassengerInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.output.GetPassengerOutput;
import com.cursocleanarch.ms.ride.Ride.application.repository.PassengerRepository;
import com.cursocleanarch.ms.ride.Ride.application.usecase.UseCase;

public class GetPassenger implements UseCase<GetPassengerInput, GetPassengerOutput> {

    private PassengerRepository passengerRepository;

    public GetPassenger(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public GetPassengerOutput execute(GetPassengerInput input) {
        var passenger = passengerRepository.get(input.getPassengerId());
        return new GetPassengerOutput(passenger.getPassengerId(), passenger.getName(), passenger.getEmail().value(), passenger.getDocument().value());
    }
}
