import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeOptions;


public class SampleTest {

    protected static WebDriver driver;
    protected static String browser = System.getProperty("browser").toUpperCase();

    @Before
        public void setUp() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            //possible to run using options:
            //driver = WebDriverFactory.createNewDriver(DriverName.valueOf(browser), options);
            driver = WebDriverFactory.createNewDriver(DriverName.valueOf(browser));
        }
        @Test
        public void openPage() {
            driver.get("https://otus.ru/");
        }

        @After
        public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}










