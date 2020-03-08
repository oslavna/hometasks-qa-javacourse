import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.core.StringContains;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.mustache.Value;
import pages.LoginPage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import pages.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

//- Открыть https://otus.ru
//        - Авторизоваться на сайте
//        - Войти в личный кабинет
//        - В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
//        - Нажать сохранить
//        - Открыть https://otus.ru в "чистом браузере"
//        - Авторизоваться на сайе
//        - Войти в личный кабинет
//        - Проверить, что в разделе "О себе" отображаются указанные ранее данные

public class OtusTest extends BaseHooks {

    String login = System.getProperty("login");
    String password = System.getProperty("password");

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void otusPageObjectTest() throws Exception {


        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        PersonalPage personalPage = new PersonalPage(driver);

        mainPage.open();
        loginPage.login(login,password);
        mainPage.openPersonalPage();
        personalPage.tabAboutMeOpen();


//        WebElement elementInField = driver.findElement(By.cssSelector(".container__col container__col_6 container__col_iphone-vp container__col_iphone-12"));
//        System.out.println("test" + elementInField.getText());
//        List<WebElement> elementsInFields = driver.findElements(By.cssSelector(".container__col container__col_6 container__col_iphone-vp container__col_iphone-12"));
//        for (WebElement element : elementsInFields) {
//            String textOfElement = element.getText();
//            System.out.println("test" + textOfElement);
//        }

        personalPage.enterName("Ольга");
        personalPage.enterSurname("Славнова");
        personalPage.enterLatinName("Olga");
        personalPage.enterLatinSurname("Slavnova");
        personalPage.enterBlogName("Оля");
        personalPage.enterDateOfBirth("12.08.1995");
        personalPage.selectCountry("Россия");
        personalPage.selectCityMoscow();
        personalPage.selectRemoteWork();
        personalPage.openFirstCommunicationTypeList();
        personalPage.selectCommunicationTypeFacebook();
        personalPage.saveChangesOnTheProfilePage();

        driver.quit();
        BaseHooks.setup();

        LoginPage newLoginPage = new LoginPage(driver);
        MainPage newMainPage = new MainPage(driver);
        PersonalPage newPersonalPage = new PersonalPage(driver);

        newMainPage.open();
        newLoginPage.login(login, password);
        newMainPage.openPersonalPage();
        newPersonalPage.tabAboutMeOpen();



        //newPersonalPage.getValueTextField(driver.findElements(By.cssSelector("")
        errorCollector.checkThat("Имя не соответствует",
                newPersonalPage.getValueTextField(driver.findElement(By.cssSelector("[name='fname']"))), new StringContains("Ольга"));


//


    }
}

