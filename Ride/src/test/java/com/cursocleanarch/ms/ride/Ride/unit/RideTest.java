package com.cursocleanarch.ms.ride.Ride.unit;

import com.cursocleanarch.ms.ride.Ride.domain.distance.Coord;
import com.cursocleanarch.ms.ride.Ride.domain.ride.Ride;
import com.cursocleanarch.ms.ride.Ride.domain.ride.status.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RideTest {

    @Test
    public void deveFazerOCalculoDoPrecoDeUmaCorridaDuranteODia() {
        var ride = new Ride(new Coord(0,0), new Coord(0,0));
        ride.addPosition(-27.584905257808835, -48.545022195325124, LocalDateTime.of(2021,03,01,10,00));
        ride.addPosition(-27.496887588317275, -48.522234807851476, LocalDateTime.of(2021,03,01,10,00));
        Assertions.assertEquals(ride.calculate(), 21);
    }

    @Test
    public void deveFazerOCalculoDoPrecoDeUmaCorridaDuranteANoite() {
        var ride = new Ride(new Coord(0,0), new Coord(0,0));
        ride.addPosition(-27.584905257808835, -48.545022195325124, LocalDateTime.of(2021,03,01,23,00));
        ride.addPosition(-27.496887588317275, -48.522234807851476, LocalDateTime.of(2021,03,01,23,00));
        Assertions.assertEquals(ride.calculate(), 39);
    }

    @Test
    public void deveFazerOCalculoDoPrecoDeUmaCorridaNoDomingoDeDia() {
        var ride = new Ride(new Coord(0,0), new Coord(0,0));
        ride.addPosition(-27.584905257808835, -48.545022195325124, LocalDateTime.of(2021,03,07,10,00));
        ride.addPosition(-27.496887588317275, -48.522234807851476, LocalDateTime.of(2021,03,07,10,00));
        Assertions.assertEquals(ride.calculate(), 29);
    }

    @Test
    public void deveFazerOCalculoDoPrecoDeUmaCorridaNoDomingoDeNoite() {
        var ride = new Ride(new Coord(0,0), new Coord(0,0));
        ride.addPosition(-27.584905257808835, -48.545022195325124, LocalDateTime.of(2021,03,07,23,00));
        ride.addPosition(-27.496887588317275, -48.522234807851476, LocalDateTime.of(2021,03,07,23,00));
        Assertions.assertEquals(ride.calculate(), 50);
    }

    @Test
    public void deveFazerOCalculoDoPrecoDeUmaCorridaComPrecoMinimo() {
        var ride = new Ride(new Coord(0,0), new Coord(0,0));
        ride.addPosition(-27.584905257808835, -48.545022195325124, LocalDateTime.of(2021,03,07,10,00));
        Assertions.assertEquals(ride.calculate(), 10);
    }

    @Test
    public void deveLancarUmErroSeADataForInvalida() {
        var ride = new Ride(new Coord(0,0), new Coord(0,0));
        ride.addPosition(-27.584905257808835, -48.545022195325124, null);
        ride.addPosition(-27.496887588317275, -48.522234807851476, null);
        assertThrows(IllegalArgumentException.class, ride::calculate);
    }

    @Test
    public void deveSolicitarUmaCorrida() {
        var ride = Ride.create(UUID.randomUUID(), new Coord(0,0), new Coord(0,0));
        Assertions.assertEquals(ride.getStatus().getValue(), Status.REQUESTED);
    }
    @Test
    public void deveAceitarUmaCorrida() {
        var ride = Ride.create(UUID.randomUUID(), new Coord(0,0), new Coord(0,0));
        ride.accept(UUID.randomUUID(), LocalDateTime.now());
        Assertions.assertEquals(ride.getStatus().getValue(), Status.ACCEPTED);
    }

    @Test
    public void deveIniciarUmaCorrida() {
        var ride = Ride.create(UUID.randomUUID(), new Coord(0,0), new Coord(0,0));
        ride.accept(UUID.randomUUID(), LocalDateTime.now());
        ride.start(LocalDateTime.now());
        Assertions.assertEquals(ride.getStatus().getValue(), Status.IN_PROGRESS);
    }

    @Test
    public void deveFinalizarUmaCorrida() {
        var ride = Ride.create(UUID.randomUUID(), new Coord(0,0), new Coord(0,0));
        ride.accept(UUID.randomUUID(), LocalDateTime.now());
        ride.start(LocalDateTime.now());
        ride.end(LocalDateTime.now());
        Assertions.assertEquals(ride.getStatus().getValue(), Status.COMPLETED);
    }
    @Test
    public void naoDeveIniciarCorridaSeNaoTiverSidoAceita() {
        var ride = Ride.create(UUID.randomUUID(), new Coord(0,0), new Coord(0,0));
        assertThrows(IllegalArgumentException.class, () ->
                ride.start(LocalDateTime.now())
        );
    }

    @Test
    public void naoDeveEncerrarCorridaSeTiverSidoIniciada() {
        var ride = Ride.create(UUID.randomUUID(), new Coord(0,0), new Coord(0,0));
        assertThrows(IllegalArgumentException.class, () ->
                ride.end(LocalDateTime.now())
        );
    }


}
