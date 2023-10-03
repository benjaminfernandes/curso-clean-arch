package com.cursocleanarch.ms.ride.Ride.domain.driver;

import com.cursocleanarch.ms.ride.Ride.domain.person.Cpf;
import com.cursocleanarch.ms.ride.Ride.domain.person.Email;

import java.util.UUID;

public class Driver {
    private UUID driverId;
    private String name;
    private Email email;
    private Cpf document;
    private CarPlate carPlate;
    public static Driver create(String name, String email, String document, String carPlate){
        var driverId = UUID.randomUUID();
        return new Driver(driverId, name, email, document, carPlate);
    }
    public Driver(UUID driverId, String name, String email, String document, String carPlate) {
        this.driverId = driverId;
        this.name = name;
        this.email = new Email(email);
        this.document = new Cpf(document);
        this.carPlate = new CarPlate(carPlate);
    }
    public UUID getDriverId() {
        return driverId;
    }
    public String getName() {
        return name;
    }
    public Email getEmail() {
        return email;
    }
    public Cpf getDocument() {
        return document;
    }
    public CarPlate getCarPlate() {
        return carPlate;
    }
}
