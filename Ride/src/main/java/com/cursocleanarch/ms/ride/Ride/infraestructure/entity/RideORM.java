package com.cursocleanarch.ms.ride.Ride.infraestructure.entity;

import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;
import com.cursocleanarch.ms.ride.Ride.domain.ride.status.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ride")
@NoArgsConstructor
@Getter
public class RideORM {

    public static RideORM create(UUID rideId, Status status, UUID passengerId, LocalDateTime requestDate, double fromLat, double fromLong, double toLat, double toLong){
        return new RideORM(rideId, status, passengerId, requestDate, fromLat, fromLong, toLat, toLong);
    }

    public RideORM(UUID rideId, Status status, UUID passengerId, LocalDateTime requestDate, double fromLat, double fromLong, double toLat, double toLong) {
        this.rideId = rideId;
        this.status = status;
        this.passengerId = passengerId;
        this.requestDate = requestDate;
        this.fromLat = fromLat;
        this.fromLong = fromLong;
        this.toLat = toLat;
        this.toLong = toLong;
    }
    public RideORM(Ride ride) {
        this.rideId = ride.getRideId();
        this.status = ride.getStatus().getValue();
        this.passengerId = ride.getPassengerID();
        this.requestDate = ride.getRequestDate();
        this.fromLat = ride.getFrom().getLatitude();
        this.fromLong = ride.getFrom().getLongitude();
        this.toLat = ride.getTo().getLatitude();
        this.toLong = ride.getTo().getLongitude();
        this.driverId = ride.getDriverId();
    }

    @Id
    private UUID rideId;
    @Enumerated(EnumType.STRING)
    private Status status;
    private UUID passengerId;
    private UUID driverId;
    private LocalDateTime requestDate;
    private LocalDateTime acceptDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double fromLat;
    private double fromLong;
    private double toLat;
    private double toLong;
}
