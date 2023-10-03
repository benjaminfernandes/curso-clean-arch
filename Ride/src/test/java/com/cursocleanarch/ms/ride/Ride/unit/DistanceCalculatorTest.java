package com.cursocleanarch.ms.ride.Ride.unit;

import com.cursocleanarch.ms.ride.Ride.domain.distance.Coord;
import com.cursocleanarch.ms.ride.Ride.domain.distance.DistanceCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DistanceCalculatorTest {

    @Test
    public void deveCalcularDistanciaEntreDuascoordenadas () {
	    var from = new Coord(-27.584905257808835, -48.545022195325124);
	    var to = new Coord(-27.496887588317275, -48.522234807851476);
	    var distance = DistanceCalculator.calculate(from, to);
        Assertions.assertEquals(distance, 10, 1);
    }
}
