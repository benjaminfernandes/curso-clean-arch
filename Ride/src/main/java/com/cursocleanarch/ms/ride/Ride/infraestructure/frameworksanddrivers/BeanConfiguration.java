package com.cursocleanarch.ms.ride.Ride.infraestructure.frameworksanddrivers;

import com.cursocleanarch.ms.ride.Ride.application.factory.RepositoryFactory;
import com.cursocleanarch.ms.ride.Ride.application.factory.UseCaseFactory;
import com.cursocleanarch.ms.ride.Ride.application.usecase.passenger.CreatePassenger;
import com.cursocleanarch.ms.ride.Ride.application.usecase.passenger.GetPassenger;
import com.cursocleanarch.ms.ride.Ride.infraestructure.factory.RepositoryFactoryImpl;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.adapter.PassengerAdapter;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.adapter.PassengerAdapterImpl;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.DriverDataSourceLocal;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.PassengerDataSourceLocal;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.datasources.RideDataSourceLocal;
import com.cursocleanarch.ms.ride.Ride.infraestructure.interfaceadapter.repository.PassengerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Autowired
    private PassengerDataSourceLocal passengerDataSourceLocal;
    @Autowired
    private RideDataSourceLocal rideDataSourceLocal;
    @Autowired
    private DriverDataSourceLocal driverDataSourceLocal;

    @Bean
    public PassengerRepository passengerRepository(){
        return new PassengerRepositoryImpl(passengerDataSourceLocal);
    }

    @Bean
    public CreatePassenger createPassenger(){
        return new CreatePassenger(passengerRepository());
    }

    @Bean
    public GetPassenger getPassenger(){
        return new GetPassenger(passengerRepository());
    }

    @Bean
    public RepositoryFactory repositoryFactory(){
        return new RepositoryFactoryImpl(this.passengerDataSourceLocal, this.driverDataSourceLocal, this.rideDataSourceLocal);
    }
    @Bean
    public PassengerAdapter passengerAdapter(){
        return new PassengerAdapterImpl(new UseCaseFactory(repositoryFactory()));
    }


}
