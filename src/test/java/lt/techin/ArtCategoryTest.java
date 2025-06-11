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

        BasePage basePage = new BasePage(driver);

        basePage.navigateToArtCategory();

    }

    @Test
    @DisplayName("Test sorting from A to Z")
    void nameAToZ(){

        ArtCategoryPage artCategoryPage = new ArtCategoryPage(driver);

        artCategoryPage.sortBy();

        artCategoryPage.nameAToZ();
    }

    @Test
    @DisplayName("Test sorting from Z to A")
    void nameZToA(){

        ArtCategoryPage artCategoryPage = new ArtCategoryPage(driver);

        artCategoryPage.sortBy();

        artCategoryPage.nameZToA();
    }

    @Test
    @DisplayName("Test sorting from low price to high")
    void priceLowToHigh(){

        ArtCategoryPage artCategoryPage = new ArtCategoryPage(driver);

        artCategoryPage.sortBy();

        artCategoryPage.priceLowToHigh();
    }
}
