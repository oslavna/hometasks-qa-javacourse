import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test_Ya {

    public static final Logger logger = LogManager.getLogger(Test_Ya.class.getName());
    private WebDriver driver;
    private String baseUrl;
    WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        //WebDriverManager.chromedriver().arch32().proxy(ConfigProxy.httpProxy).setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("WebDriver initialization...");
        baseUrl = "https://market.yandex.ru/catalog--mobilnye-telefony/54726/list";
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.yandex.ru/");
    }

    @Test
    public void addXiaomiToCompare(){
        driver.get("https://www.yandex.ru/");
        logger.info("Get yandex.ru");
        driver.get("https://market.yandex.ru/catalog--mobilnye-telefony/54726/list");
        logger.info("Get market.yandex.ru");
        driver.findElement(By.xpath("//span[contains(text(),'Xiaomi')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'HUAWEI')]")).click();
        driver.findElement(By.cssSelector("fieldset[data-autotest-id='16816262'] > ul > li:last-child > div > label")).click();
        driver.findElement(By.linkText("по цене")).click();
        logger.info("Filters applied ");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloadable__preloader_visibility_visible")));
        String firstXiaomi = driver.findElement(By.cssSelector(":nth-child(1) > .n-snippet-cell2__header a")).getAttribute("title");
        driver.findElement(By.xpath("//div[contains(@class, 'n-product-toolbar__item')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-informer__details")));
        String popupTextXiaomi = driver.findElement(By.cssSelector(".popup-informer__title")).getText();
        logger.info("Select of the first Xiaomi smartphone, adding to compare ");
        Assert.assertEquals(String.format("Товар " + firstXiaomi + " добавлен к сравнению"), popupTextXiaomi);
    }

    @Test
    public void addHUAVEIToCompare() {
        //предусловие для выполнение теста - вызов предыдущего метода
        addXiaomiToCompare();
        logger.info("Previous test executed ");

        //избавление от сматфона Xoimi в списке, чтобы первым в списке был гарантировано HUAVEI
        driver.findElement(By.xpath("//span[contains(text(),'Xiaomi')]")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloadable__preloader_visibility_visible")));
        String firstHUAVEI = driver.findElement(By.cssSelector(":nth-child(1) > .n-snippet-cell2__header a")).getAttribute("title");
        driver.findElement(By.xpath("//div[contains(@class, 'n-product-toolbar__item')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-informer__details")));
        String popupTextTwoDevices = driver.findElement(By.cssSelector(".popup-informer__details")).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-informer__title")));
        String popupTextHUAVEI = driver.findElement(By.cssSelector(".popup-informer__title")).getText();
        logger.info("Select of the first Huavei smartphone, adding to compare ");
        Assert.assertEquals(String.format("Товар " + firstHUAVEI + " добавлен к сравнению"), popupTextHUAVEI);
        Assert.assertEquals(String.format("Всего в списке 2 товара из категории Мобильные телефоны"), popupTextTwoDevices);
        driver.findElement(By.linkText("Сравнить")).click();
    }

    @Test
    public void comparingOfPhones_diffCharacteristics() {
        driver.get("https://market.yandex.ru/compare/2AcMac7Bg1MAv5ciEUjBYPC71wy9?hid=91491&id=217969159&id=401338434");
        List<WebElement> listOfDiffCompareElements = driver.findElements(By.cssSelector(".n-compare-row-name i-bem"));
        logger.info("List of elements presented in comparing created");
        //перебор созданного списка на предмет совпадения с Операционная система
        for (WebElement compareElement : listOfDiffCompareElements) {
            String textOfElement = compareElement.getText();
            if (textOfElement.equals("Операционная система")) {
                logger.error("\"Операционная система\" is present ");
            } else Assert.assertNotEquals(textOfElement.toUpperCase(), "Операционная система");
        }
    }

    @Test
    public void comparingOfPhones_allCharacteristics() {
        driver.get("https://market.yandex.ru/compare/2AcMac7Bg1MAv5ciEUjBYPC71wy9?hid=91491&id=217969159&id=401338434");
        driver.findElement(By.xpath("//span[@class='link n-compare-show-controls__all']//span[@class='link__inner']")).click();
        logger.info("All characteristics part opened");
        List<WebElement> listOfCompareElements = driver.findElements(By.cssSelector(".n-compare-row-name i-bem"));
        //перебор созданного списка на предмет совпадения с Операционная система
        for (WebElement compareElement : listOfCompareElements) {
            String textOfElement = compareElement.getText();
            if (textOfElement.equals("Операционная система")) {
                Assert.assertEquals(textOfElement.toUpperCase(), "Операционная система");

            }
        }
    }

    @After
    public void setDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }

    }
}



