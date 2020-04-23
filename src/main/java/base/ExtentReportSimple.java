package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ExtentReportSimple {

    private static WebDriver driver = null;
    public static void main(String[] args) throws IOException, InterruptedException {

        // start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Extent-Reports/ExtentReport.html");

        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it
        ExtentTest googleSearch = extent.createTest("Google Search", "Validate the wordpress login with valid credentials");

        System.setProperty("webdriver.chrome.driver", "/Users/palmauzzal/dataDriven/browser-drivers/chromedriver");
        driver = new ChromeDriver();
        googleSearch.log(Status.INFO, "Opened the Chrome browser");
        driver.get("https://wordpress.com/log-in");
        googleSearch.pass("Browser navigated https://wordpress.com/log-in");
        driver.manage().deleteAllCookies();
        googleSearch.pass("Deleted all the cookies");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        googleSearch.pass("Waited for browser loading");
        driver.manage().window().fullscreen();
        googleSearch.pass("Browser window became full screen");

        driver.findElement(By.xpath("//*[text()='Email Address or Username']//following::input[1]")).sendKeys("donotenteradmin", Keys.ENTER);
        googleSearch.pass("Send the user name to user name box and clicked enter");
        driver.findElement(By.xpath("//*[text()='Password']//following::input[1]")).sendKeys("Admin321!");
        googleSearch.pass("Send the Password to user password box");
        driver.findElement(By.xpath("//button[text()='Log In']")).submit();
        googleSearch.pass("Clicked on the submit button and login to the wordpress webside successfully");
        sleep(5000);

        Assert.assertTrue(driver.getTitle().contains("Following"),"User is not able to login - Please provide correct Password");
        System.out.println("Page Title verified - user was able to successfully login");
        driver.quit();
        googleSearch.pass("Closed the browser");
        googleSearch.info("Test passed");

        // calling flush writes everything to the log file
        extent.flush();

        ExtentTest googleSearch1 = extent.createTest("Google Search", "Validate the wordpress login with valid credentials");

        System.setProperty("webdriver.chrome.driver", "/Users/palmauzzal/dataDriven/browser-drivers/chromedriver");
        driver = new ChromeDriver();
        googleSearch1.log(Status.INFO, "Opened the Chrome browser");
        driver.get("https://wordpress.com/log-in");
        googleSearch1.pass("Browser navigated https://wordpress.com/log-in");
        driver.manage().deleteAllCookies();
        googleSearch1.pass("Deleted all the cookies");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        googleSearch1.pass("Waited for browser loading");
        driver.manage().window().fullscreen();
        googleSearch1.pass("Browser window became full screen");

        driver.findElement(By.xpath("//*[text()='Email Address or Username']//following::input[1]")).sendKeys("donotenteradmin", Keys.ENTER);
        googleSearch1.pass("Send the user name to user name box and clicked enter");
        driver.findElement(By.xpath("//*[text()='Password']//following::input[1]")).sendKeys("Admin321!");
        googleSearch1.pass("Send the Password to user password box");
        driver.findElement(By.xpath("//button[text()='Log In']")).submit();
        googleSearch1.fail("Clicked on the submit button and login to the wordpress webside successfully");
        sleep(5000);

        Assert.assertTrue(driver.getTitle().contains("Following"),"User is not able to login - Please provide correct Password");
        System.out.println("Page Title verified - user was able to successfully login");
        driver.quit();
        googleSearch1.pass("Closed the browser");
        googleSearch1.info("Test failed");



//        // log(Status, details)
//        googleSearch.log(Status.INFO, "This step shows usage of log(status, details)");

//        // info(details)
//        test.info("This step shows usage of info(details)");
//
//        // log with snapshot
//        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
//
//        // test with snapshot
//        test.addScreenCaptureFromPath("screenshot.png");
//
        // calling flush writes everything to the log file
        extent.flush();
    }
}
