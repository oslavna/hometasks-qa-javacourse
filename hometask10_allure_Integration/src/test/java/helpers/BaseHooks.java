package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class BaseHooks {

    protected static WebDriver driver;
//    protected static String browser = System.getProperty("browser").toUpperCase();
    public static String baseUrl = "https://habr.com/ru/";

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getBaseUrl(){
        return baseUrl;
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static String getTitle() {
        return driver.getTitle();
    }

    public static ArrayList<String> getAllTabs() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public static void switchToTab(int num) {
        driver.switchTo().window(getAllTabs().get(num));
    }

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

    }

    @AfterClass
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //    }
    @Before
    public void switchToFirstTab() {
        switchToTab(0);

    }


    @After
    public void closeTab() {
        if (getAllTabs().size() > 1) {            //social networks are opening in new tabs. It affects next tests
            driver.close();
        }
    }

    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }
}
