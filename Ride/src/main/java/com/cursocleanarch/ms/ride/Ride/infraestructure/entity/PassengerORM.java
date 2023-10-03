package com.cursocleanarch.ms.ride.Ride.infraestructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "passenger")
@NoArgsConstructor
@Getter
public class PassengerORM {
    @Id
    @Column(name = "passenger_id")
    private UUID passengerId;
    private String name;
    private String email;
    private String document;

    public static PassengerORM create(UUID driverId, String name, String email, String document){
        return new PassengerORM(driverId, name, email, document);
    }
    public PassengerORM(UUID passengerId, String name, String email, String document) {
        this.passengerId = passengerId;
        this.name = name;
        this.email = email;
        this.document = document;
    }

}
