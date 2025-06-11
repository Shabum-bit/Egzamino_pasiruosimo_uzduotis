package lt.techin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("SignIn")
@DisplayName("User should be successfully signed in with correct email and password")
public class SignInTest extends BaseTest{

    // POSITIVE

    @Test
    @Tag("Positive")
    @DisplayName("Positive sign in with correct input")
    void SignInPositive(){

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignInButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.emailInput("TestasTestas@test.com");

        registrationPage.passwordInput("Testas123789!");

        signUpPage.clickSignInLogin();

        assertTrue(signUpPage.isSignInSuccessful(),
                "Sign in should be successful with valid credentials");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Sign in with all lowercase email letters")
    void SignInCaseSensitiveEmail(){

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignInButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.emailInput("testastestas@test.com");

        registrationPage.passwordInput("Testas123789!");

        signUpPage.clickSignInLogin();

        assertTrue(signUpPage.isSignInSuccessful(),
                "Sign in should be successful with valid input");

    }
    // NEGATIVE

    @Test
    @Tag("Negative")
    @DisplayName("Sign in with empty fields")
    void SignInEmptyFields(){

        // Error message visible
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignInButton();

        signUpPage.clickSignInLogin();

        assertTrue(signUpPage.hasSignInErrorMessage(),
                "Error message should appear when required fields are empty");
    }
    @Test
    @Tag("Negative")
    @DisplayName("Sign in with incorrect email")
    void SignIncorrectEmail() {

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignInButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        // Error message visible / Invalid format
        registrationPage.emailInput("Testas@test");

        registrationPage.passwordInput("Testas123!");

        signUpPage.clickSignInLogin();

        assertTrue(signUpPage.hasEmailFormatError(),
                "Error message should appear for invalid email format");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Sign in with incorrect password")
    void SignInIncorrectPassword(){

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignInButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.emailInput("Testas@test.com");

        // Error message visible / authentication failed
        registrationPage.passwordInput("Testas123!123");

        signUpPage.clickSignInLogin();

        assertTrue(signUpPage.hasAuthenticationError(),
                "Error message should appear for incorrect password");

    }
}
