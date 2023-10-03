package com.cursocleanarch.ms.ride.Ride.application.usecase.ride;

import com.cursocleanarch.ms.ride.Ride.application.dto.gateway.InputPaymentGateway;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.input.EndRideInput;
import com.cursocleanarch.ms.ride.Ride.application.dto.ride.output.EndRideOutput;
import com.cursocleanarch.ms.ride.Ride.application.gateway.PaymentGateway;
import com.cursocleanarch.ms.ride.Ride.application.repository.PassengerRepository;
import com.cursocleanarch.ms.ride.Ride.application.repository.RideRepository;
import com.cursocleanarch.ms.ride.Ride.application.repository.TransactionRepository;
import com.cursocleanarch.ms.ride.Ride.application.usecase.UseCase;
import com.cursocleanarch.ms.ride.Ride.domain.transaction.Transaction;

public class EndRide implements UseCase<EndRideInput, EndRideOutput> {

    private final RideRepository rideRepository;
    //private final PassengerRepository passengerRepository;
    //private final PaymentGateway paymentGateway;
    private TransactionRepository transactionRepository;

    public EndRide(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
        //this.passengerRepository = passengerRepository;
        //this.paymentGateway = paymentGateway;
        //this.transactionRepository = transactionRepository;
    }

    @Override
    public EndRideOutput execute(EndRideInput input) {
        var ride = this.rideRepository.get(input.getRideId());
        ride.end(input.getDate());
        this.rideRepository.update(ride);
        var amount = ride.calculate();
       /* var passenger = this.passengerRepository.get(ride.getPassengerID());
        var paymentGatewayInput = new InputPaymentGateway(passenger.getName(), passenger.getEmail().value(),
                amount);
        var outputPaymentGateway = this.paymentGateway.process(paymentGatewayInput);
        var transaction = new Transaction(outputPaymentGateway.getTransactionalId(),amount,
                passenger.getName(),
                passenger.getEmail().value());
        this.transactionRepository.save(transaction);*/
        return new EndRideOutput(ride.getRideId());
    }
}
