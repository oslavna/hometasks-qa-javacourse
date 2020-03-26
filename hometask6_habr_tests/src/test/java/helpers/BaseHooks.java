package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class BaseHooks {

    protected static WebDriver driver;
    protected static String browser = System.getProperty("browser").toUpperCase();

    public static WebDriver getDriver() {
        return driver;
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
        //WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.createNewDriver(DriverName.valueOf(browser));

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(18, TimeUnit.SECONDS);
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
    public void cleanUp() {
        if (getAllTabs().size() > 1) {            //social networks are opening in new tabs. It affects next tests
            driver.close();
        }
    }
}











