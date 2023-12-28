package com.cursocleanarch.ms.ride.Ride.integration;

import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input.CreatePassengerInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.GetRideInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.PositionInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.request_ride.RequestRideInput;
import com.cursocleanarch.ms.ride.Ride.application.factory.RepositoryFactory;
import com.cursocleanarch.ms.ride.Ride.application.usecase.passenger.CreatePassenger;
import com.cursocleanarch.ms.ride.Ride.domain.ride.status.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class RequestRideTest {

    //@Autowired
    //private PassengerDataSourceLocalImpl passengerDataSourceLocal;
    //@Autowired
    //private RideDataSourceLocalImpl rideDataSourceLocal;
    @Autowired
    private RepositoryFactory repositoryFactory;

    @Test
    public void deveSolicitarUmaCorrida() {
        var inputCreatePassenger = new CreatePassengerInput("John Doe", "johndoe@gmail.com", "83432616074");
        //var createPassenger = new CreatePassenger(new PassengerRepositoryImpl(passengerDataSourceLocal));
        var createPassenger = new CreatePassenger(this.repositoryFactory.createPassengerRepository());
        var outputCreatePassenger = createPassenger.execute(inputCreatePassenger);

        var inputRequestRide = new RequestRideInput(outputCreatePassenger.passengerId(), new PositionInput(-27.584905257808835, -48.545022195325124),
                new PositionInput(-27.496887588317275, -48.522234807851476), LocalDateTime.now());

        //var requestRide = new RequestRide(new RideRepositoryImpl(rideDataSourceLocal));
        var requestRide = new RequestRide(this.repositoryFactory.createRideRepository());
        var outputRequestRide = requestRide.execute(inputRequestRide);

        Assertions.assertNotNull(outputRequestRide.getRideId());
    }

    @Test
    public void deveObterUmaCorrida() {
        var inputCreatePassenger = new CreatePassengerInput("John Doe", "johndoe@gmail.com", "83432616074");
        //var createPassenger = new CreatePassenger(new PassengerRepositoryImpl(passengerDataSourceLocal));
        var createPassenger = new CreatePassenger(this.repositoryFactory.createPassengerRepository());
        var outputCreatePassenger = createPassenger.execute(inputCreatePassenger);

        var inputRequestRide = new RequestRideInput(outputCreatePassenger.passengerId(), new PositionInput(-27.584905257808835, -48.545022195325124),
                new PositionInput(-27.496887588317275, -48.522234807851476), LocalDateTime.now());

        //var requestRide = new RequestRide(new RideRepositoryImpl(rideDataSourceLocal));
        var requestRide = new RequestRide(this.repositoryFactory.createRideRepository());
        var outputRequestRide = requestRide.execute(inputRequestRide);

        var getRide = new GetRide(this.repositoryFactory);
        var inputGetRide = new GetRideInput(outputRequestRide.getRideId());
        var outputGetRide = getRide.execute(inputGetRide);

        Assertions.assertNotNull(outputGetRide.getRideId());
        Assertions.assertEquals(outputGetRide.getRideStatus().getValue(), Status.REQUESTED);

    }

}
