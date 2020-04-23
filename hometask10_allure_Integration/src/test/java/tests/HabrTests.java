package tests;

import helpers.BaseHooks;
import helpers.ErrorHelper;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.*;


@Epic("Allure")
@Owner("Olga S")
@DisplayName("Проверка доступных страниц на habr")
public class HabrTests extends BaseHooks {

    ErrorHelper errorHelper = new ErrorHelper();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();
    HubPage hubPage = new HubPage();
    TopPage topPage = new TopPage();
    AuthorsPage authorsPage = new AuthorsPage();
    CompaniesPage companiesPage = new CompaniesPage();

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Получение страницы новостей, сравнивается URL после перехода на эту страницу")
    @DisplayName("Доступность страницы новостей")
    public void newsPageAvailability() {
        mainPage.openHubrMainPage();
        mainPage.openNewsPage();
        Assert.assertTrue(newsPage.firstPostIsPresent());
        errorHelper.checkField(BaseHooks.getCurrentUrl(), newsPage.getPageUrl());
        saveAllureScreenshot();

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Получение страницы с хабами, сравнивается URL после перехода на эту страницу")
    @DisplayName("Доступность страницы Хабов")
    public void hubPageAvailability() {
        mainPage.openHubrMainPage();
        mainPage.openHubsPage();
        Assert.assertTrue(hubPage.topicsIsPresent());
        errorHelper.checkField(BaseHooks.getCurrentUrl(), hubPage.getPageUrl());
        saveAllureScreenshot();

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Получение страницы с публикациями, сравнивается URL после перехода на эту страницу")
    @DisplayName("Доступность страницы публикаций")
    public void topPageAvailability() {
        mainPage.openHubrMainPage();
        mainPage.openPublicationsPage();
        Assert.assertTrue(topPage.topicsIsPresent());
        errorHelper.checkField(BaseHooks.getCurrentUrl(), topPage.getPageUrl());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Получение страницы с авторами, сравнивается URL после перехода на эту страницу")
    @DisplayName("Доступность страницы с авторами")
    public void authorPageAvailability() {
        mainPage.openHubrMainPage();
        mainPage.openAuthorsPage();
        Assert.assertTrue(authorsPage.usersIsPresent());
        errorHelper.checkField(BaseHooks.getCurrentUrl(), authorsPage.getPageUrl());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Получение страницы о компаниях, сравнивается URL после перехода на эту страницу ")
    @DisplayName("Доступность страницы с компаниями")
    public void companiesPageAvailability() {
        mainPage.openHubrMainPage();
        mainPage.openCompaniesPage();
        Assert.assertTrue(companiesPage.companyListIsPresent());
        Assert.assertEquals("сломан для пёстрого отчета", BaseHooks.getCurrentUrl());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется открытие страницы разработки, сравнивается заголовок")
    @DisplayName("Открытие страницы разработки")
    public void devThreadOpening(){
        mainPage.openHubrMainPage();
        mainPage.openDevThread();
        Assert.assertEquals("Разработка", mainPage.getTitleOfThread());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется открытие страницы о науке, сравнивается заголовок")
    @DisplayName("Открытие страницы науки")
    public void scienceThreadOpening(){
        mainPage.openHubrMainPage();
        mainPage.openScienceThread();
        Assert.assertEquals("Научпоп", mainPage.getTitleOfThread());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется открытие страницы про администрирование, сравнивается заголовок")
    @DisplayName("Открытие страницы администрирования")
    public void adminThreadOpening(){
        mainPage.openHubrMainPage();
        mainPage.openAdminThread();
        Assert.assertEquals("Администрирование", mainPage.getTitleOfThread());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется открытие страницы о дизайне, сравнивается заголовок")
    @DisplayName("Открытие страницы о дизайне")
    public void designThreadOpening(){
        mainPage.openHubrMainPage();
        mainPage.openDesignThread();
        Assert.assertEquals("Дизайн", mainPage.getTitleOfThread());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется открытие страницы о маркетинге, сравнивается заголовок")
    @DisplayName("Открытие страницы о маркетинге")
    public void marketingThreadOpening(){
        mainPage.openHubrMainPage();
        mainPage.openMarketingThread();
        Assert.assertEquals("Маркетинг", mainPage.getTitleOfThread());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется переход на соц сеть вк, проверяется открытие соответствующей страницы в новой вкладке")
    @DisplayName("Переход на ВК")
    public void habrInVK() {
        mainPage.openHubrMainPage();
        mainPage.openVKPage();
        BaseHooks.switchToTab(1);
        Assert.assertEquals("https://vk.com/habr", BaseHooks.getCurrentUrl());
        saveAllureScreenshot();

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется переход на соц сеть Telegram, проверяется открытие соответствующей страницы в новой вкладке")
    @DisplayName("Переход на Telegram")
    public void habrInTelegram(){
        mainPage.openHubrMainPage();
        mainPage.openTelegram();
        BaseHooks.switchToTab(1);
        Assert.assertEquals("https://telegram.me/habr_com", BaseHooks.getCurrentUrl());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется переход на соц сеть Twitter, проверяется открытие соответствующей страницы в новой вкладке")
    @DisplayName("Переход на Twitter")
    public void habrInTwitter() {
        mainPage.openHubrMainPage();
        mainPage.openTwitter();
        BaseHooks.switchToTab(1);
        Assert.assertEquals("https://twitter.com/habr_com", BaseHooks.getCurrentUrl());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется переход на соц сеть Facebook, проверяется открытие соответствующей страницы в новой вкладке")
    @DisplayName("Переход на Facebook")
    public void habrInFacebook() {
        mainPage.openHubrMainPage();
        mainPage.openFacebook();
        BaseHooks.switchToTab(1);
        Assert.assertEquals("https://www.facebook.com/habrahabr.ru", BaseHooks.getCurrentUrl());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется переход на Yandex, проверяется открытие соответствующей страницы в новой вкладке")
    @DisplayName("Переход на Yandex")
    public void habrInYa(){
        mainPage.openHubrMainPage();
        mainPage.openYa();
        BaseHooks.switchToTab(1);
        Assert.assertEquals("https://zen.yandex.ru/habr", BaseHooks.getCurrentUrl());
        saveAllureScreenshot();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется переключение языка на английский, после выполнение происходит переключение обратно на русский")
    @DisplayName("Переключение языка на английский")
    public void changeLanguageToEnglish() {

        mainPage.openHubrMainPage();
        mainPage.openLangSettings();
        mainPage.selectLangEnglish();
        mainPage.saveLangSettings();

        BaseHooks.refreshPage();
        BaseHooks.getCurrentUrl();

        errorHelper.checkField(BaseHooks.getCurrentUrl(), "https://habr.com/en/");
        errorHelper.checkField(BaseHooks.getTitle(),"Top of the last 24 hours");
        changeLanguageToRussian();
        saveAllureScreenshot();

     }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется переключение языка на русский")
    @DisplayName("Переключение языка на русский")
    public void changeLanguageToRussian() {

        mainPage.openHubrMainPage();
        mainPage.openLangSettings();
        mainPage.selectLangRussiah();
        mainPage.saveLangSettings();

        BaseHooks.refreshPage();
        BaseHooks.getCurrentUrl();

        errorHelper.checkField(BaseHooks.getCurrentUrl(), "https://habr.com/ru/");
        errorHelper.checkField(BaseHooks.getTitle(),"Лучшие публикации за сутки");
        saveAllureScreenshot();
    }


}
