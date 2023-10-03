package com.cursocleanarch.ms.ride.Ride.domain.ride;

import com.cursocleanarch.ms.ride.Ride.domain.distance.Coord;
import com.cursocleanarch.ms.ride.Ride.domain.distance.DistanceCalculator;
import com.cursocleanarch.ms.ride.Ride.domain.fare.chain_of_responsability.*;
import com.cursocleanarch.ms.ride.Ride.domain.ride.status.RideStatus;
import com.cursocleanarch.ms.ride.Ride.domain.ride.status.RideStatusFactory;
import com.cursocleanarch.ms.ride.Ride.domain.ride.status.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ride {

    private UUID rideId;
    private UUID passengerId;
    private RideStatus status;
    private UUID driverId;
    private LocalDateTime requestDate;
    private LocalDateTime acceptDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Position> positions;
    private Coord to;
    private Coord from;
    private final FareCalculatorHandler fareCalculator;
    private static final Double MIN_PRICE = 10.0;

    public Ride(UUID rideId, UUID passengerId, Coord from, Coord to, Status status, LocalDateTime requestDate) {
        this.rideId = rideId;
        this.passengerId = passengerId;
        this.to = to;
        this.from = from;
        this.positions = new ArrayList<>();
        this.status = RideStatusFactory.create(this, status);
        this.requestDate = requestDate;
        var overnightSundayFareCalculator = new OvernightSundayFareCalculatorHandler();
		var sundayFareCalculator = new SundayFareCalculatorHandler(overnightSundayFareCalculator);
		var overnightFareCalculator = new OvernightFareCalculatorHandler(sundayFareCalculator);
        this.fareCalculator = new NormalFareCalculatorHandler(overnightFareCalculator);
    }

    public Ride(Coord from, Coord to) {
        this.positions = new ArrayList<>();
        this.status = RideStatusFactory.create(this, Status.REQUESTED);
        var overnightSundayFareCalculator = new OvernightSundayFareCalculatorHandler();
        var sundayFareCalculator = new SundayFareCalculatorHandler(overnightSundayFareCalculator);
        var overnightFareCalculator = new OvernightFareCalculatorHandler(sundayFareCalculator);
        this.fareCalculator = new NormalFareCalculatorHandler(overnightFareCalculator);
    }

    public void addPosition(double latitude, double longitude, LocalDateTime date){
        this.positions.add(new Position(latitude, longitude, date));
    }

    public double calculate() {
        double price = 0;

        for (int index = 0; index < positions.size() - 1; index++) {
            Position position = positions.get(index);
            Position nextPosition = positions.get(index + 1);
            double distance = DistanceCalculator.calculate(position.getCoord(), nextPosition.getCoord());
            Segment segment = new Segment(distance, nextPosition.getDate());
            price += fareCalculator.handle(segment);
        }
        return (price < MIN_PRICE) ? MIN_PRICE : price;
    }

    public void requested (LocalDateTime date) {
        this.status.request();
        this.requestDate = date;
    }
    public void accept (UUID driverId, LocalDateTime date) {
        this.driverId = driverId;
        this.status.accept();
        this.acceptDate = date;
    }

    public void start (LocalDateTime date) {
        this.status.start();
        this.startDate = date;
    }

    public void end (LocalDateTime date) {
        this.status.end();
        this.endDate = date;
    }

    public static Ride create(UUID passengerId, Coord from, Coord to) {
        var rideId = UUID.randomUUID();
        var requestDate = LocalDateTime.now();
        Status status = Status.REQUESTED;
        return new Ride(rideId, passengerId, from, to, status, requestDate);
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public UUID getDriverId() {
        return driverId;
    }

    public UUID getRideId() {
        return rideId;
    }

    public UUID getPassengerID() {
        return passengerId;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public LocalDateTime getAcceptDate() {
        return acceptDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Coord getTo() {
        return to;
    }

    public Coord getFrom() {
        return from;
    }

    public void setDriverId(UUID driverId) {
        this.driverId = driverId;
    }
}
