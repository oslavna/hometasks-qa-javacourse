package tests;

import helpers.BaseHooks;
import helpers.ErrorHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import java.net.MalformedURLException;

public class HabrTests extends BaseHooks {

    private MainPage mainPage;
    private  ErrorHelper errorHelper;
    private HubPage hubPage;
    private TopPage topPage;
    private CompaniesPage companiesPage;


    @Before
    public void setUp() throws MalformedURLException {
        setup();
        mainPage = new MainPage(getDriver());
        errorHelper = new ErrorHelper();
        mainPage = new MainPage(getDriver());
        hubPage = new HubPage(getDriver());
        topPage = new TopPage(getDriver());
        companiesPage = new CompaniesPage(getDriver());
    }

    @After
    public void tearDown() {
        close();
    }

    @Test
    public void hubPageAvailability() {
        mainPage.openHubrMainPage();
        mainPage.openHubsPage();
        Assert.assertTrue(hubPage.topicsIsPresent());
        errorHelper.checkField(getCurrentUrl(), hubPage.getPageUrl());
    }

    @Test
    public void topPageAvailability() {
        mainPage.openHubrMainPage();
        mainPage.openPublicationsPage();
        Assert.assertTrue(topPage.topicsIsPresent());
        errorHelper.checkField(getCurrentUrl(), topPage.getPageUrl());
    }

    @Test
    public void companiesPageAvailability() {
        mainPage.openHubrMainPage();
        mainPage.openCompaniesPage();
        Assert.assertTrue(companiesPage.companyListIsPresent());
        errorHelper.checkField(getCurrentUrl(), companiesPage.getPageUrl());
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
    public void habrInYa(){
        mainPage.openHubrMainPage();
        mainPage.openYa();
        switchToTab(1);
        Assert.assertEquals("https://zen.yandex.ru/habr", getCurrentUrl());
    }

    @Test
    public void changeLanguageToEnglish() {

        mainPage.openHubrMainPage();
        mainPage.openLangSettings();
        mainPage.selectLangEnglish();
        mainPage.saveLangSettings();

        refreshPage();
        getCurrentUrl();

        errorHelper.checkField(getCurrentUrl(), "https://habr.com/en/");
        errorHelper.checkField(getTitle(),"Top of the last 24 hours");
        changeLanguageToRussian();

     }

    @Test
    public void changeLanguageToRussian() {

        mainPage.openHubrMainPage();
        mainPage.openLangSettings();
        mainPage.selectLangRussiah();
        mainPage.saveLangSettings();

        refreshPage();
        getCurrentUrl();

        errorHelper.checkField(getCurrentUrl(), "https://habr.com/ru/");
        errorHelper.checkField(getTitle(),"Лучшие публикации за сутки");
    }

}
