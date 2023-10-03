package com.cursocleanarch.ms.ride.Ride.domain.ride;

import com.cursocleanarch.ms.ride.Ride.domain.distance.Coord;

import java.time.LocalDateTime;

public class Position {

    private Coord coord;
    private LocalDateTime date;

    public Position(double latitude, double longitude, LocalDateTime date) {
        this.coord = new Coord(latitude, longitude);
        this.date = date;
    }

    public Coord getCoord() {
        return coord;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
