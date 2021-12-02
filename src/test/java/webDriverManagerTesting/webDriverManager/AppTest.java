package webDriverManagerTesting.webDriverManager;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main( String[] args ) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.cu");
        Faker faker = new Faker();
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
        element.sendKeys(faker.artist().name());
        element.sendKeys(Keys.RETURN);
        driver.findElement(By.xpath("//h3")).click();
        driver.close();
    }
}
