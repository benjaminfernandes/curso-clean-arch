package com.cursocleanarch.ms.ride.Ride.unit;

import com.cursocleanarch.ms.ride.Ride.domain.driver.CarPlate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarPlateTest {

    @Test
    public void deveTestarUmaPlacaValida() {
        var carPlate = new CarPlate("AAA9999");
        Assertions.assertNotNull(carPlate);
    }

    @Test
    public void deveLancarExcecaoDePlacaInvalida() {
        Assertions.assertThrows(RuntimeException.class, () -> new CarPlate("aa999"));
    }

}
