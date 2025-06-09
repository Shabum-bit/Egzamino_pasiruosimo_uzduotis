package lt.techin;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h4[@id='product-search-no-matches']")
    private WebElement noResultsMessage;

    boolean hasNoResults(){
        try {
            return noResultsMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    String getNoResultsText(){
        return noResultsMessage.getText();
    }
}
