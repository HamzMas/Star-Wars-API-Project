package com.sparta;
import com.sparta.framework.connection.ConnectionManager;
import com.sparta.framework.connection.Endpoints;
import com.sparta.framework.dto.PlanetsDTO;
import com.sparta.framework.utilities.LinkValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.sparta.framework.connection.ConnectionManager.*;
import static com.sparta.framework.injector.Injector.injectPlanetsDTO;
import static com.sparta.framework.utilities.LinkValidator.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;


public class PlanetsDTOTest {
    static PlanetsDTO planetsDTO;
    private static int statusCode;
    @BeforeAll
    static void setupALL(){
        planetsDTO = injectPlanetsDTO(getConnection(Endpoints.PLANETS,2));
        statusCode = ConnectionManager.getStatusCode(Endpoints.PLANETS);
    }

    @Test
    @DisplayName("Check the status Code")
    void checkTheStatusCodeIs200(){
        Assertions.assertEquals(200, getStatusCode(Endpoints.PLANETS), 2);
    }

    @Nested
    @DisplayName("Null checkers")
    public class nullCheckers {
        @Test
        @DisplayName("Check that the Endpoint returns a film")
        void checkThatTheEndpointReturnsTheCorrectFilm() {
            Assertions.assertNotNull(planetsDTO.getFilms());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a Climate")
        void checkThatTheEndpointReturnsTheCorrectClimate() {
            Assertions.assertNotNull(planetsDTO.getClimate());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a population")
        void checkThatTheEndpointReturnsTheCorrectPopulation() {
            Assertions.assertNotNull(planetsDTO.getPopulation());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a Diameter")
        void checkThatTheEndpointReturnsTheCorrectDiameter() {
            Assertions.assertNotNull(planetsDTO.getDiameter());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a gravity ")
        void checkThatTheEndpointReturnsTheCorrectGravity() {
            Assertions.assertNotNull(planetsDTO.getGravity());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a terrain ")
        void checkThatTheEndpointReturnsTheCorrectTerrain() {
            Assertions.assertNotNull(planetsDTO.getTerrain());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a Residents")
        void checkThatTheEndpointReturnsTheCorrectResidents() {
            Assertions.assertNotNull(planetsDTO.getResidents());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a period ")
        void checkThatTheEndpointReturnsTheCorrectPeriod() {
            Assertions.assertNotNull(planetsDTO.getOrbitalPeriod());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a Surface ")
        void checkThatTheEndpointReturnsTheCorrectSurface() {
            Assertions.assertNotNull(planetsDTO.getSurfaceWater());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a Name ")
        void checkThatTheEndpointReturnsTheCorrectName() {
            Assertions.assertNotNull(planetsDTO.getName());
        }

        @Test
        @DisplayName("Check that the endpoint returns a url")
        void checkThatTheEndpointReturnsAUrl() {
            Assertions.assertNotNull(planetsDTO.getUrl());
        }
    }


    @Nested
    @DisplayName("Validate all links within response")
    class HateoasValidation {

        @Test
        @DisplayName("Check that Residents list contains valid links")
        void checkThatResidentsListContainsValidLinks() {
            assertTrue(checkIfHateoasReturn200StatusCode(planetsDTO.getResidents()));
        }

        @Test
        @DisplayName("Check that the films list contains valid links")
        void checkThatTheFilmsListContainsValidLinks() {
            assertTrue(checkIfHateoasReturn200StatusCode(planetsDTO.getFilms()));
        }

        @Test
        @DisplayName("Check that the Url list contains valid links")
        void checkThatTheURLListContainsValidLinks() {
            assertTrue(checkIfHateoasReturn200StatusCode(planetsDTO.getUrl()));
        }
    }
}