package com.cursocleanarch.ms.ride.Ride.unit;

import com.cursocleanarch.ms.ride.Ride.domain.person.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    public void deveValidarEmail() {
        var email = new Email("john.doe@gmail.com");
        Assertions.assertNotNull(email);
    }

    @Test
    public void deveInvalidarEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email("johm.doe@gmail"));
    }
}
