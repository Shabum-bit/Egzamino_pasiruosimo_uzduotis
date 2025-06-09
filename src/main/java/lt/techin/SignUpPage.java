package lt.techin;

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

    void signInButton(){
        signInButton.click();
    }

    @FindBy(xpath = "//a[normalize-space()='No account? Create one here']")
    private WebElement createNewAccountButton;

    void createNewAccountButton() {
        createNewAccountButton.click();
    }

    @FindBy(xpath = "//input[@id='field-email']")
    private WebElement email;

    void email(String input){
        email.sendKeys(input);
    }

    @FindBy(xpath = "//input[@id='field-password']")
    private WebElement password;

    void password(String input){
        password.sendKeys(input);
    }

    @FindBy(xpath = "//button[@id='submit-login']")
    private WebElement signInLogin;

    void signInLogin(){
        signInLogin.click();
    }
}
