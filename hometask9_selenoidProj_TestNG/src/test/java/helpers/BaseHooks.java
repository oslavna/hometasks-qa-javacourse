package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class BaseHooks {

    private WebDriver driver;
    String selenoid = System.getProperty("selenoid");

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
        driver = new RemoteWebDriver(new URL(selenoid), capabilities);
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public  void close() {
        if (driver != null) {
            driver.close();
        }
    }
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }
}
