package com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.adapter;

import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input.CreatePassengerInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input.GetPassengerInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.output.CreatePassengerOutput;
import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.output.GetPassengerOutput;

public interface PassengerAdapter {
   CreatePassengerOutput createPassenger(CreatePassengerInput input);
   GetPassengerOutput getPassenger(GetPassengerInput input);
}
