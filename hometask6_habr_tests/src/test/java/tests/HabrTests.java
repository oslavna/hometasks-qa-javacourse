package tests;

import helpers.BaseHooks;
import org.junit.*;
import pages.*;
import helpers.*;

public class HabrTests extends BaseHooks {

    ErrorHelper errorHelper = new ErrorHelper();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();
    HubPage hubPage = new HubPage();
    TopPage topPage = new TopPage();
    AuthorsPage authorsPage = new AuthorsPage();
    CompaniesPage companiesPage = new CompaniesPage();

    @Test
    public void newsPageAvailability() {

        mainPage.openHubrMainPage();
        mainPage.openNewsPage();
        Assert.assertTrue(newsPage.firstPostIsPresent());
        errorHelper.checkField(BaseHooks.getCurrentUrl(), newsPage.getPageUrl());

    }

    @Test
    public void hubPageAvailability() {

        mainPage.openHubrMainPage();
        mainPage.openHubsPage();
        Assert.assertTrue(hubPage.topicsIsPresent());
        errorHelper.checkField(BaseHooks.getCurrentUrl(), hubPage.getPageUrl());

    }

    @Test
    public void topPageAvailability() {
        mainPage.openHubrMainPage();
        mainPage.openPublicationsPage();
        Assert.assertTrue(topPage.topicsIsPresent());
        errorHelper.checkField(BaseHooks.getCurrentUrl(), topPage.getPageUrl());
    }

    @Test
    public void authorPageAvailability() {
        mainPage.openHubrMainPage();
        mainPage.openAuthorsPage();
        Assert.assertTrue(authorsPage.usersIsPresent());
        errorHelper.checkField(BaseHooks.getCurrentUrl(), authorsPage.getPageUrl());
    }

    @Test
    public void companiesPageAvailability() {
        mainPage.openHubrMainPage();
        mainPage.openCompaniesPage();
        Assert.assertTrue(companiesPage.companyListIsPresent());
        errorHelper.checkField(BaseHooks.getCurrentUrl(), companiesPage.getPageUrl());
    }

    @Test
    public void devThreadOpening(){
        mainPage.openHubrMainPage();
        mainPage.openDevThread();
        Assert.assertEquals("Разработка", mainPage.getTitleOfThread());
    }

    @Test
    public void scienceThreadOpening(){
        mainPage.openHubrMainPage();
        mainPage.openScienceThread();
        Assert.assertEquals("Научпоп", mainPage.getTitleOfThread());
    }

    @Test
    public void adminThreadOpening(){
        mainPage.openHubrMainPage();
        mainPage.openAdminThread();
        Assert.assertEquals("Администрирование", mainPage.getTitleOfThread());
    }

    @Test
    public void designThreadOpening(){
        mainPage.openHubrMainPage();
        mainPage.openDesignThread();
        Assert.assertEquals("Дизайн", mainPage.getTitleOfThread());
    }

    @Test
    public void marketingThreadOpening(){
        mainPage.openHubrMainPage();
        mainPage.openMarketingThread();
        Assert.assertEquals("Маркетинг", mainPage.getTitleOfThread());
    }

    @Test
    public void habrInVK() {
        mainPage.openHubrMainPage();
        mainPage.openVKPage();
        BaseHooks.switchToTab(1);
        Assert.assertEquals("https://vk.com/habr", BaseHooks.getCurrentUrl());

    }

    @Test
    public void habrInTelegram(){

        mainPage.openHubrMainPage();
        mainPage.openTelegram();
        BaseHooks.switchToTab(1);
        Assert.assertEquals("https://telegram.me/habr_com", BaseHooks.getCurrentUrl());
    }

    @Test
    public void habrInTwitter() {
        mainPage.openHubrMainPage();
        mainPage.openTwitter();
        BaseHooks.switchToTab(1);
        Assert.assertEquals("https://twitter.com/habr_com", BaseHooks.getCurrentUrl());
    }

    @Test
    public void habrInFacebook() {
        mainPage.openHubrMainPage();
        mainPage.openFacebook();
        BaseHooks.switchToTab(1);
        Assert.assertEquals("https://www.facebook.com/habrahabr.ru", BaseHooks.getCurrentUrl());
    }

    @Test
    public void habrInYa(){
        mainPage.openHubrMainPage();
        mainPage.openYa();
        BaseHooks.switchToTab(1);
        Assert.assertEquals("https://zen.yandex.ru/habr", BaseHooks.getCurrentUrl());
    }

    @Test
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

     }

    @Test
    public void changeLanguageToRussian() {

        mainPage.openHubrMainPage();
        mainPage.openLangSettings();
        mainPage.selectLangRussiah();
        mainPage.saveLangSettings();

        BaseHooks.refreshPage();
        BaseHooks.getCurrentUrl();

        errorHelper.checkField(BaseHooks.getCurrentUrl(), "https://habr.com/ru/");
        errorHelper.checkField(BaseHooks.getTitle(),"Лучшие публикации за сутки");
    }


}
