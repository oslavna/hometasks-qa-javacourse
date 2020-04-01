package component.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class Driver {

    protected static WebDriver driver;
    protected static Actions action;
    protected static WebDriverWait wait;

    public static WebDriverWait getWait() {
        return wait;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void getChromeDriver() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 5);
            action = new Actions(driver);
        }

    public static void getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        action = new Actions(driver);
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }

    }
}
