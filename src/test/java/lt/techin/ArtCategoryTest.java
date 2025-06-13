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
        signUpPage.clickSignInButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.emailInput("TestasTestas@test.com");
        registrationPage.passwordInput("Testas123789!");
        signUpPage.clickSignInLogin();


        BasePage basePage = new BasePage(driver);
        assertTrue(basePage.isLoggedIn());
        basePage.navigateToArtCategory();

    }

    @Test
    @DisplayName("Test sorting from A to Z")
    void nameAToZ(){

        ArtCategoryPage artCategoryPage = new ArtCategoryPage(driver);

        artCategoryPage.clickSortBy();

        artCategoryPage.clickNameAToZ();
    }

    @Test
    @DisplayName("Test sorting from Z to A")
    void nameZToA(){

        ArtCategoryPage artCategoryPage = new ArtCategoryPage(driver);

        artCategoryPage.clickSortBy();

        artCategoryPage.clickNameZToA();
    }

    @Test
    @DisplayName("Test sorting from low price to high")
    void priceLowToHigh(){

        ArtCategoryPage artCategoryPage = new ArtCategoryPage(driver);

        artCategoryPage.clickSortBy();

        artCategoryPage.clickPriceLowToHigh();
    }
    @Test
    @DisplayName("Test sorting from high to low price")
    void priceHighToLow(){

        ArtCategoryPage artCategoryPage = new ArtCategoryPage(driver);

        artCategoryPage.clickSortBy();

        artCategoryPage.clickPriceHighToLow();
    }
}
