package com.cursocleanarch.ms.ride.Ride.application.dto.ride.input;

import java.time.LocalDateTime;

public class PositionInput {

    private double latitude;
    private double longitude;
    private LocalDateTime date;

    public PositionInput(double latitude, double longitude, LocalDateTime date) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
    }

    public PositionInput(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
