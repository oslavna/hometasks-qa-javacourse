import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import pages.LoginPage;
import org.junit.Test;
import pages.*;

import org.hamcrest.core.StringContains;
import org.junit.*;

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
        personalPage.enterName("Ольга");
        personalPage.enterSurname("Славнова");
        personalPage.enterLatinName("Olga");
        personalPage.enterLatinSurname("Slavnova");
        personalPage.enterBlogName("Оля");
        personalPage.enterDateOfBirth("12.08.1995");
        personalPage.selectCountry("Россия");
        personalPage.selectCity("Москва");
        personalPage.selectRemote();
        personalPage.openFirstContact();
        personalPage.selectContactVk();
        personalPage.enterVkID("os_slavnova");
        personalPage.openSecondContact();
        personalPage.selectContactSkype();
        personalPage.enterSkypeName("live:olga.slavnova");
        personalPage.selectMaleOrFemale();
        personalPage.enterCompany("Kaspersky Lab");
        personalPage.save();

        driver.quit();
        BaseHooks.setup();

        LoginPage newLoginPage = new LoginPage(driver);
        MainPage newMainPage = new MainPage(driver);
        PersonalPage newPersonalPage = new PersonalPage(driver);
        newMainPage.open();
        newLoginPage.login(login, password);
        newMainPage.openPersonalPage();
        newPersonalPage.tabAboutMeOpen();


        errorCollector.checkThat("Name", newPersonalPage.getText(driver.findElement(By.cssSelector("[name='fname']"))), new StringContains("Ольга"));
        errorCollector.checkThat("Latin name", newPersonalPage.getText(driver.findElement(By.cssSelector("[name='fname_latin']"))), new StringContains("Olga"));
        errorCollector.checkThat("Surname", newPersonalPage.getText(driver.findElement(By.cssSelector("[name='lname']"))), new StringContains("Славнова"));
        errorCollector.checkThat("Latin surname", newPersonalPage.getText(driver.findElement(By.cssSelector("[name='lname_latin']"))), new StringContains("Slavnova"));
        errorCollector.checkThat("Blog name", newPersonalPage.getText(driver.findElement(By.cssSelector("[name='blog_name']"))), new StringContains("Оля"));
        errorCollector.checkThat("Date of birth", newPersonalPage.getText(driver.findElement(By.cssSelector("[name='date_of_birth']"))), new StringContains("12.08.1995"));
        errorCollector.checkThat("vk", newPersonalPage.getText(driver.findElement(By.cssSelector("[name='contact-1-value']"))), new StringContains("os_slavnova"));
        errorCollector.checkThat("Skype", newPersonalPage.getText(driver.findElement(By.cssSelector("[name='contact-0-value']"))), new StringContains("live:olga.slavnova"));
        errorCollector.checkThat("Gender", newPersonalPage.getText(driver.findElement(By.cssSelector("[id='id_gender']"))), new StringContains("f"));
        errorCollector.checkThat("Company", newPersonalPage.getText(driver.findElement(By.cssSelector("[name='company']"))), new StringContains("Kaspersky Lab"));

    }
}

