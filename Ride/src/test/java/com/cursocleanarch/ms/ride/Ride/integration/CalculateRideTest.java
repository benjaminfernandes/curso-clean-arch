package com.cursocleanarch.ms.ride.Ride.integration;

import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.CalculateRideInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.PositionInput;
import com.cursocleanarch.ms.ride.Ride.application.usecase.ride.CalculateRide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootTest
public class CalculateRideTest {

    @Test
    public void deveFazerOCalculoDoPrecoDeUmaCorridaDuranteODia() {
        var positionsInput = new ArrayList<PositionInput>();
        positionsInput.add(new PositionInput(-27.584905257808835, -48.545022195325124, LocalDateTime.of(2021,03,01,10,00,00)));
        positionsInput.add(new PositionInput(-27.496887588317275, -48.522234807851476, LocalDateTime.of(2021,03,01,10,00,00)));
        var calculateRideInput = new CalculateRideInput(positionsInput);

        var useCase = new CalculateRide();
        var output = useCase.execute(calculateRideInput);
        Assertions.assertEquals(output.getPrice(), 21.0);

    }
}
