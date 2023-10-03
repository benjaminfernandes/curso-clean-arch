package com.cursocleanarch.ms.ride.Ride.application.dto.ride.request_ride;

import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.PositionInput;

import java.time.LocalDateTime;
import java.util.UUID;

public class RequestRideInput {

    private UUID passengerId;
    private PositionInput from;
    private PositionInput to;
    private LocalDateTime date;

    public RequestRideInput(UUID passengerId, PositionInput from, PositionInput to, LocalDateTime date) {
        this.passengerId = passengerId;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public UUID getPassengerId() {
        return passengerId;
    }

    public PositionInput getFrom() {
        return from;
    }

    public PositionInput getTo() {
        return to;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
