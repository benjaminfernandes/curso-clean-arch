package com.cursocleanarch.ms.ride.Ride.integration;

import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input.CreatePassengerInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.passenger.input.GetPassengerInput;
import com.cursocleanarch.ms.ride.Ride.application.usecase.passenger.CreatePassenger;
import com.cursocleanarch.ms.ride.Ride.application.usecase.passenger.GetPassenger;
import com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.datasources.PassengerDataSourceLocalImpl;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository.PassengerRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
public class CreatePassengerTest {

    @Autowired
    private PassengerDataSourceLocalImpl passengerDataSourceLocal;

    @Test
    @DirtiesContext
    public void deveCriarOPassageiro() {
        var input = new CreatePassengerInput("John Doe", "johndoe@gmail.com", "06904816910");
        var usecase = new CreatePassenger(new PassengerRepositoryImpl(passengerDataSourceLocal));
        var output = usecase.execute(input);
        assertNotNull(output.passengerId());

    }

    @Test
    public void deveLancarExcecaoDeCpf() {
        var input = new CreatePassengerInput("John Doe", "johndoe@gmail.com", "10022255566");
        var usecase = new CreatePassenger(new PassengerRepositoryImpl(passengerDataSourceLocal));
        Assertions.assertThrows(IllegalArgumentException.class, () -> usecase.execute(input));
    }

    @Test
    public void deveLancarExcecaoDeEmail() {
        var input = new CreatePassengerInput("John Doe", "johndoe@gmail", "06904816910");
        var usecase = new CreatePassenger(new PassengerRepositoryImpl(passengerDataSourceLocal));
        Assertions.assertThrows(IllegalArgumentException.class, () -> usecase.execute(input));
    }

    @Test
    public void deveObterOPassageiro() {
        var input = new CreatePassengerInput("John Doe", "johndoe@gmail.com", "06904816910");
        var usecase = new CreatePassenger(new PassengerRepositoryImpl(passengerDataSourceLocal));
        var output = usecase.execute(input);

        var useCaseGet = new GetPassenger(new PassengerRepositoryImpl(passengerDataSourceLocal));
        var inputGet = new GetPassengerInput(output.passengerId());
        var outputGet = useCaseGet.execute(inputGet);
        Assertions.assertEquals(outputGet.getName(), "John Doe");
        Assertions.assertEquals(outputGet.getEmail(), "johndoe@gmail.com");
        Assertions.assertEquals(outputGet.getDocument(), "06904816910");

    }

}
