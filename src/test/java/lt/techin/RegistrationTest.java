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

        signUpPage.clickSignInButton();

        signUpPage.clickCreateNewAccountButton();

    }

    // POSITIVE

    @Test
    @Tag("Positive")
    @DisplayName("Successful registration with valid user data")
    void SignUpPositive(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("Testas");

        registrationPage.lastNameInput("Test");

        registrationPage.emailInput("Testas" + System.currentTimeMillis() + "@test.com");

        registrationPage.passwordInput("Testas123789!");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();
    }

    @Test
    @Tag("Positive")
    @DisplayName("Registration with short but valid name and surname")
    void signUpShortNameSurname(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("A");

        registrationPage.lastNameInput("B");

        registrationPage.emailInput("T" + System.currentTimeMillis() + "@test.com");

        registrationPage.passwordInput("Testas123!");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();
    }
    @Test
    @Tag("Positive")
    @DisplayName("Registration with long but valid name and surname")
    void signUpLongNameSurname(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("TestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTesta"); // 101 letters

        registrationPage.lastNameInput("TestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTesta"); // 101 letters

        registrationPage.emailInput("Long" + System.currentTimeMillis() + "@test.com");

        registrationPage.passwordInput("Testas123!");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();
    }

    @Test
    @Tag("Positive")
    @DisplayName("Registration with numbers-only password")
    void signUpOnlyNumbersPassword(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("Testas");

        registrationPage.lastNameInput("Testas");

        registrationPage.emailInput("Numbers" + System.currentTimeMillis() + "@testas.com");

        registrationPage.passwordInput("123456789123");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();

    }
    @Test
    @Tag("Positive")
    @DisplayName("Registration with lowercase letters only password")
    void signUpOnlySmallLettersPassword(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("Testas");

        registrationPage.lastNameInput("Testas");

        registrationPage.emailInput("Lower" + System.currentTimeMillis() + "@testas.com");

        registrationPage.passwordInput("testastestastestas");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();

    }
    @Test
    @Tag("Positive")
    @DisplayName("Registration with uppercase letters only password")
    void signUpOnlyBigLettersPassword(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("Testas");

        registrationPage.lastNameInput("Testas");

        registrationPage.emailInput("Upper" + System.currentTimeMillis() + "@testas.com");

        registrationPage.passwordInput("TESTASTESTASTESTAS");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();

        // Patikrinti sėkmingą registraciją
    }

    // NEGATIVE

    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with empty required fields")
    void SignUpEmptyFields() {

        // Error message visible

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSaveButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        assertTrue(registrationPage.hasErrorMessage(),
                "Error message should appear");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with special symbols in name and surname")
    void SignUpSpecialSymbolNameSurname(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        // Error message visible / Invalid format
        registrationPage.firstNameInput("120~=]*");

        // Error message visible Invalid format
        registrationPage.lastNameInput("8899+-*");

        registrationPage.emailInput("Testas1@test.com");

        registrationPage.passwordInput("Testas123!");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();

        assertTrue(registrationPage.hasNameFormatError(),
                "Should display 'Invalid format' error for special symbols");
    }



    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with too long password")
    void SignUpLongPassword(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("Testas");

        registrationPage.lastNameInput("Testas");

        registrationPage.emailInput("Testas" + System.currentTimeMillis() + "@Testas.com");

        // 101 letters, Error message visible / between 6-72 characters
        registrationPage.passwordInput("TestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTestasTesta");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();

        assertTrue(registrationPage.hasPasswordLengthError(),
                "Should display error for password that is too long");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with too short password")
    void SignUpShortPassword(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("Testas");

        registrationPage.lastNameInput("Testas");

        registrationPage.emailInput("Testas@testas.com");

        // Error message visible between 6-72 characters
        registrationPage.passwordInput("Tes12");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();

        assertTrue(registrationPage.hasPasswordLengthError(),
                "Should display error for password that is too short");
    }


    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with wrong birth date format")
    void SignUpWrongBirthDate(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("Testas");

        registrationPage.lastNameInput("Testas");

        registrationPage.emailInput("TestasTesta@TestasT.com");

        registrationPage.passwordInput("Testas123!");

        // Error message visible
        registrationPage.birthDateInput("1996/04/19");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();

        assertTrue(registrationPage.hasBirthDateFormatError(),
                "Should display error for incorrect date format");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with email without @ symbol")
    void SignUpEmailWithoutSpecialSymbol(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("Testas");

        registrationPage.lastNameInput("Testas");

        // Error message is visible
        registrationPage.emailInput("Testastest.com");

        registrationPage.passwordInput("Testas123!");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();

        assertTrue(registrationPage.hasEmailAtSymbolError(),
                "Should display error for missing @ symbol");
    }
    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with email without domain")
    void SignUpEmailWithoutDomain(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("Testas");

        registrationPage.lastNameInput("Testas");

        // Error message is visible
        registrationPage.emailInput("Testas@");

        registrationPage.passwordInput("Testas123!");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();

        assertTrue(registrationPage.hasEmailAtSymbolError(),
                "Should display error for incomplete email");

    }
    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with already existing email")
    void SignUpAlreadyExistingEmail(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("Testas");

        registrationPage.lastNameInput("Testas");

        // Error message is visible
        registrationPage.emailInput("TestasTestas@Testas.com");

        registrationPage.passwordInput("Testas123789!");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickCheckBox();

        registrationPage.clickSaveButton();

        assertTrue(registrationPage.hasEmailAlreadyUsedError(),
                "Should display error for already existing email");
    }
    @Test
    @Tag("Negative")
    @DisplayName("Registration fails without accepting terms and conditions")
    void SignUpWithoutCheckbox(){
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSocialTitle();

        registrationPage.firstNameInput("Testas");

        registrationPage.lastNameInput("Testas");

        registrationPage.emailInput("NoCheckbox" + System.currentTimeMillis() + "@test.com");

        registrationPage.passwordInput("Testas123!");

        registrationPage.birthDateInput("04/19/1996");

        registrationPage.clickSaveButton();

        assertTrue(registrationPage.hasCheckboxError(),
                "Should display error when terms and conditions are not accepted");
    }
}
