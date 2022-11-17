package com.sparta;

import static com.sparta.framework.connection.ConnectionManager.*;
import static com.sparta.framework.injector.Injector.injectFilmsDTO;
import static org.junit.Assert.*;
;
import com.sparta.framework.connection.Endpoints;
import com.sparta.framework.dto.FilmsDTO;
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

    @Test
    @DisplayName("Check that the Endpoint returns a title")
    void checkThatTheEndpointReturnsTheCorrectTitle() {
        assertNotNull(filmsDTO.getTitle());
    }

    @Test
    @DisplayName("Check that the Endpoint returns a valid episode id")
    void checkThatTheEndpointReturnsTheCorrectEpisodeId() {
        Integer expected = 0;
        assertTrue(filmsDTO.getEpisodeId() >= expected);
    }

    @Test
    @DisplayName("Check that the Endpoint returns an opening crawl")
    void checkThatTheEndpointReturnsTheCorrectOpeningCrawl() {
        assertNotNull(filmsDTO.getOpeningCrawl());
    }
    
    @Test
    @DisplayName("Check that the Endpoint returns a director")
    void checkThatTheEndpointReturnsTheCorrectDirector() {
        assertNotNull(filmsDTO.getDirector());
    }
    
    @Test
    @DisplayName("Check that the Endpoint returns a producer")
    void checkThatTheEndpointReturnsTheCorrectProducer() {
        assertNotNull(filmsDTO.getProducer());
    }

    @Test
    @DisplayName("Check that the Endpoint returns a valid date")
    void checkThatTheEndpointReturnsAValidDate() {
        Date now = new Date();
        assertTrue(filmsDTO.getReleaseDate().before(now));
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

    @Test
    @DisplayName("Check that the endpoint returns a url")
    void checkThatTheEndpointReturnsAUrl() {
        assertNotNull(filmsDTO.getUrl());
    }

}
