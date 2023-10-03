package com.cursocleanarch.ms.ride.Ride.application.dto.ride.output;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;
import com.cursocleanarch.ms.ride.Ride.domain.ride.status.RideStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class GetRideOutput {

    private final UUID rideId;
    private final UUID driverId;
    private final String driverName;
    private final UUID passengerId;
    private final String passengerName;
    private final RideStatus rideStatus;
    private final LocalDateTime requestDate;
    private final LocalDateTime acceptDate;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public GetRideOutput(Ride ride, String driverName, String passengerName) {
        this.rideId = ride.getRideId();
        this.driverId = ride.getDriverId();
        this.passengerId = ride.getPassengerID();
        this.rideStatus = ride.getStatus();
        this.requestDate = ride.getRequestDate();
        this.acceptDate = ride.getAcceptDate();
        this.startDate = ride.getStartDate();
        this.endDate = ride.getEndDate();
        this.driverName = driverName;
        this.passengerName = passengerName;
    }

    public UUID getRideId() {
        return rideId;
    }

    public UUID getDriverId() {
        return driverId;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public LocalDateTime getAcceptDate() {
        return acceptDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getDriverName() {
        return driverName;
    }

    public UUID getPassengerId() {
        return passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }
}
