package helpers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class BaseHooks {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public static String baseUrl = "https://habr.com/ru/";

    public static String getBaseUrl(){
        return baseUrl;
    }

    public  void refreshPage() {
        driver.navigate().refresh();
    }

    public  String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public  String getTitle() {
        return driver.getTitle();
    }

    public  ArrayList<String> getAllTabs() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public  void switchToTab(int num) {
        driver.switchTo().window(getAllTabs().get(num));
    }

    public  void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("78.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public  void close() {
        if (driver != null) {
            driver.quit();
        }
    }
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }
}
