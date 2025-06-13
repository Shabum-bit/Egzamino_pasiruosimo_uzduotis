package lt.techin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("AccessoriesCategory")
@DisplayName("Accessories category filtering tests")
public class AccessoriesTest extends BaseTest {

    @BeforeEach
    void setUpLogIn() {

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSignInButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.emailInput("TestasTestas@test.com");
        registrationPage.passwordInput("Testas123789!");
        signUpPage.clickSignInLogin();


        BasePage basePage = new BasePage(driver);
        assertTrue(basePage.isLoggedIn());
        basePage.navigateToAccessoriesCategory();

    }

    @Test
    @DisplayName("Filter by Home Accessories category")
    void testHomeAccessoriesFilter() {
        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);

        accessoriesPage.selectHomeAccessories();

        assertTrue(accessoriesPage.isCategoryFiltered(),
                "Home Accessories filter should be applied");
    }

    @Test
    @DisplayName("Filter by Stationery category")
    void testStationeryFilter() {
        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);

        accessoriesPage.selectStationery();

        assertTrue(accessoriesPage.isCategoryFiltered(),
                "Stationery filter should be applied");
    }

    @Test
    @DisplayName("Filter by White color")
    void testWhiteColorFilter() {
        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);

        accessoriesPage.selectWhiteColor();

        assertTrue(accessoriesPage.isColorFiltered(),
                "White color filter should be applied");
    }

    @Test
    @DisplayName("Filter by Black color")
    void testBlackColorFilter() {
        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);

        accessoriesPage.selectBlackColor();

        assertTrue(accessoriesPage.isColorFiltered(),
                "Black color filter should be applied");
    }
}


    /*@Test
    @DisplayName("Filter by price range")
    void testPriceFilter(){

        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);

        accessoriesPage.setPriceRange();
        assertTrue(accessoriesPage.isPriceFiltered());
    }*/

