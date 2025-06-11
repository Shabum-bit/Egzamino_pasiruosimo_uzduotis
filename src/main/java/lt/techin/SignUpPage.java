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

    @FindBy(xpath = "//a[normalize-space()='No account? Create one here']")
    private WebElement createNewAccount;

    @FindBy(xpath = "//button[@id='submit-login']")
    private WebElement signInLogin;

    void clickSignInButton(){
        signInButton.click();
    }
    void clickCreateNewAccountButton() {
        createNewAccount.click();
    }
    void clickSignInLogin(){
        signInLogin.click();
    }
}
