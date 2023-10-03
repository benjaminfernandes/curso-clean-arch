package com.cursocleanarch.ms.ride.Ride.application.gateway;

public interface MailGateway {
    void send(String email, String message);
}
