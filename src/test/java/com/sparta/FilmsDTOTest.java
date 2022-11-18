package com.sparta;

import static com.sparta.framework.connection.ConnectionManager.*;
import static com.sparta.framework.injector.Injector.injectFilmsDTO;
import static org.junit.jupiter.api.Assertions.*;
import com.sparta.framework.connection.Endpoints;
import com.sparta.framework.dto.FilmsDTO;
import com.sparta.framework.utilities.LinkValidator;
import org.junit.jupiter.api.*;
import java.util.Date;

public class FilmsDTOTest {

    static FilmsDTO filmsDTO;

    @BeforeAll
    static void setupAll() {
        filmsDTO = injectFilmsDTO(getConnection(Endpoints.FILMS, 5));
    }

    @Test
    @DisplayName("Check that the status code is 200")
    void checkThatTheStatusCodeIs200() {
        assertEquals(200, getStatusCode(Endpoints.FILMS));
    }
    
    @Test
    @DisplayName("Test API endpoint headers")
    void testApiEndpointHeaders() {
        assertEquals("nginx/1.16.1", getHeader("Server", Endpoints.FILMS));
    }

    @Nested
    @DisplayName("Validate String fields to check if not null")
    class NotNullAndNotEmpty {
        @Test
        @DisplayName("Check that the Endpoint returns a title")
        void checkThatTheEndpointReturnsTheCorrectTitle() {
            assertNotNull(filmsDTO.getTitle());
        }

        @Test
        @DisplayName("Check that the Endpoint returns an opening crawl")
        void checkThatTheEndpointReturnsTheCorrectOpeningCrawl() {
            assertNotNull(filmsDTO.getOpeningCrawl());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a producer")
        void checkThatTheEndpointReturnsTheCorrectProducer() {
            assertNotNull(filmsDTO.getProducer());
        }

        @Test
        @DisplayName("Check that the Endpoint returns a director")
        void checkThatTheEndpointReturnsTheCorrectDirector() {
            assertNotNull(filmsDTO.getDirector());
        }

        @Test
        @DisplayName("Check that the endpoint returns a valid characters list")
        void checkThatTheEndpointReturnsTheCorrectCharactersList() {
            assertNotNull(filmsDTO.getCharacters());
        }

        @Test
        @DisplayName("Check that the endpoint returns a valid planets list")
        void checkThatTheEndpointReturnsTheCorrectPlanetsList() {
            assertNotNull(filmsDTO.getPlanets());
        }

        @Test
        @DisplayName("Check that the endpoint returns a valid starships list")
        void checkThatTheEndpointReturnsTheCorrectStarshipsList() {
            assertNotNull(filmsDTO.getStarships());
        }

        @Test
        @DisplayName("Check that the endpoint returns a valid vehicles list")
        void checkThatTheEndpointReturnsTheCorrectVehiclesList() {
            assertNotNull(filmsDTO.getVehicles());
        }

        @Test
        @DisplayName("Check that the endpoint returns a valid species list")
        void checkThatTheEndpointReturnsTheCorrectSpeciesList() {
            assertNotNull(filmsDTO.getSpecies());
        }

        @Test
        @DisplayName("Check that the endpoint returns a url")
        void checkThatTheEndpointReturnsAUrl() {
            assertNotNull(filmsDTO.getUrl());
        }
    }


    @Nested
    @DisplayName("Validate numeric fields")
    class NumberValidation {
        @Test
        @DisplayName("Check that the Endpoint returns a valid episode id")
        void checkThatTheEndpointReturnsTheCorrectEpisodeId() {
            assertTrue(filmsDTO.getEpisodeId() >= 0);
        }
    }

    @Nested
    @DisplayName("Validate date fields")
    class DateValidation {
        @Test
        @DisplayName("Check that the Endpoint returns a valid release date")
        void checkThatTheEndpointReturnsAValidReleaseDate() {
            Date now = new Date();
            assertTrue(filmsDTO.getReleaseDate().before(now));
        }

        @Test
        @DisplayName("Check that the endpoint returns a valid date for created")
        void checkThatTheEndpointReturnsAValidDateForCreated() {
            Date now = new Date();
            assertTrue(filmsDTO.getCreated().before(now));
        }

        @Test
        @DisplayName("Check that the endpoint returns a valid date for edited")
        void checkThatTheEndpointReturnsAValidDateForEdited() {
            Date now = new Date();
            assertTrue(filmsDTO.getEdited().before(now));
        }
    }

    @Nested
    @DisplayName("Validate all links within response")
    class HateoasValidation {
        @Test
        @DisplayName("Check that characters list contains valid links")
        void checkThatCharactersListContainsValidLinks() {
            assertTrue(LinkValidator.checkIfHateoasReturn200StatusCode(filmsDTO.getCharacters()));
        }
        
        @Test
        @DisplayName("Check that planets list contains valid links")
        void checkThatPlanetsListContainsValidLinks() {
            assertTrue(LinkValidator.checkIfHateoasReturn200StatusCode(filmsDTO.getPlanets()));
        }

        @Test
        @DisplayName("Check that the starships list contains valid links")
        void checkThatTheStarshipsListContainsValidLinks() {
            assertTrue(LinkValidator.checkIfHateoasReturn200StatusCode(filmsDTO.getStarships()));
        }

        @Test
        @DisplayName("Check that the vehicles list contains valid links")
        void checkThatTheVehiclesListContainsValidLinks() {
            assertTrue(LinkValidator.checkIfHateoasReturn200StatusCode(filmsDTO.getVehicles()));
        }

        @Test
        @DisplayName("Check that the species list contains valid links")
        void checkThatTheSpeciesListContainsValidLinks() {
            assertTrue(LinkValidator.checkIfHateoasReturn200StatusCode(filmsDTO.getSpecies()));
        }

        @Test
        @DisplayName("Test that the url in the response is a valid link")
        void testThatTheUrlInTheResponseIsAValidLink() {
            assertTrue(LinkValidator.checkIfHateoasReturn200StatusCode(filmsDTO.getUrl()));
        }
    }





}
