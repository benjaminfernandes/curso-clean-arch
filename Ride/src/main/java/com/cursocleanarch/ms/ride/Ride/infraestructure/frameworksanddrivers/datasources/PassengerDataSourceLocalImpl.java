package com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.datasources;

import com.cursocleanarch.ms.ride.Ride.domain.passenger.Passenger;
import com.cursocleanarch.ms.ride.Ride.infraestructure.entity.PassengerORM;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.PassengerDataSourceLocal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class PassengerDataSourceLocalImpl implements PassengerDataSourceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Passenger save(Passenger passenger) {
        var passengerORM = PassengerORM.create(passenger.getPassengerId(), passenger.getName(),
                passenger.getEmail().value(), passenger.getDocument().value());

        this.entityManager.merge(passengerORM);
        return new Passenger(passengerORM.getPassengerId(), passengerORM.getName(),
                passengerORM.getEmail(), passengerORM.getDocument());
    }

    @Override
    public Passenger get(UUID passengerID) {
        var passengerORM = this.entityManager.find(PassengerORM.class, passengerID);
        return new Passenger(passengerORM.getPassengerId(), passengerORM.getName(), passengerORM.getEmail(),
                passengerORM.getDocument());
    }
}
