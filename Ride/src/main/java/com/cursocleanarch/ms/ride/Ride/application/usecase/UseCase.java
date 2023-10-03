package com.cursocleanarch.ms.ride.Ride.application.usecase;

public interface UseCase<I,O> {

    public O execute(I input);
}
