package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

     @FindBy(xpath = "//input[@id='field-id_gender-2']")
    private WebElement socialTitle;

    void socialTitle(){
        socialTitle.click();
    }

    @FindBy(xpath = "//input[@id='field-firstname']")
    private  WebElement firstName;

    void firstName(String input){
        firstName.sendKeys(input);
    }

    @FindBy(xpath = "//input[@id='field-lastname']")
    private WebElement lastName;

    void lastName(String input) {
        lastName.sendKeys(input);
    }

    @FindBy(xpath = "//input[@id='field-email']")
    private WebElement email;

    void email(String input) {
        email.sendKeys(input);
    }

    @FindBy(xpath = "//input[@id='field-password']")
    private WebElement password;

    void password(String input){
        password.sendKeys(input);
    }

    @FindBy(xpath = "//input[@id='field-birthday']")
    private WebElement birthDate;

    void birthDate(String input){
        birthDate.sendKeys(input);
    }

    @FindBy(xpath = "//input[@name='psgdpr']")
        private WebElement checkBox;

    void checkBox(){
            checkBox.click();
    }

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    void saveButton(){
        saveButton.click();
    }

}
