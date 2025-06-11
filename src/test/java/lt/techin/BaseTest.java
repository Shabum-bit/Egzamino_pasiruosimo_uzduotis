package lt.techin;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://teststore.automationtesting.co.uk/index.php");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
 //   @AfterEach
 //   public void afterEach(){
 //       if(driver != null){
 //           driver.quit();
 //       }
 //   }

}
