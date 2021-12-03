package webDriverManagerTesting.webDriverManager;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main( String[] args ) {
        WebDriver driver = loadDriver(browserDriver.opera);
        driver.get("https://www.google.com.cu");
        Faker faker = new Faker();
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
        element.sendKeys(faker.artist().name());
        element.sendKeys(Keys.RETURN);
        driver.findElement(By.xpath("//h3")).click();
        driver.close();
    }

    private static WebDriver loadDriver(browserDriver browser) {
        switch (browser) {
            case edge:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case firefox:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case chrome:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case opera:
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            default:
                return null;
        }
    }
}
