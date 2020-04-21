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

public class MultipleDataWithDataProvider {

    WebDriver driver;

@Test(dataProvider = "credential")
     public void loginBaseWork (String userName, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/palmauzzal/dataDriven/browser-drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://wordpress.com/log-in");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        driver.findElement(By.xpath("//*[text()='Email Address or Username']//following::input[1]")).sendKeys(userName);
        sleep(5000);
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
        driver.findElement(By.xpath("//*[text()='Password']//following::input[1]")).sendKeys(password);
        //driver.findElement(By.xpath("//button[text()='Log In']")).submit();
        sleep(5000);

        Assert.assertTrue(driver.getTitle().contains("Log In"),"User is not able to login - Please provide correct Password");
        System.out.println("Page Title verified - user was able to successfully login");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name = "credential")
    public Object [][] singleCredentials(){

    Object [][] credentials = new Object[4][2];

        credentials[0] [0]="donotenteradmin";
        credentials[0][1] ="Admin321!";

        credentials[1] [0]="donotenteradmin";
        credentials[1][1] ="Admin321!";

        credentials[2] [0]="donotenteradmin";
        credentials[2][1] ="Admin321111!";

        credentials[3] [0]="donotenteradmin";
        credentials[3][1] ="Admin321111!";
         return credentials;
        }
    }

