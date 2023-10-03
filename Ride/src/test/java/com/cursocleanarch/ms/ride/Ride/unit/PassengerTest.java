package com.cursocleanarch.ms.ride.Ride.unit;

import com.cursocleanarch.ms.ride.Ride.domain.passenger.Passenger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PassengerTest {

    @Test
    public void deveCriarUmPassageiro() {
        var passenger = Passenger.create("John Doe", "john.doe@gmail.com", "83432616074");
        assertNotNull(passenger.getPassengerId());
        assertEquals(passenger.getName(), "John Doe");
        assertEquals(passenger.getEmail().value(), "john.doe@gmail.com");
        assertEquals(passenger.getDocument().value(), "83432616074");
    }

    @Test
    public void deveLancarExcecaoDeCPFInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Passenger.create("John Doe", "john.doe@gmail.com", "83432616076");
        });
    }

    @Test
    public void deveLancarExcecaoDeEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Passenger.create("John Doe", "john.doe@gmail", "83432616074");
        });
    }

}
