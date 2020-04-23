package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

public class ExtentReportTestNG {
    WebDriver driver = null;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    @BeforeSuite
    public void setUp() {
        htmlReporter = new ExtentHtmlReporter("./Extent-Reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome", "/Users/palmauzzal/dataDriven/browser-drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void sendTextToTextBox() throws InterruptedException {
        ExtentTest googleSearch = extent.createTest("Google Search", "Validate the wordpress login with valid credentials");
        driver.get("https://www.google.com");
        googleSearch.pass("Browser navigated https://www.google.com");
        driver.manage().deleteAllCookies();
        googleSearch.pass("Deleted all the cookies");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        googleSearch.pass("Waited for browser loading");
        driver.manage().window().fullscreen();
        googleSearch.pass("Browser window became full screen");
        driver.findElement(By.xpath("//*/input[@name='q' and @type='text']")).sendKeys("Mobile Phone", Keys.ENTER);
        googleSearch.pass("Send the text 'Mobile Phone'to the text box and clicked enter");
        sleep(5000);
    }

    @Test
    public void sendTextToTextBox1() throws InterruptedException, IOException {
        ExtentTest googleSearch1 = extent.createTest("Google Search", "Validate the wordpress login with valid credentials");
        driver.get("https://www.google.com");
        googleSearch1.pass("Browser navigated https://www.google.com");
        driver.manage().deleteAllCookies();
        googleSearch1.pass("Deleted all the cookies");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        googleSearch1.pass("Waited for browser loading");
        driver.manage().window().fullscreen();
        googleSearch1.pass("Browser window became full screen");
        driver.findElement(By.xpath("//*/input[@name='q' and @type='text']")).sendKeys("Mobile Phone", Keys.ENTER);
        //screen shoot is not working
        googleSearch1.fail("Send the text 'Mobile Phone'to the text box and clicked enter", MediaEntityBuilder.createScreenCaptureFromPath(htmlReporter+"/ExtentReport.jpg").build());
        sleep(5000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
        System.out.println("Test was complete successfully");
    }
    @AfterSuite
    public void tearDown(){
        extent.flush();

    }
}




