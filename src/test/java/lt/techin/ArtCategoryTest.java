package lt.techin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("ArtCategory")
@DisplayName("Art Category Sorting Tests")
public class ArtCategoryTest extends BaseTest{

    @BeforeEach
    void setUpLogIn(){

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.signInButton();

        signUpPage.email("TestasTestas@test.com");

        signUpPage.password("Testas123789!");

        signUpPage.signInLogin();

        assertTrue(signUpPage.isLoggedIn());

        ArtCategoryPage artCategoryPage = new ArtCategoryPage(driver);

        artCategoryPage.navigateToArtCategory();
    }

    @Test
    @DisplayName("Test sorting from A to Z")
    void nameAToZ(){



    }
}
