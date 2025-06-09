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
    @DisplayName("Successful logout")
    void SuccessfulLogout(){

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.signInButton();

        signUpPage.email("TestasTestas@test.com");

        signUpPage.password("Testas123789!");

        signUpPage.signInLogin();

        assertTrue(signUpPage.isLoggedIn());

        signUpPage.signOut();

        assertFalse(signUpPage.isLoggedIn());

    }
}
