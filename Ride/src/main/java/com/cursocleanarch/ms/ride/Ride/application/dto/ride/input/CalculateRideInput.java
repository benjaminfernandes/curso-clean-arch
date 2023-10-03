package com.cursocleanarch.ms.ride.Ride.application.dto.ride.input;

import java.util.List;

public class CalculateRideInput {

    private final List<PositionInput> positions;

    public CalculateRideInput(List<PositionInput> positions) {
        this.positions = positions;
    }

    public List<PositionInput> getPositions() {
        return positions;
    }
}
