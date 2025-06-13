package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccessoriesPage extends BasePage {
    public AccessoriesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='facet_input_4962_0']")
    private WebElement homeAccessoriesFilter;

    @FindBy(xpath = "//input[@id='facet_input_4962_1']")
    private WebElement stationeryFilter;

    // Color checkboxes
    @FindBy(xpath = "//input[@id='facet_input_16210_0']")
    private WebElement whiteColorFilter;

    @FindBy(xpath = "//input[@id='facet_input_16210_1']")
    private WebElement blackColorFilter;

    public void selectHomeAccessories() {
        scrollToElement(homeAccessoriesFilter);
        homeAccessoriesFilter.click();
    }

    public void selectStationery() {
        scrollToElement(stationeryFilter);
        stationeryFilter.click();
    }

    public void selectWhiteColor() {
        scrollToElement(whiteColorFilter);
        whiteColorFilter.click();
    }

    public void selectBlackColor() {
        scrollToElement(blackColorFilter);
        blackColorFilter.click();
    }

    private void scrollToElement(WebElement element) {
        try {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(1000); // Short pause after scroll
        } catch (Exception e) {
            System.out.println("Scroll error: " + e.getMessage());
        }
    }

    public boolean isFilterApplied() {
        try {
            return driver.getCurrentUrl().contains("Categories-") ||
                    driver.getCurrentUrl().contains("Color-");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCategoryFiltered() {
        try {
            return driver.getCurrentUrl().contains("Home") ||
                    driver.getCurrentUrl().contains("Stationery");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isColorFiltered() {
        try {
            return driver.getCurrentUrl().contains("White") ||
                    driver.getCurrentUrl().contains("Black");
        } catch (Exception e) {
            return false;
        }
    }
}


 /*
    @FindBy(xpath = "//div[@class='ui-slider-range ui-widget-header ui-corner-all']")
    private WebElement priceSliderRange;

    public void setPriceRange() {

         try {
             WebElement priceSection = driver.findElement(By.xpath("//h6[contains(text(),'Price')]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", priceSection);

            Thread.sleep(3000);

             System.out.println("Page title: " + driver.getTitle());
             System.out.println("Current URL: " + driver.getCurrentUrl());

             WebElement priceFilter = driver.findElement(By.xpath("//div[contains(@class,'ui-slider-range')]"));
             priceFilter.click();

             System.out.println("Price filter clicked successfully");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
             e.printStackTrace();
        }
    }
    public boolean isPriceFiltered(){
        try{
            String currentUrl = driver.getCurrentUrl();
            return currentUrl.contains("q=Price-") || currentUrl.contains("Price-");
        } catch (Exception e){
            return false;
        }
    } */

