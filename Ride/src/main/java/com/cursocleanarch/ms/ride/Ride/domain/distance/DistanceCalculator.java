package com.cursocleanarch.ms.ride.Ride.domain.distance;

public class DistanceCalculator {

    public static long calculate(Coord from, Coord to) {
        var earthRadius = 6371;
		var degreesToRadians = Math.PI / 180;
		var deltaLat = (to.getLatitude() - from.getLatitude()) * degreesToRadians;
		var deltaLon = (to.getLongitude() - from.getLongitude()) * degreesToRadians;
		var a =
                Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                        Math.cos(from.getLatitude() * degreesToRadians) *
                                Math.cos(to.getLatitude() * degreesToRadians) *
                                Math.sin(deltaLon / 2) *
                                Math.sin(deltaLon / 2);
		var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		var distance = earthRadius * c;
        return Math.round(distance);
    }
}
