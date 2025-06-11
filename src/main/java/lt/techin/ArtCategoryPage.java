package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArtCategoryPage extends BasePage{
    public ArtCategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@aria-label='Sort by selection']")
    private WebElement sortBy;

    @FindBy(xpath = "//a[normalize-space()='Name, A to Z']")
    private WebElement nameAToZ;

    @FindBy(xpath = "//a[normalize-space()='Name, Z to A']")
    private  WebElement nameZToA;

    @FindBy(xpath = "//a[normalize-space()='Price, low to high']")
    private WebElement priceLowToHigh;

    @FindBy(xpath = "//a[normalize-space()='Price, high to low']")
    private WebElement priceHighToLow;

    void sortBy(){
        sortBy.click();
    }
    void nameAToZ(){
        nameAToZ.click();
    }
    void  nameZToA(){
        nameZToA.click();
    }
    void priceLowToHigh(){
        priceLowToHigh.click();
    }
    void priceHighToLow(){
        priceHighToLow.click();
    }
}
