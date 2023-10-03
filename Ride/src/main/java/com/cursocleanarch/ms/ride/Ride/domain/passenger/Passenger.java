package com.cursocleanarch.ms.ride.Ride.domain.passenger;

import com.cursocleanarch.ms.ride.Ride.domain.person.Cpf;
import com.cursocleanarch.ms.ride.Ride.domain.person.Email;

import java.util.UUID;

public class Passenger {

    public static Passenger create(String name, String email, String document){
        var passengerId = UUID.randomUUID();
        return new Passenger(passengerId, name, email, document);
    }
    public Passenger(UUID passengerId, String name, String email, String document) {
        this.passengerId = passengerId;
        this.name = name;
        this.email = new Email(email);
        this.document = new Cpf(document);
    }

    private UUID passengerId;
    private String name;
    private Email email;
    private Cpf document;

    public UUID getPassengerId() {
        return passengerId;
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
}
