package com.sparta;

import com.sparta.framework.connection.Endpoints;
import com.sparta.framework.dto.VehiclesDTO;
import com.sparta.framework.utilities.LinkValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static com.sparta.framework.connection.ConnectionManager.*;
import static com.sparta.framework.injector.Injector.injectVehiclesDTO;
import static org.junit.jupiter.api.Assertions.*;

public class VehiclesDTOTest {

    static VehiclesDTO vehiclesDTO;

    @BeforeAll
    static void setupAll() {
        vehiclesDTO = injectVehiclesDTO(getConnection(Endpoints.VEHICLES, 4));
    }

    @Test
    @DisplayName("Check that the status code is 200")
    void checkThatTheStatusCodeIs200() {
        assertEquals(200, getStatusCode(Endpoints.VEHICLES));
    }

    @Test
    @DisplayName("Test API endpoint headers")
    void testApiEndpointHeaders() {
        assertEquals("nginx/1.16.1", getHeader("Server", Endpoints.VEHICLES));
    }


    @Nested
    @DisplayName("Validate String fields to check if not null")
    class NotNull {
        @Test
        @DisplayName("Check that the Endpoint returns a name")
        void checkThatTheEndpointReturnsAName() {
            assertNotNull(vehiclesDTO.getName());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a model")
        void checkThatTheEndpointReturnsAModel() {
            assertNotNull(vehiclesDTO.getModel());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a manufacturer")
        void checkThatTheEndpointReturnsAManufacturer() {
            assertNotNull(vehiclesDTO.getManufacturer());
        }

        @Test
        @DisplayName("Check that the Endpoint returns consumables")
        void checkThatTheEndpointReturnsConsumables() {
            assertNotNull(vehiclesDTO.getConsumables());
        }

        @Test
        @DisplayName("Check that the Endpoint returns the vehicle class")
        void checkThatTheEndpointReturnsTheVehicleClass() {
            assertNotNull(vehiclesDTO.getVehicleClass());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a valid number of films")
        void checkThatTheEndpointReturnsAValidNumberOfFilms() {
            assertNotNull(vehiclesDTO.getFilms());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a valid list of pilots")
        void checkThatTheEndpointReturnsAValidListOfPilots() {
            assertNotNull(vehiclesDTO.getPilots());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a url")
        void checkThatTheEndpointReturnsAUrl() {
            assertNotNull(vehiclesDTO.getUrl());
        }
    }

    @Nested
    @DisplayName("Validate numeric fields")
    class NumberValidation {
        @Test
        @DisplayName("Check that the Endpoint returns a valid cost in credits")
        void checkThatTheEndpointReturnsAValidCostInCredits() {
            assertTrue(vehiclesDTO.getCostInCredits() >= 0);
        }

        @Test
        @DisplayName("Check that the Endpoint returns a valid length")
        void checkThatTheEndpointReturnsAValidLength() {
            assertTrue(vehiclesDTO.getLength() >= 0);
        }

        @Test
        @DisplayName("Check that the Endpoint returns a valid max atmosphering speed")
        void checkThatTheEndpointReturnsAValidMaxAtmospheringSpeed() {
            assertTrue(vehiclesDTO.getMaxAtmospheringSpeed() >= 0);
        }

        @Test
        @DisplayName("Check that the Endpoint returns a valid number of crew members")
        void checkThatTheEndpointReturnsAValidNumberOfCrewMembers() {
            assertTrue(vehiclesDTO.getCrew() >= 0);
        }

        @Test
        @DisplayName("Check that the Endpoint returns a valid number of passengers")
        void checkThatTheEndpointReturnsAValidNumberOfPassengers() {
            assertTrue(vehiclesDTO.getPassengers() >= 0);
        }

        @Test
        @DisplayName("Check that the Endpoint returns a valid cargo capacity")
        void checkThatTheEndpointReturnsAValidCargoCapacity() {
            assertTrue(vehiclesDTO.getCargoCapacity() >= 0);
        }
    }

    @Nested
    @DisplayName("Validate date fields")
    class DateValidation {
        @Test
        @DisplayName("Check that the Endpoint returns a valid created date")
        void checkThatTheEndpointReturnsAValidCreatedDate() {
            Date now = new Date();
            assertTrue(vehiclesDTO.getCreated().before(now));
        }

        @Test
        @DisplayName("Check that the Endpoint returns a valid edited date")
        void checkThatTheEndpointReturnsAValidEditedDate() {
            Date now = new Date();
            assertTrue(vehiclesDTO.getEdited().before(now));
        }
    }

    @Nested
    @DisplayName("Validate all links within response")
    class HateoasValidation {
        @Test
        @DisplayName("Check that the pilots list contains valid links")
        void checkThatThePilotsListContainsValidLinks() {
            assertTrue(LinkValidator.checkIfHateoasReturn200StatusCode(vehiclesDTO.getPilots()));
        }

        @Test
        @DisplayName("Check that the films list contains valid links")
        void checkThatTheFilmsListContainsValidLinks() {
            assertTrue(LinkValidator.checkIfHateoasReturn200StatusCode(vehiclesDTO.getFilms()));
        }

        @Test
        @DisplayName("Test that the url in the response is a valid link")
        void testThatTheUrlInTheResponseIsAValidLink() {
            assertTrue(LinkValidator.checkIfHateoasReturn200StatusCode(vehiclesDTO.getUrl()));
        }
    }
}
