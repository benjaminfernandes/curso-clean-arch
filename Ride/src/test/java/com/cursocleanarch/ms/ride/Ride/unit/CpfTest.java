package com.cursocleanarch.ms.ride.Ride.unit;

import com.cursocleanarch.ms.ride.Ride.domain.person.Cpf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CpfTest {

    @ParameterizedTest
    @ValueSource(strings = {"83432616074", "74587887803", "87175659520"})
    public void deveTestarCpfsValidos(String value) {
        var cpf = new Cpf(value);
        Assertions.assertEquals(value, cpf.value());
    }

    @ParameterizedTest
    @ValueSource(strings = {"83432616076", "99999999999", "834326160", ""})
    public void deveTestarCpfsInvalidos(String value){
        assertThrows(IllegalArgumentException.class, () -> new Cpf(value));
    }

}
