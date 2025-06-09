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

        signUpPage.signInButton();

        signUpPage.email("TestasTestas@test.com");

        signUpPage.password("Testas123789!");

        signUpPage.signInLogin();

        assertTrue(signUpPage.isLoggedIn());

    }
    // NEGATIVE

    @Test
    @DisplayName("Negative sign in with empty fields")
    void SignInEmptyFields(){

        // Error message visible
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.signInButton();

        signUpPage.signInLogin();
    }
    @Test
    @DisplayName("Negative sign in with incorrect email")
    void SignIncorrectEmail() {

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.signInButton();

        // Error message visible / Invalid format
        signUpPage.email("Testas@test");

        signUpPage.password("Testas123!");

        signUpPage.signInLogin();
    }
        @Test
        @DisplayName("Negative sign in with all small email letters")
        void SignInCaseSensitiveEmail(){

            SignUpPage signUpPage = new SignUpPage(driver);

            signUpPage.signInButton();

            // PASSED
            signUpPage.email("testas@test.com");

            signUpPage.password("Testas123!");

            signUpPage.signInLogin();

    }
    @Test
    @DisplayName("Negative sign in with incorrect password")
    void SignInIncorrectPassword(){

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.signInButton();

        signUpPage.email("Testas@test.com");

        // Error message visible / authentication failed
        signUpPage.password("Testas123!123");

        signUpPage.signInLogin();

    }
}
