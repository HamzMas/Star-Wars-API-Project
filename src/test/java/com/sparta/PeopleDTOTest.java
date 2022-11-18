package com.sparta;

import static com.sparta.framework.connection.ConnectionManager.*;
import static com.sparta.framework.injector.Injector.injectPeopleDTO;
import static org.junit.Assert.*;
;
import com.sparta.framework.connection.Endpoints;
import com.sparta.framework.dto.PeopleDTO;
import org.junit.jupiter.api.*;

import java.net.http.HttpResponse;
import java.util.Date;

public class PeopleDTOTest {

    private static PeopleDTO peopleDTO;

    private static int statusCode;
    private static String peopleDTOUrl;
    private static String header;
    private static HttpResponse<String> body;

    @BeforeAll
    static void initAll(){
        peopleDTO = injectPeopleDTO(getConnection(Endpoints.PEOPLE, 5));
        statusCode = getStatusCode(Endpoints.PEOPLE);
        header = getHeader("Content-type", Endpoints.PEOPLE);
    }

    @Test
    @DisplayName("Check status code is 200")
    public void checkStatusCodeIs200(){
        assertEquals(200, getStatusCode(Endpoints.PEOPLE));
    }

    @Nested
    @DisplayName("Checking mass and height are positive integers")
    class integerCheckers {
        @Test
        @DisplayName("Check height is greater than 0")
        public void checkHeightIsAPositiveInteger(){
            assertTrue(peopleDTO.getHeight() >= 0);
        }
        @Test
        @DisplayName("Check mass is a positive integer")
        void checkMassIsPositiveInteger(){
            assertTrue(peopleDTO.getMass()>=0);
        }
    }

    @Nested
    @DisplayName("Null checkers")
    public class nullCheckers {
        @Test
        @DisplayName("Check name is not null")
        void checkNameIsNotNull() {
            assertNotNull(peopleDTO.getName());
        }

        @Test
        @DisplayName("Check height is not null")
        void checkHeightIsNotNull() {
            assertNotNull(peopleDTO.getHeight());
        }
        @Test
        @DisplayName("Check mass is not null")
        void checkMassIsNotNull() {
            assertNotNull(peopleDTO.getMass());
        }

        @Test
        @DisplayName("Check hair color is not null")
        void checkHairColorIsNotNull() {
            assertNotNull(peopleDTO.getHairColor());
        }
        @Test
        @DisplayName("Check skin color is not null")
        void checkSkinColorIsNotNull() {
            assertNotNull(peopleDTO.getSkinColor());
        }
        @Test
        @DisplayName("Check eye color is not null")
        void checkEyeColorIsNotNull() {
            assertNotNull(peopleDTO.getEyeColor());
        }
        @Test
        @DisplayName("Check birth year is not null")
        void checkBirthYearIsNotNull() {
            assertNotNull(peopleDTO.getBirthYear());
        }
        @Test
        @DisplayName("Check gender is not null")
        void checkGenderIsNotNull() {
            assertNotNull(peopleDTO.getGender());
        }
        @Test
        @DisplayName("Check homeworld is not null")
        void checkHomeWorldIsNotNull() {
            assertNotNull(peopleDTO.getHomeworld());
        }
        @Test
        @DisplayName("Check films is not null")
        void checkFilmsIsNotNull() {
            assertNotNull(peopleDTO.getFilms());
        }
        @Test
        @DisplayName("Check Create date is not null")
        void checkCreateDateIsNotNull() {
            assertNotNull(peopleDTO.getCreated());
        }
        @Test
        @DisplayName("Check url is not null")
        void checkURLIsNotNull() {
            assertNotNull(peopleDTO.getUrl());
        }
    }

    @Test
    @DisplayName("Check homeworld contains planet")
    public void checkHomeworldContainsPlanet(){
        assertTrue(peopleDTO.getHomeworld().contains("planet"));
    }

    @Nested
    @DisplayName("Check dates created and edited are valid")
    class checkDates{
        @Test
        @DisplayName("Check a valid date for created is returned")
        void checkValidDateCreated() {
            Date now = new Date();
            assertTrue(peopleDTO.getCreated().before(now));
        }

        @Test
        @DisplayName("Check a valid date for edited is returned")
        void checkValidDateEdited() {
            Date now = new Date();
            assertTrue(peopleDTO.getEdited().before(now));
        }
    }

    @Test
    @DisplayName("Check gender is male or female")
    void checkGender(){
        assertTrue(peopleDTO.isMaleOrFemale());
    }

    @Test
    @DisplayName("Check start date contains either ABY or BBY")
    void checkDateIsValid(){
        assertTrue(peopleDTO.isBirthYearValid());
    }

    @Test
    @DisplayName("Check headers are accurate")
    void checkHeaders(){
        assertEquals("application/json", header);
    }


}