package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class MultipleBrowser {
    WebDriver driver;
    String baseUrl = "https://www.google.com/";

    @Parameters({"browser"})
    @BeforeTest
    public void launchBrowser(String browser) {

        if (browser.equalsIgnoreCase("Chrome_Browser")) {
            System.out.println("Start testing with : " +browser);
            System.setProperty("webdriver.chrome.driver", "/Users/palmauzzal/dataDriven/browser-drivers/chromedriver");
            driver = new ChromeDriver();
            System.out.println("Chrome Browser was lunched Successfully");
            }
        if (browser.equalsIgnoreCase("Firefox_Browser")) {
            System.out.println("Start testing with : " +browser);
            System.setProperty("webdriver.gecko.driver", "/Users/palmauzzal/dataDriven/browser-drivers/geckodriver");
            driver = new FirefoxDriver();
            System.out.println("Firefox Browser was lunched Successfully");
            }
        if (browser.equalsIgnoreCase("Safari_Browser")) {
            System.out.println("Start testing with : " +browser);
            System.setProperty("webdriver.safari.com", "/Users/palmauzzal/dataDriven/browser-drivers/Safari");
            driver = new SafariDriver();
            System.out.println("Safari Browser was lunched Successfully");
            }
        }

    @Test
    public void loginWardPad() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(4000);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}


