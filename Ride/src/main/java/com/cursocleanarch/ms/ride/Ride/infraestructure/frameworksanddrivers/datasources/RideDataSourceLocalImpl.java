package com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers.datasources;

import com.cursocleanarch.ms.ride.Ride.domain.distance.Coord;
import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;
import com.cursocleanarch.ms.ride.Ride.infraestructure.entity.RideORM;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.RideDataSourceLocal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Repository
public class RideDataSourceLocalImpl implements RideDataSourceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Ride ride) {
        var rideORM = RideORM.create(ride.getRideId(), ride.getStatus().getValue(), ride.getPassengerID(), ride.getRequestDate(),
                ride.getFrom().getLatitude(), ride.getFrom().getLongitude(), ride.getTo().getLatitude(), ride.getTo().getLongitude());
        this.entityManager.merge(rideORM);
    }

    @Override
    public Ride get(UUID rideId) {
        var rideORM = this.entityManager.find(RideORM.class, rideId);
        var ride = new Ride(rideORM.getRideId(), rideORM.getPassengerId(), new Coord(rideORM.getFromLat(), rideORM.getFromLong()),
                new Coord(rideORM.getToLat(), rideORM.getToLong()), rideORM.getStatus(), rideORM.getRequestDate());
        ride.setDriverId(rideORM.getDriverId());
        return ride;
    }

    @Transactional
    @Override
    public void update(Ride ride) {
        var rideORM = new RideORM(ride);
        this.entityManager.merge(rideORM);
    }
}
