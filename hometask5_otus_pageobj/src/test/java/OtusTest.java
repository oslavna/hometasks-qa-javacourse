import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class OtusTest {
    protected static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void otusPageObjTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open().login();
    }


    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

}