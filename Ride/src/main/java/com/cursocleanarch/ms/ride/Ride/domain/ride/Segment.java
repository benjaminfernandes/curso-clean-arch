package com.cursocleanarch.ms.ride.Ride.domain.ride;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Segment {
    private final Double distance;
    private final LocalDateTime date;

    public Segment(Double distance, LocalDateTime date) {
        this.distance = distance;
        this.date = date;
        if (!this.isValidDistance()) throw new IllegalArgumentException("Invalid distance");
        if (!this.isValidDate()) throw new IllegalArgumentException("Invalid date");
    }
    public boolean isOvernight () {
        return this.date.getHour() >= 22 || this.date.getHour() <= 6;
    }

    public boolean isSunday () {
        return this.date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    public boolean isValidDistance () {
        return this.distance > 0;
    }

    public boolean isValidDate () {
        return this.date != null;
    }

    public Double getDistance() {
        return distance;
    }
}
