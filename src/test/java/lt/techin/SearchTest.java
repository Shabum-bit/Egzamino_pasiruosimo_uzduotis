package lt.techin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Search")
@DisplayName("Search Functionality Tests")
public class SearchTest extends BaseTest {

    // POSITIVE

    @Test
    @Tag("Positive")
    @DisplayName("Valid product search")
    void validProductSearch(){

        BasePage basePage = new BasePage(driver);

        basePage.searchProduct("Mug");

        assertTrue(driver.getCurrentUrl().contains("search"));
    }
    @Test
    @Tag("Positive")
    @DisplayName("Insensitive search with big Letters")
    void caseInsensitiveSearchBig(){

        BasePage basePage = new BasePage(driver);

        basePage.searchProduct("MUG");

        assertTrue(driver.getCurrentUrl().contains("search"));
    }
    @Test
    @Tag("Positive")
    @DisplayName("Insensitive search with small Letters")
    void caseInsensitiveSearchSmall(){

        BasePage basePage = new BasePage(driver);

        basePage.searchProduct("mug");

        assertTrue(driver.getCurrentUrl().contains("search"));
    }
    //NEGATIVE

    @Test
    @Tag("Negative")
    @DisplayName("Search with not existing input")
    void noResultsSearch(){

        BasePage basePage = new BasePage(driver);

        basePage.searchProduct("nonexistingproduct");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        assertTrue(resultsPage.getNoResultsText().equals("No matches were found for your search"));
    }
    @Test
    @Tag("Negative")
    @DisplayName("Search with empty input")
    void emptySearch(){

        BasePage basePage = new BasePage(driver);;

        basePage.searchProduct("");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        assertTrue(resultsPage.getNoResultsText().equals("No matches were found for your search"));
    }
}
