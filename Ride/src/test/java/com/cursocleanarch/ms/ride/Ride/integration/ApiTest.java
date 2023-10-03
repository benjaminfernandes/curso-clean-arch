package com.cursocleanarch.ms.ride.Ride.integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

public class ApiTest {

    @BeforeEach
    public void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void criarPassageiro() {

        String requestBody = "{\"name\" : \"João das Couves\", \"email\" : \"couves@teste.com\", \"document\" : \"06904816910\"}";

        String createdPassangerId =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/passenger")
                        .then()
                        .statusCode(200)
                        .body("passengerId", notNullValue())
                        .extract()
                        .jsonPath()
                        .getString("passengerId");

        Assertions.assertNotNull(createdPassangerId);
    }

}
