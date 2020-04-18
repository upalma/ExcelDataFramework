package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class BaseDataProvider {
    WebDriver driver;

    @Test(dataProvider = "credentialData")
    public void loginBaseWork( String userName, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/palmauzzal/dataDriven/browser-drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://wordpress.com/log-in");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        driver.findElement(By.xpath("//*[text()='Email Address or Username']//following::input[1]")).sendKeys(userName, Keys.ENTER);
        sleep(5);
        driver.findElement(By.xpath("//*[text()='Password']//following::input[1]")).sendKeys(password);
        sleep(5);
        driver.findElement(By.xpath("//button[text()='Log In']")).submit();


        Assert.assertTrue(driver.getTitle().contains("Log In"),"User is not able to login - Please provide correct Password");
        System.out.println("Page Title verified - user was able to successfully login");
        System.out.println(enterCredentials());


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();

    }

    @DataProvider(name = "credentialData")
    public Object [][] enterCredentials(){
        Object [][] credentials = new Object[3][2];

        credentials[0][0] ="88888";
        credentials[0][1] ="99999";

        credentials[1][0] ="donotenteradmin";
        credentials[1][1] ="Admin321!";

        credentials[2][0] ="abcdn";
        credentials[2][1] ="efgh!";


        return credentials;

    }
}
