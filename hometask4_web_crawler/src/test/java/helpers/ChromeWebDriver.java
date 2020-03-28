package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

import static helpers.MyFileWriter.logger;

public class ChromeWebDriver {

    protected static WebDriver driver;
    protected static Actions action;

    public static WebDriver getDriver() {
        return driver;
    }

    public static Actions getAction() {
        return action;
    }

    public static void create() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        if (driver != null) {
            logger.info("WebDriver created and up");
        }
    }


    public static void quit(){
        if (driver != null) {
            driver.quit();
        }
        logger.info("WebDriver closing...");

    }
}
