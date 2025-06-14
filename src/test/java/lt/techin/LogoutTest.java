package lt.techin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Logout")
@DisplayName("Testing if logout is successful")
public class LogoutTest extends BaseTest {

    @Test
    @Tag("Positive")
    @DisplayName("Successful logout")
    void SuccessfulLogout(){

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSignInButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.emailInput("TestasTestas@test.com");
        registrationPage.passwordInput("Testas123789!");
        signUpPage.clickSignInLogin();

        BasePage basePage = new BasePage(driver);
        assertTrue(basePage.isLoggedIn());

        signUpPage.clickSignOut();
        assertFalse(basePage.isLoggedIn());

    }
}
