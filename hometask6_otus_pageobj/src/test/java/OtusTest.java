import pages.LoginPage;
import org.junit.Test;
import pages.MainPage;
import pages.PersonalPage;

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

    @Test
    public void otusPageObjectTest() throws Exception {

        LoginPage loginPage = new LoginPage(BaseHooks.getDriver());
        MainPage mainPage = new MainPage(BaseHooks.getDriver());
        PersonalPage personalPage = new PersonalPage(BaseHooks.getDriver());
        BaseHooks baseHooks = new BaseHooks();

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

        baseHooks.cleanUp();

        mainPage.open();
        loginPage.login(login, password);
        mainPage.openPersonalPage();
        personalPage.tabAboutMeOpen();

        ErrorHelper errorHelper = new ErrorHelper();
        errorHelper.checkField(personalPage.getName(), "Ольга");
        errorHelper.checkField(personalPage.getSurname(),"Славнова");
        errorHelper.checkField(personalPage.getLatinName(),"Olga");
        errorHelper.checkField(personalPage.getLatinSurname(),"Slavnova");
        errorHelper.checkField(personalPage.getBlogName(),"Оля");
        errorHelper.checkField(personalPage.getDateOfBirth(),"12.08.1995");
        errorHelper.checkField(personalPage.getFemaleOrMale(),"f");
        errorHelper.checkField(personalPage.getVKContact(),"os_slavnova");
        errorHelper.checkField(personalPage.getSkypeContact(),"live:olga.slavnova");
        errorHelper.checkField(personalPage.getCompany(),"Kaspersky Lab");
    }
}

