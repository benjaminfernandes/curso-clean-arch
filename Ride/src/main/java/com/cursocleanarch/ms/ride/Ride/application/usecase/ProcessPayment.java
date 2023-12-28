package com.cursocleanarch.ms.ride.Ride.application.usecase;

import com.cursocleanarch.ms.ride.Ride.application.dto.gateway.InputPaymentGateway;
import com.cursocleanarch.ms.ride.Ride.application.gateway.PaymentGateway;
import com.cursocleanarch.ms.ride.Ride.application.repository.TransactionRepository;
import com.cursocleanarch.ms.ride.Ride.domain.transaction.Transaction;

public class ProcessPayment {

    private final PaymentGateway paymentGateway;
    private final TransactionRepository transactionRepository;

    public ProcessPayment(PaymentGateway paymentGateway, TransactionRepository transactionRepository) {
        this.paymentGateway = paymentGateway;
        this.transactionRepository = transactionRepository;
    }

    public void execute(InputPaymentGateway input) {
        var outputPaymentGateway = this.paymentGateway.process(input);
        var transaction = new Transaction(outputPaymentGateway.getTransactionalId(), input.getNumber(),
                input.getName(),
                input.getEmail());
        this.transactionRepository.save(transaction);
    }
}
