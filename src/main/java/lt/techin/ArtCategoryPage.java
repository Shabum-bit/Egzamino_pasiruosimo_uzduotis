package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArtCategoryPage extends BasePage{
    public ArtCategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Art']")
    private WebElement navigateToArtCategory;

    void navigateToArtCategory(){
        navigateToArtCategory.click();
    }

    @FindBy(xpath = "//button[@aria-label='Sort by selection']")
    private WebElement sortBy;

    void sortBy(){
        sortBy.click();
    }
}
