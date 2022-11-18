package com.sparta;

import com.sparta.framework.connection.ConnectionManager;
import com.sparta.framework.connection.Endpoints;
import com.sparta.framework.dto.StarshipsDTO;
import com.sparta.framework.injector.Injector;
import org.junit.jupiter.api.*;


public class StarshipDTOTest {
    private static StarshipsDTO dto;
    private static int statusCode;

    @BeforeAll
    static void setupAll() {
        dto = Injector.injectStarshipsDTO(ConnectionManager.getConnection(Endpoints.STARSHIPS, 17));
        statusCode = ConnectionManager.getStatusCode(Endpoints.FILMS);
    }

    @Test
    @DisplayName("Check that the status code is 200")
    void checkThatTheStatusCodeIs200() {
        Assertions.assertEquals(200, statusCode);
    }



    @Test
    @DisplayName("Check the created date is in the past")
    void checkTheCreatedDateIsInThePast() {
        Assertions.assertTrue(dto.isDateInPast(dto.getCreated()));

    }

    @Test
    @DisplayName("Checked the edited date is in the past")
    void checkedTheEditedDateIsInThePast() {
        Assertions.assertTrue(dto.isDateInPast(dto.getEdited()));
    }

    @Test
    @DisplayName("Check consumable has correct format")
    void checkConsumableHasCorrectFormat() {
        //Correct format: 1 week/month/year, n+1 weeks/months/years
        Assertions.assertTrue(dto.isConsumablesFormatCorrect());

    }

    @Test
    @DisplayName("Check that crew has comma thousands separators")
    void checkThatNumberHasCommaThousandsSeparators() {
        Assertions.assertTrue(dto.isNumberFormatted(dto.getCrew()));
    }

    @Test
    @DisplayName("Check Hyperdrive Rating larger than 0")
    void checkHyperdriveRatingLargerThan0() {
        Assertions.assertTrue(dto.getHyperdriveRating() >= 0);

    }

    @Nested
    class HamcrestValidate{
        @Test
        @DisplayName("Check that films contain valid hamcrest")
        void checkThatFilmsContainValidHamcrest() {
            Assertions.assertTrue(dto.checkIfHamcrestReturn200StatusCode(dto.getFilms()));
        }
    
        @Test
        @DisplayName("Checked the pilot contain valid hamcrest")
        void checkedThePilotContainValidHamcrest() {
            Assertions.assertTrue(dto.checkIfHamcrestReturn200StatusCode(dto.getPilots()));
            
        }

        @Test
        @DisplayName("Check that url contains valid hamcrest")
        void checkThatUrlContainsValidHamcrest() {
           Assertions.assertTrue(dto.checkIfHamcrestReturn200StatusCode(dto.getUrl()));
        }

    }

    @Nested
    class NumberValidation{
        @Test
        @DisplayName("Check MGLT is larger than 0")
        void checkMgltIsLargerThan0() {
            Assertions.assertTrue(dto.getMGLT() >0);

        }

        @Test
        @DisplayName("Check length is larger than 0")
        void checkLengthIsLargerThan0() {
            Assertions.assertTrue(dto.getLength() > 0);


        }

        @Test
        @DisplayName("Check cost in credit is larger than 0")
        void checkCostInCreditIsLargerThan0() {
            Assertions.assertTrue(dto.isCostNumberLargerThanZero());
        }
    }



    @Nested
    class NotNullAndNotEmpty{
        //not inclusive
        @Test
        @DisplayName("Check name is not null")
        void checkNameIsNotNull() {
            Assertions.assertNotNull(dto.getName());
        }

        @Test
        @DisplayName("Check name is not empty")
        void checkNameIsNotEmpty() {
            Assertions.assertFalse(dto.getName().isEmpty());
        }

        @Test
        @DisplayName("Check model is not null")
        void checkModelIsNotNull() {
            Assertions.assertNotNull(dto.getModel());
        }

        @Test
        @DisplayName("Check model is not empty")
        void checkModelIsNotEmpty() {
            Assertions.assertFalse(dto.getModel().isEmpty());

        }
    }


}
