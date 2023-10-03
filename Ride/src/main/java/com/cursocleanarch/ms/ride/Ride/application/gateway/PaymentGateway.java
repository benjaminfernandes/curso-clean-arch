package com.cursocleanarch.ms.ride.Ride.application.gateway;

import com.cursocleanarch.ms.ride.Ride.application.dto.gateway.InputPaymentGateway;
import com.cursocleanarch.ms.ride.Ride.application.dto.gateway.OutputPaymentGateway;

public interface PaymentGateway {
    OutputPaymentGateway process(InputPaymentGateway input);
}
