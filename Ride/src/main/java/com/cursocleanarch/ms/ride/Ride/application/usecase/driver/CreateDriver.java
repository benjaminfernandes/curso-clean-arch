package com.cursocleanarch.ms.ride.Ride.application.usecase.driver;

import com.cursocleanarch.ms.ride.Ride.application.dto.driver.input.CreateDriverInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.driver.output.CreateDriverOutput;
import com.cursocleanarch.ms.ride.Ride.application.repository.DriverRepository;
import com.cursocleanarch.ms.ride.Ride.application.usecase.UseCase;
import com.cursocleanarch.ms.ride.Ride.domain.driver.Driver;

public class CreateDriver implements UseCase<CreateDriverInput, CreateDriverOutput> {

    final DriverRepository driverRepository;

    public CreateDriver(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public CreateDriverOutput execute(CreateDriverInput input) {
        var driver = Driver.create(input.getName(), input.getEmail(), input.getDocument(), input.getCarPlate());
        driver = this.driverRepository.save(driver);
        return new CreateDriverOutput(driver.getDriverId());
    }
}
