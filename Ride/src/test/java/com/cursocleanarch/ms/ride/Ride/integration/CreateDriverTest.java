package com.cursocleanarch.ms.ride.Ride.integration;

import com.cursocleanarch.ms.ride.Ride.application.dto.driver.input.CreateDriverInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.driver.input.GetDriverInput;
import com.cursocleanarch.ms.ride.Ride.application.usecase.driver.CreateDriver;
import com.cursocleanarch.ms.ride.Ride.application.usecase.driver.GetDriver;
import com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.datasources.DriverDataSourceLocalImpl;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository.DriverRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
public class CreateDriverTest {

    @Autowired
    private DriverDataSourceLocalImpl jpaDriverRepository;

    @Test
    @DirtiesContext
    public void deveCadastrarOMotorista() {
        var input = new CreateDriverInput("John doe","johmdoe@gmail.com","83432616074","AAA9999");
        var useCase = new CreateDriver(new DriverRepositoryImpl(jpaDriverRepository));
        var output = useCase.execute(input);
        assertNotNull(output.getDriverId());
    }

    @Test
    @DirtiesContext
    public void deveObterOMotorista() {
        var input = new CreateDriverInput("John doe","johmdoe@gmail.com","83432616074","AAA9999");
        var useCase = new CreateDriver(new DriverRepositoryImpl(jpaDriverRepository));
        var output = useCase.execute(input);

        var useCaseGet = new GetDriver(new DriverRepositoryImpl(jpaDriverRepository));
        var inputGet = new GetDriverInput(output.getDriverId());
        var outputGet = useCaseGet.execute(inputGet);
        assertEquals(outputGet.getName(), "John doe");
        assertEquals(outputGet.getEmail(), "johmdoe@gmail.com");
        assertEquals(outputGet.getDocument(), "83432616074");
        assertEquals(outputGet.getCarPlate(), "AAA9999");
        //fazer
    }

}
