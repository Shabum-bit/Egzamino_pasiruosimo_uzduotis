package lt.techin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("SignIn")
@DisplayName("Testing if possible to log in with correct and incorrect inputs")
public class SignInTest extends BaseTest{

    // POSITIVE

    @Test
    @DisplayName("Positive sign in with correct input")
    void SignInPositive(){

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignInButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.emailInput("TestasTestas@test.com");

        registrationPage.passwordInput("Testas123789!");

        signUpPage.clickSignInLogin();

        assertTrue(signUpPage.isLoggedIn());

    }
    // NEGATIVE

    @Test
    @DisplayName("Negative sign in with empty fields")
    void SignInEmptyFields(){

        // Error message visible
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignInButton();

        signUpPage.clickSignInLogin();
    }
    @Test
    @DisplayName("Negative sign in with incorrect email")
    void SignIncorrectEmail() {

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignInButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        // Error message visible / Invalid format
        registrationPage.emailInput("Testas@test");

        registrationPage.passwordInput("Testas123!");

        signUpPage.clickSignInLogin();
    }
        @Test
        @DisplayName("Negative sign in with all small email letters")
        void SignInCaseSensitiveEmail(){

            SignUpPage signUpPage = new SignUpPage(driver);

            signUpPage.clickSignInButton();

            RegistrationPage registrationPage = new RegistrationPage(driver);
            // PASSED
            registrationPage.emailInput("testas@test.com");

            registrationPage.passwordInput("Testas123!");

            signUpPage.clickSignInLogin();

    }
    @Test
    @DisplayName("Negative sign in with incorrect password")
    void SignInIncorrectPassword(){

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.clickSignInButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.emailInput("Testas@test.com");

        // Error message visible / authentication failed
        registrationPage.passwordInput("Testas123!123");

        signUpPage.clickSignInLogin();

    }
}
