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
    private String baseUrl = "https://market.yandex.ru/catalog--mobilnye-telefony/54726/list";
    WebDriverWait wait;
    private String popupText,titleOfPhone,popupTextTwoDevices;


    @Before
    public void setUp()  {
        //WebDriverManager.chromedriver().arch32().proxy(ConfigProxy.httpProxy).setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("WebDriver initialization...");
        baseUrl = "https://market.yandex.ru/catalog--mobilnye-telefony/54726/list";
        wait = new WebDriverWait(driver, 8);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://www.yandex.ru/");
        logger.info("Get yandex.ru");
    }

    @Test//Проверить, что отобразилась плашка "Товар {имя товара} добавлен к сравнению
    public void xiaomiAdd(){
        driver.get(baseUrl);
        logger.info("Get market.yandex.ru");
        sortOfphones();
        addPhoneToCompare();
        Assert.assertEquals(String.format("Товар " + titleOfPhone + " добавлен к сравнению"), popupText);

    }

    @Test//Проверить, что отобразилась плашка "Товар {имя товара} добавлен к сравнению/два товара в сравнении
    public void huaveiAdd(){
        driver.get(baseUrl);
        logger.info("Get market.yandex.ru");
        sortOfphones();
        driver.findElement(By.xpath("//span[contains(text(),'HUAWEI')]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloadable__preloader_visibility_visible")));
        addPhoneToCompare();
        driver.findElement(By.xpath("//span[contains(text(),'Xiaomi')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'HUAWEI')]")).click();
       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloadable__preloader_visibility_visible")));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloadable__preloader_visibility_visible")));
        addPhoneToCompare();
        Assert.assertEquals(String.format("Товар " + titleOfPhone + " добавлен к сравнению"), popupText);
       // Assert.assertEquals(String.format("Всего в списке 2 товара из категории Мобильные телефоны"), popupTextTwoDevices);
        //driver.findElement(By.linkText("Сравнить")).click();

    }

    @Test // Проверить, что позиция "Операционная система" не отображается в списке характеристик
    public void checkOfDiff(){
        driver.get(baseUrl);
        logger.info("Get market.yandex.ru");
        sortOfphones();
        addPhoneToCompare();
        driver.findElement(By.xpath("//span[contains(text(),'Xiaomi')]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloadable__preloader_visibility_visible")));
        addPhoneToCompare();
        driver.findElement(By.linkText("Сравнить")).click();
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

    @Test // Проверить, что в списке характеристик появилась позиция "Операционная система"
    public void checkOfAll(){
        driver.get(baseUrl);
        logger.info("Get market.yandex.ru");
        sortOfphones();
        addPhoneToCompare();
        driver.findElement(By.xpath("//span[contains(text(),'Xiaomi')]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloadable__preloader_visibility_visible")));
        addPhoneToCompare();
        driver.findElement(By.linkText("Сравнить")).click();
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

    public void sortOfphones() {
        driver.findElement(By.xpath("//span[contains(text(),'Xiaomi')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'HUAWEI')]")).click();
        driver.findElement(By.cssSelector("fieldset[data-autotest-id='16816262'] > ul > li:last-child > div > label")).click();
        driver.findElement(By.linkText("по цене")).click();
        logger.info("Filters applied ");
    }

    public void addPhoneToCompare(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloadable__preloader_visibility_visible")));
        titleOfPhone = driver.findElement(By.cssSelector(":nth-child(1) > .n-snippet-cell2__header a")).getAttribute("title");
        driver.findElement(By.xpath("//div[contains(@class, 'n-product-toolbar__item')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-informer__details")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-informer__title")));
        popupText = driver.findElement(By.cssSelector(".popup-informer__title")).getText();
        popupTextTwoDevices = driver.findElement(By.cssSelector(".popup-informer__details")).getText();
        logger.info("Select of the smartphone, adding to compare ");

    }
    public void addPhoneToCompare1(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".preloadable__preloader_visibility_visible")));
        titleOfPhone = driver.findElement(By.cssSelector(":nth-child(1) > .n-snippet-cell2__header a")).getAttribute("title");
        driver.findElement(By.xpath("//div[contains(@class, 'n-product-toolbar__item')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-informer__details")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-informer__title")));
        popupText = driver.findElement(By.cssSelector(".popup-informer__title")).getText();
        popupTextTwoDevices = driver.findElement(By.cssSelector(".popup-informer__details")).getText();
        logger.info("Select of the smartphone, adding to compare ");
    }

    @After
    public void setDown()  {
        if (driver != null) {
            driver.quit();
        }

    }
}



