package com.sparta;

import com.sparta.framework.connection.ConnectionManager;
import com.sparta.framework.connection.Endpoints;
import com.sparta.framework.dto.SpeciesDTO;
import com.sparta.framework.injector.Injector;
import com.sparta.framework.utilities.LinkValidator;
import org.junit.jupiter.api.*;

import java.util.Date;

public class SpeciesTest {

    private static SpeciesDTO speciesDTO;
    private static int statusCode;

    @BeforeAll
    static void setAll(){
        speciesDTO = Injector.injectSpeciesDTO(ConnectionManager.getConnection(Endpoints.SPECIES, 1));
        statusCode = ConnectionManager.getStatusCode(Endpoints.SPECIES);
    }
    @Test
    @DisplayName("Testing Status Code is 200")
    void testingStatusCodeIs200(){
        Assertions.assertEquals(statusCode, 200);
    }

    @Test
    @DisplayName("Testing Films")
    void testingFilms(){
        Assertions.assertNotNull(speciesDTO.getFilms());
    }

    @Test
    @DisplayName("Testing Skin Colours")
    void testingSkinColours(){
        Assertions.assertNotNull(speciesDTO.getSkinColors());
    }

    @Test
    @DisplayName("Testing Home World")
    void testingHomeWorld(){
        Assertions.assertNotNull(speciesDTO.getHomeworld());
    }

    @Nested
    class DateTests{
        Date todayDate = new Date();

        @Test
        @DisplayName("Testing Edited")
        void testingEdited(){
            Assertions.assertTrue(speciesDTO.getEdited().before(todayDate));
        }

        @Test
        @DisplayName("Testing Created")
        void testingCreated(){
            Assertions.assertTrue(speciesDTO.getCreated().before(todayDate));
        }
    }

    @Nested
    class NumberMoreThanZero{
        @Test
        @DisplayName("Testing Average Height Is More Than 0")
        void testingAverageHeightIsMoreThan0(){
            Assertions.assertTrue(speciesDTO.getAverageHeight() > 0);
        }
        @Test
        @DisplayName("Testing Average Lifespan Is More Than 0")
        void testingAverageLifespanIsMoreThan0(){
            Assertions.assertTrue(speciesDTO.getAverageLifespan() > 0);
        }
    }

    @Test
    @DisplayName("Testing Eye Colours")
    void testingEyeColours(){
        Assertions.assertNotNull(speciesDTO.getEyeColors());
    }

    @Test
    @DisplayName("Testing Language")
    void testingLanguage(){
        Assertions.assertNotNull(speciesDTO.getLanguage());
    }

    @Test
    @DisplayName("Testing Classification")
    void testingClassification(){
        Assertions.assertNotNull(speciesDTO.getClassification());
    }

    @Test
    @DisplayName("Testing People")
    void testingPeople(){
        Assertions.assertNotNull(speciesDTO.getPeople());
    }

    @Test
    @DisplayName("Testing URL")
    void testingURL(){
        Assertions.assertNotNull(speciesDTO.getUrl());
    }

    @Test
    @DisplayName("Testing Hair Colours")
    void testingHairColours(){
        Assertions.assertNotNull(speciesDTO.getHairColors());
    }

    @Test
    @DisplayName("Testing Name")
    void testingName(){
        Assertions.assertNotNull(speciesDTO.getName());
    }

    @Test
    @DisplayName("Testing Designation")
    void testingDesignation(){
        Assertions.assertNotNull(speciesDTO.getDesignation());
    }

    @Nested
    class HateoasChecker{
        @Test
        @DisplayName("Check Home World Has Valid Links")
        void checkHomeWorldHasValidLinks(){
            Assertions.assertTrue(LinkValidator.checkIfHateoasReturn200StatusCode(speciesDTO.getHomeworld()));
        }
        @Test
        @DisplayName("Check Films Has Valid Links")
        void checkFilmsHasValidLinks(){
            Assertions.assertTrue(LinkValidator.checkIfHateoasReturn200StatusCode(speciesDTO.getFilms()));
        }

    }

}
