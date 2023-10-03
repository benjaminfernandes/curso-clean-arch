package com.cursocleanarch.ms.ride.Ride.integration;

import com.cursocleanarch.ms.ride.Ride.application.dto.driver.input.CreateDriverInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input.CreatePassengerInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.AcceptRideInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.GetRideInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.PositionInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.StartRideInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.request_ride.RequestRideInput;
import com.cursocleanarch.ms.ride.Ride.application.factory.RepositoryFactory;
import com.cursocleanarch.ms.ride.Ride.application.usecase.driver.CreateDriver;
import com.cursocleanarch.ms.ride.Ride.application.usecase.passenger.CreatePassenger;
import com.cursocleanarch.ms.ride.Ride.application.usecase.ride.AcceptRide;
import com.cursocleanarch.ms.ride.Ride.application.usecase.ride.GetRide;
import com.cursocleanarch.ms.ride.Ride.application.usecase.ride.RequestRide;
import com.cursocleanarch.ms.ride.Ride.application.usecase.ride.StartRide;
import com.cursocleanarch.ms.ride.Ride.domain.ride.status.Status;
import com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.datasources.DriverDataSourceLocalImpl;
import com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.datasources.PassengerDataSourceLocalImpl;
import com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.datasources.RideDataSourceLocalImpl;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository.DriverRepositoryImpl;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository.PassengerRepositoryImpl;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository.RideRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class StartRideTest {
    @Autowired
    private PassengerDataSourceLocalImpl passengerDataSourceLocal;
    @Autowired
    private RideDataSourceLocalImpl rideDataSourceLocal;
    @Autowired
    private DriverDataSourceLocalImpl driverDataSourceLocal;
    @Autowired
    private RepositoryFactory repositoryFactory;

    @Test
    public void deveIniciarUmaCorrida() {
        var inputCreatePassenger = new CreatePassengerInput("John Doe", "johndoe@gmail.com", "83432616074");
        var createPassenger = new CreatePassenger(new PassengerRepositoryImpl(passengerDataSourceLocal));
        var outputCreatePassenger = createPassenger.execute(inputCreatePassenger);

        var inputRequestRide = new RequestRideInput(outputCreatePassenger.passengerId(), new PositionInput(-27.584905257808835, -48.545022195325124),
                new PositionInput(-27.496887588317275, -48.522234807851476), LocalDateTime.now());

        var requestRide = new RequestRide(new RideRepositoryImpl(rideDataSourceLocal));
        var outputRequestRide = requestRide.execute(inputRequestRide);

        var inputCreateDriver = new CreateDriverInput("John Doe", "johndoe@gmail.com", "83432616074", "AAA9999");
        var createDriver = new CreateDriver(new DriverRepositoryImpl(this.driverDataSourceLocal));
        var outputCreateDriver = createDriver.execute(inputCreateDriver);

        var inputAcceptRide = new AcceptRideInput(outputRequestRide.getRideId(), outputCreateDriver.getDriverId(), LocalDateTime.now());
        var acceptRide = new AcceptRide(new RideRepositoryImpl(this.rideDataSourceLocal));
        acceptRide.execute(inputAcceptRide);

        var inputStartRide = new StartRideInput(outputRequestRide.getRideId(), LocalDateTime.now());
        var startRide = new StartRide(new RideRepositoryImpl(this.rideDataSourceLocal));
        startRide.execute(inputStartRide);

        var getRideInput = new GetRideInput(outputRequestRide.getRideId());
        var getRide = new GetRide(this.repositoryFactory);
        var outputGetRide = getRide.execute(getRideInput);

        Assertions.assertEquals(outputGetRide.getDriverId(), outputCreateDriver.getDriverId());
        Assertions.assertEquals(outputGetRide.getRideStatus().getValue(), Status.IN_PROGRESS);
        //Assertions.assertEquals(outputGetRide.getStartDate(), outputCreateDriver.getDriverId());
    }

}
