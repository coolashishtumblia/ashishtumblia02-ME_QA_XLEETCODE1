package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: TestCase01");
        driver.get("https://leetcode.com/ ");
        String url = driver.getCurrentUrl();
        if (url.toLowerCase().contains("leetcode")) {
            System.out.println("Test Case01: PASSED");
        } else {
            System.out.println("Test Case01: FAILED");
        }
        System.out.println("end Test case: TestCase01");
    }

    public void testCase02() {
        System.out.println("Start Test case: TestCase02");
        driver.get("https://leetcode.com/ ");
        WebElement question = driver.findElement(By.xpath("//a[@href='/problemset/']"));
        question.click();
        String url = driver.getCurrentUrl();
        if (url.toLowerCase().contains("problemset")) {
            List<WebElement> details = driver.findElements(By.xpath(
                    "//div[@class='odd:bg-layer-1 even:bg-overlay-1 dark:odd:bg-dark-layer-bg dark:even:bg-dark-fill-4']"));
            String[] detail = new String[5];
            for (int i = 0; i < 5; i++) {
                detail[i] = details.get(i + 1).getText();
            }
            for (String data : detail) {
                System.out.println(data);
            }
            List<WebElement> titleElements = driver
                    .findElements(By.xpath("//div[@class='max-w-[302px] flex items-center overflow-hidden']"));
            String[] titles = new String[5];
            for (int i = 0; i < 5; i++) {
                titles[i] = titleElements.get(i + 1).getText();
            }
                if (titles[0].equals("1. Two Sum") && titles[1].equals("2. Add Two Numbers") && titles[2].equals("3. Longest Substring Without Repeating Characters")
                        && titles[3].equals("4. Median of Two Sorted Arrays") && titles[4].equals("5. Longest Palindromic Substring")) {
                            System.out.println("Test Case02: PASSED");
                }
            
        } else {
            System.out.println("Test Case02: FAILED");
        }
        System.out.println("end Test case: TestCase02");
    }

    public void testCase03() {
        System.out.println("Start Test case: TestCase03");
        driver.get("https://leetcode.com/ ");
        WebElement question = driver.findElement(By.xpath("//a[@href='/problemset/']"));
        question.click();
        WebElement twosum=driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
        twosum.click();
        String url = driver.getCurrentUrl();
        if (url.toLowerCase().contains("two-sum")) {
            System.out.println("Test Case03: PASSED");
        } else {
            System.out.println("Test Case03: FAILED");
        }
        System.out.println("end Test case: TestCase03");
    }

    public void testCase04() {
        System.out.println("Start Test case: TestCase04");
        driver.get("https://leetcode.com/ ");
        WebElement question = driver.findElement(By.xpath("//a[@href='/problemset/']"));
        question.click();
        WebElement twosum=driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
        twosum.click();
        WebElement submit=driver.findElement(By.id("submissions_tab"));
        submit.click();
        WebElement registerandloginbutton=driver.findElement(By.xpath("(//a[text()='Register or Sign In'])[1]"));
        String message=registerandloginbutton.getText();
        if (message.equals("Register or Sign In")) {
            System.out.println("Test Case04: PASSED");
        } else {
            System.out.println("Test Case04: FAILED");
        }
        System.out.println("end Test case: TestCase04");
    }

}
