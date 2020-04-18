package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseDataProvider {
@Test
    public void loginBaseWork(){
        System.setProperty("webdriver.chrome.driver", "/Users/palmauzzal/dataDriven/browser-drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://wordpress.com/log-in");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        driver.findElement(By.xpath("//*[text()='Email Address or Username']//following::input[1]")).sendKeys("donotenteradmin", Keys.ENTER);
        driver.findElement(By.xpath("//*[text()='Password']//following::input[1]")).sendKeys("Admin321!");
        driver.findElement(By.xpath("//button[text()='Log In']")).submit();

        System.out.println(driver.getTitle());
        driver.quit();
    }
}
