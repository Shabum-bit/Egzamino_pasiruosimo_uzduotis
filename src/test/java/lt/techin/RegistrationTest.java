package lt.techin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Testing registration form with positive and negative scenarios")
@Tag("Registration")
public class RegistrationTest extends BaseTest{


    @BeforeEach
    void setUpRegistrationForm(){

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.signInButton();

        signUpPage.createNewAccountButton();

    }

    // POSITIVE

    @Test
    @Tag("Positive")
    void SignUpPositive(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("Testas");

        registrationPage.lastName("Test");

        registrationPage.email("Testas" + System.currentTimeMillis() + "@test.com");

        registrationPage.password("Testas123789!");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();
    }

    @Test
    @Tag("Positive")
    @DisplayName("Registration with short but valid name and surname")
    void signUpShortNameSurname(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("A");

        registrationPage.lastName("B");

        registrationPage.email("T" + System.currentTimeMillis() + "@test.com");

        registrationPage.password("Testas123!");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();
    }
    @Test
    @Tag("Positive")
    @DisplayName("Registration with long but valid name and surname")
    void signUpLongNameSurname(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("TestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTesta"); // 101 letters

        registrationPage.lastName("TestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTesta"); // 101 letters

        registrationPage.email("Long" + System.currentTimeMillis() + "@test.com");

        registrationPage.password("Testas123!");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();
    }

    @Test
    @Tag("Positive")
    @DisplayName("Registration with numbers-only password")
    void signUpOnlyNumbersPassword(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("Testas");

        registrationPage.lastName("Testas");
        registrationPage.email("Numbers" + System.currentTimeMillis() + "@testas.com");

        registrationPage.password("123456789123");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();

    }
    @Test
    @Tag("Positive")
    @DisplayName("Registration with lowercase letters only password")
    void signUpOnlySmallLettersPassword(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("Testas");

        registrationPage.lastName("Testas");

        registrationPage.email("Lower" + System.currentTimeMillis() + "@testas.com");

        registrationPage.password("testastestastestas");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();

    }
    @Test
    @Tag("Positive")
    @DisplayName("Registration with uppercase letters only password")
    void signUpOnlyBigLettersPassword(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("Testas");

        registrationPage.lastName("Testas");

        registrationPage.email("Upper" + System.currentTimeMillis() + "@testas.com");

        registrationPage.password("TESTASTESTASTESTAS");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();

        // Patikrinti sėkmingą registraciją
    }

    // NEGATIVE

    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with empty required fields")
    void SignUpEmptyFields() {

        // Error message visible

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.saveButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        assertTrue(registrationPage.hasErrorMessage(),
                "Error message should appear");
    }

    @Test
    void SignUpSpecialSymbolNameSurname(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        // Error message visible / Invalid format
        registrationPage.firstName("120~=]*");

        // Error message visible Invalid format
        registrationPage.lastName("8899+-*");

        registrationPage.email("Testas1@test.com");

        registrationPage.password("Testas123!");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();
    }



    @Test
    void SignUpLongPassword(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("Testas");

        registrationPage.lastName("Testas");

        registrationPage.email("Testas@Testas.com");

        // 101 letters, Error message visible / between 6-72 characters
        registrationPage.password("TestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTesta");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();
    }

    @Test
    void SignUpShrotPassword(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("Testas");

        registrationPage.lastName("Testas");

        registrationPage.email("Testas@testas.com");

        // Error message visible between 6-72 characters
        registrationPage.password("Tes12");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();
    }


    @Test
    void SignUpWrongBirthDate(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("Testas");

        registrationPage.lastName("Testas");

        registrationPage.email("TestasTesta@TestasT.com");

        registrationPage.password("Testas123!");

        // Error message visible
        registrationPage.birthDate("1996/04/19");

        registrationPage.checkBox();

        registrationPage.saveButton();

    }

    @Test
    void SignUpEmailWithoutSpecialSymbol(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("Testas");

        registrationPage.lastName("Testas");

        // Error message is visible
        registrationPage.email("Testastest.com");

        registrationPage.password("Testas123!");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();

    }
    @Test
    void SignUpEmailWithoutDomain(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("Testas");

        registrationPage.lastName("Testas");

        // Error message is visible
        registrationPage.email("Testas@");

        registrationPage.password("Testas123!");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();

    }
    @Test
    void SignUpAlreadyExistingEmail(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.socialTitle();

        registrationPage.firstName("Testas");

        registrationPage.lastName("Testas");

        // Error message is visible
        registrationPage.email("Testas@Testas.com");

        registrationPage.password("Testas123!");

        registrationPage.birthDate("04/19/1996");

        registrationPage.checkBox();

        registrationPage.saveButton();

    }
}
