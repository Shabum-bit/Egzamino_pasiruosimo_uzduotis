package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
     @FindBy(xpath = "//input[@id='field-id_gender-2']")
    private WebElement socialTitle;

    @FindBy(xpath = "//input[@id='field-firstname']")
    private  WebElement firstName;

    @FindBy(xpath = "//input[@id='field-lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='field-email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='field-password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='field-birthday']")
    private WebElement birthDate;

    @FindBy(xpath = "//input[@name='psgdpr']")
        private WebElement checkBox;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;


    void clickSocialTitle(){
        socialTitle.click();
    }

    void firstNameInput(String input){
        firstName.sendKeys(input);
    }

    void lastNameInput(String input) {
        lastName.sendKeys(input);
    }

    void emailInput(String input) {
        email.sendKeys(input);
    }

    void passwordInput(String input){
        password.sendKeys(input);
    }

    void birthDateInput(String input){
        birthDate.sendKeys(input);
    }

    void clickCheckBox(){
        checkBox.click();
    }

    void clickSaveButton(){
        saveButton.click();
    }

    boolean hasErrorMessage() {
        try {
            String validationMessage = firstName.getAttribute("validationMessage");
            return validationMessage != null && !validationMessage.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean hasNameFormatError() {
        try {
            return driver.findElements(By.xpath("//*[contains(text(), 'Invalid format')]")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean hasEmailAlreadyUsedError() {
        try {
            return driver.findElements(By.xpath("//*[contains(text(), 'already used')]")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean hasEmailAtSymbolError() {
        try {
            String validationMessage = email.getAttribute("validationMessage");
            return validationMessage != null && validationMessage.contains("@");
        } catch (Exception e) {
            return false;
        }
    }
    public boolean hasPasswordLengthError() {
        try {
            return driver.findElements(By.xpath("//*[contains(text(), 'between 6 and 72 characters')]")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasBirthDateFormatError() {
        try {
            return driver.findElements(By.xpath("//*[contains(text(), 'Format should be')]")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean hasCheckboxError() {
        try {
            String validationMessage = checkBox.getAttribute("validationMessage");
            return validationMessage != null && !validationMessage.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

}
