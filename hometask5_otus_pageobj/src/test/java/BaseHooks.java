import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseHooks {
    protected static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

}