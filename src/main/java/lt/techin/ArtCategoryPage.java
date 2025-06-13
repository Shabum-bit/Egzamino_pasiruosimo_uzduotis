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

    public void clickSortBy(){
        sortBy.click();
    }
    public void clickNameAToZ(){
        nameAToZ.click();
    }
    public void  clickNameZToA(){
        nameZToA.click();
    }
    public void clickPriceLowToHigh(){
        priceLowToHigh.click();
    }
    public void clickPriceHighToLow(){
        priceHighToLow.click();
    }

    public boolean isSortedByNameAZ() {
        try {
            return driver.getCurrentUrl().contains("order=product.name.asc");
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isSortedByNameZA() {
        try {
            return driver.getCurrentUrl().contains("order=product.name.desc");
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isSortedByPriceLowHigh() {
        try {
            return driver.getCurrentUrl().contains("order=product.price.asc");
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isSortedByPriceHighLow() {
        try {
            return driver.getCurrentUrl().contains("order=product.price.desc");
        } catch (Exception e) {
            return false;
        }
    }
}

