package com.cursocleanarch.ms.ride.Ride.application.usecase.driver;

import com.cursocleanarch.ms.ride.Ride.application.dto.driver.input.GetDriverInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.driver.output.GetDriverOutput;
import com.cursocleanarch.ms.ride.Ride.application.repository.DriverRepository;
import com.cursocleanarch.ms.ride.Ride.application.usecase.UseCase;


public class GetDriver implements UseCase<GetDriverInput, GetDriverOutput> {

    private DriverRepository driverRepository;

    public GetDriver(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public GetDriverOutput execute(GetDriverInput input) {
        var driver = this.driverRepository.get(input.getDriverId());
        return new GetDriverOutput(driver.getDriverId(), driver.getName(), driver.getEmail().getValue(), driver.getDocument().value(), driver.getCarPlate().value());
    }
}
