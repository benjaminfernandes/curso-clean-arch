package com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.datasources;

import com.cursocleanarch.ms.ride.Ride.domain.driver.Driver;
import com.cursocleanarch.ms.ride.Ride.infraestructure.entity.DriverORM;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.DriverDataSourceLocal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

//FRAMEWORKS AND DRIVERS
@Repository
public class DriverDataSourceLocalImpl implements DriverDataSourceLocal {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Driver save(Driver driver) {
        var driverEntity = DriverORM.create(driver.getDriverId(), driver.getName(), driver.getEmail().value(),
                driver.getDocument().value(), driver.getCarPlate().value());
        this.entityManager.merge(driverEntity);
        return new Driver(driverEntity.getDriverId(), driverEntity.getName(), driverEntity.getEmail(),
                driverEntity.getDocument(), driverEntity.getCarPlate());
    }

    @Override
    public Driver get(UUID driverId) {
        var driverORM = this.entityManager.find(DriverORM.class, driverId);
        return new Driver(driverORM.getDriverId(), driverORM.getName(), driverORM.getEmail(),
                driverORM.getDocument(), driverORM.getCarPlate());
    }
}
