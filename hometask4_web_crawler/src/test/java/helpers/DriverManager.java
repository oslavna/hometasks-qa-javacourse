package helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

import static helpers.MyFileWriter.logger;

public class DriverManager {

    protected static WebDriver driver;
    protected static Actions action;
    protected static String browser = System.getProperty("browser").toUpperCase();


    public static WebDriver getDriver() {
        return driver;
    }

    public static Actions getAction() {
        return action;
    }

    public static void create() {
        driver = WebDriverFactory.createNewDriver(DriverName.valueOf(browser));
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
