package lt.techin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='logout hidden-sm-down']")
    private WebElement signOut;

    void signOut(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signOut));
        signOut.click();
    }
    boolean isLoggedIn(){
        try {
            return signOut.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    @FindBy (xpath = "//input[@placeholder='Search our catalog']")
    private WebElement searchBox;

    void searchProduct(String input){
        searchBox.clear();
        searchBox.sendKeys(input);
        searchBox.sendKeys(Keys.ENTER);

    }
}