package com.cursocleanarch.ms.ride.Ride.infraestructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "driver")
@NoArgsConstructor
@Getter
public class DriverORM {
    @Id
    @Column(name = "driver_id")
    private UUID driverId;
    private String name;
    private String email;
    private String document;
    @Column(name = "car_plate")
    private String carPlate;

    public static DriverORM create(UUID driverId, String name, String email, String document, String carPlate){
        return new DriverORM(driverId, name, email, document, carPlate);
    }
    public DriverORM(UUID driverId, String name, String email, String document, String carPlate) {
        this.driverId = driverId;
        this.name = name;
        this.email = email;
        this.document = document;
        this.carPlate = carPlate;
    }

}
