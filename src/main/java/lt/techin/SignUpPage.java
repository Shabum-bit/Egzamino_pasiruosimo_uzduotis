package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    // Path to Sign up form

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[normalize-space()='No account? Create one here']")
    private WebElement createNewAccount;

    @FindBy(xpath = "//button[@id='submit-login']")
    private WebElement signInLogin;

    public void clickSignInButton(){
        signInButton.click();
    }
    public void clickCreateNewAccountButton() {
        createNewAccount.click();
    }
    public void clickSignInLogin(){
        signInLogin.click();
    }
    public boolean isSignInSuccessful() {
        try {
            return driver.findElements(By.xpath("//*[contains(text(), 'Sign out')]")).size() > 0 ||
                    driver.getCurrentUrl().contains("my-account") ||
                    driver.getCurrentUrl().contains("account") ||
                    driver.findElements(By.xpath("//*[contains(text(), 'Testas Test')]")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasSignInErrorMessage() {
        try {
            WebElement emailField = driver.findElement(By.xpath("//input[@id='field-email']"));
            WebElement passwordField = driver.findElement(By.xpath("//input[@id='field-password']"));

            String emailValidation = emailField.getAttribute("validationMessage");
            String passwordValidation = passwordField.getAttribute("validationMessage");

            return (emailValidation != null && !emailValidation.isEmpty()) ||
                    (passwordValidation != null && !passwordValidation.isEmpty());
        } catch (Exception e) {
            return false;
        }
    }
    public boolean hasEmailFormatError() {
        try {
            return driver.findElements(By.xpath("//*[contains(text(), 'Invalid format')]")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean hasAuthenticationError() {
        try {
            return driver.findElements(By.xpath("//*[contains(text(), 'Authentication failed')]")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

}