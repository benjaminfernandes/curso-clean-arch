package com.cursocleanarch.ms.ride.Ride.unit;

import com.cursocleanarch.ms.ride.Ride.domain.driver.Driver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {

    @Test
    public void deveCriarUmMotorista() {
        var driver = Driver.create("João da Silva", "joaosilva@gmail.com", "83432616074", "AAA9999");
        assertNotNull(driver.getDriverId());
        assertEquals("João da Silva", driver.getName());
        assertEquals("joaosilva@gmail.com", driver.getEmail().getValue());
        assertEquals("83432616074", driver.getDocument().value());
        assertEquals("AAA9999", driver.getCarPlate().getValue());
    }

    @Test
    public void deveLancarExcecaoDeCPFInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Driver.create("John Doe", "john.doe@gmail.com", "83432616076", "AAA9999");
        });
    }

    @Test
    public void deveLancarExcecaoDeEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Driver.create("John Doe", "john.doe@gmail", "83432616074", "AAA9999");
        });
    }

    @Test
    public void deveLancarExcecaoDePlacaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            Driver.create("John Doe", "john.doe@gmail.com", "83432616076", "AAA999");
        });
    }
}
