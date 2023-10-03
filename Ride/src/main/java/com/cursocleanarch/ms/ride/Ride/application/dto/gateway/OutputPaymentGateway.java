package com.cursocleanarch.ms.ride.Ride.application.dto.gateway;

import java.util.UUID;

public class OutputPaymentGateway {

    private final UUID transactionalId;

    public OutputPaymentGateway(UUID transactionalId) {
        this.transactionalId = transactionalId;
    }

    public UUID getTransactionalId() {
        return transactionalId;
    }
}
