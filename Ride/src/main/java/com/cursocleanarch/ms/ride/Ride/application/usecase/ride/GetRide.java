package com.cursocleanarch.ms.ride.Ride.application.usecase.ride;

import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.GetRideInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.output.GetRideOutput;
import com.cursocleanarch.ms.ride.Ride.application.factory.RepositoryFactory;
import com.cursocleanarch.ms.ride.Ride.application.repository.DriverRepository;
import com.cursocleanarch.ms.ride.Ride.application.repository.PassengerRepository;
import com.cursocleanarch.ms.ride.Ride.application.repository.RideRepository;
import com.cursocleanarch.ms.ride.Ride.application.usecase.UseCase;

public class GetRide implements UseCase<GetRideInput, GetRideOutput> {

    private final RideRepository rideRepository;
    private final PassengerRepository passengerRepository;
    private final DriverRepository driverRepository;

    public GetRide(RepositoryFactory repositoryFactory) {
        this.rideRepository = repositoryFactory.createRideRepository();
        this.passengerRepository = repositoryFactory.createPassengerRepository();
        this.driverRepository = repositoryFactory.createDriverRepository();
    }

    @Override
    public GetRideOutput execute(GetRideInput input) {
        var ride = this.rideRepository.get(input.getRideId());
        var passengerName = this.passengerRepository.get(ride.getPassengerID()).getName();
        var driverName = "";
        if(ride.getDriverId() != null)
            driverName = this.driverRepository.get(ride.getDriverId()).getName();

        return new GetRideOutput(ride, driverName, passengerName);
    }
}
