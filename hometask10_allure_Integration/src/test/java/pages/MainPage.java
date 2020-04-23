package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{


    //      elements factory
    @FindBy(css = ".stacked-menu [href*='popsci']")
    protected WebElement scienceThreads;

    @FindBy(css = ".stacked-menu [href*='admin']")
    protected WebElement adminThreads;

    @FindBy(css = ".stacked-menu [href*='design']")
    protected WebElement designThreads;

    @FindBy(css = ".stacked-menu [href*='marketing']")
    protected WebElement marketingThreads;

    @FindBy(css = ".stacked-menu [href*='develop']")
    protected WebElement devThreads;

    @FindBy(xpath = "//div[contains(@class,'page-header page-header_110')]")
    protected WebElement headerOfThread;

    @FindBy(css = "[class*='link_vkontakte']")
    protected WebElement linkVK;

    @FindBy(css = "[class*='link_telegram']")
    protected WebElement telegram;

    @FindBy(css = "[class*='link_twitter']")
    protected WebElement twitter;

    @FindBy(css = "[class*='link_facebook']")
    protected WebElement facebook;

    @FindBy(css = "[class*='link_zen']")
    protected WebElement yandex;

    @FindBy(css = "button[class*='show_lang_settings']")
    protected WebElement langSettings;

    @FindBy(css = "[Type='submit']")
    protected WebElement langSettingsButton;

    @FindBy(xpath = ".//h3[contains(text(),'Новости')]")
    protected WebElement newsButton;

    @FindBy(xpath = ".//h3[contains(text(),'Хабы')]")
    protected WebElement hubsButton;

    @FindBy(xpath = ".//h3[contains(text(),'Статьи')]")
    protected WebElement topButton;

    @FindBy(xpath = ".//h3[contains(text(),'Авторы')]")
    protected WebElement authorsButton;

    @FindBy(xpath = ".//h3[contains(text(),'Компании')]")
    protected WebElement companiesButton;

    //getters

    public WebElement getDevThreads(){
        return devThreads;
    }

    public WebElement getScienceThreads(){
        return scienceThreads;
    }

    public WebElement getAdminThreads(){
        return adminThreads;
    }

    public WebElement getDesignThreads(){
        return designThreads;
    }

    public WebElement getMarketingThreads(){
        return marketingThreads;
    }

    public WebElement getHeaderOfThread(){
        return headerOfThread;
    }

    public WebElement getPublications(){
        return topButton;
    }

    public WebElement getAuthors(){
        return authorsButton;
    }

    public WebElement getCompaniesButton(){
        return companiesButton;
    }

    public WebElement getNewsButton() {
        return newsButton;
    }

    public WebElement getHubsButton(){
        return hubsButton;
    }

    public WebElement getLangSettingsButton() {
        return langSettingsButton;
    }

    public WebElement getLangSettings() {
        return langSettings;
    }

    public WebElement getVK() {
        return linkVK;
    }

    public WebElement getTelegram() {
        return telegram;
    }

    public WebElement getTwitter() {
        return twitter;
    }
    public WebElement getFacebook() {
        return facebook;
    }

    public WebElement getYa() {
        return yandex;
    }

    public String getHubrMainUrl() {
        return baseUrl;
    }

    //methods
    @Step("Открытие страницы \"Разработка\"")
    public void openDevThread(){
        getDevThreads().click();
    }
    @Step("Открытие страницы \"Наука\"")
    public void openScienceThread(){
        getScienceThreads().click();
    }
    @Step("Открытие страницы \"Администрирование\"")
    public void openAdminThread(){
        getAdminThreads().click();
    }
    @Step("Открытие страницы \"Дизайн\"")
    public void openDesignThread(){
        getDesignThreads().click();
    }
    @Step("Открытие страницы \"Маркетинг\"")
    public void openMarketingThread(){
        getMarketingThreads().click();
    }
    @Step("Получение заголовка потока ")
    public String getTitleOfThread(){
        return getHeaderOfThread().getText();
    }
    @Step("Открытие главное страницы ")
    public void openHubrMainPage(){
        baseHooks.getDriver().get(getHubrMainUrl());
    }

    @Step("Открытие страницы с новостями")
    public void openNewsPage() {
        try {
            getNewsButton().click();
        } catch (NoSuchElementException e) {
            baseHooks.cleanUp();
            openHubrMainPage();
            getNewsButton().click();
        }
    }
    @Step("Клик по кнопке \"Хабы\"")
    public void openHubsPage(){
        getHubsButton().click();
    }
    @Step("Открытие страницы \"Публикации\"")
    public void openPublicationsPage(){
        getPublications().click();
    }
    @Step("Открытие страницы \"Авторы\"")
    public void openAuthorsPage(){
        getAuthors().click();
    }
    @Step("Открытие страницы \"Компании\"")
    public void openCompaniesPage(){
        getCompaniesButton().click();
    }
    @Step("Переход на соц сеть \"Вк\"")
    public void openVKPage(){
        getVK().click();
    }
    @Step("Переход на соц сеть \"Телеграмм\"")
    public void openTelegram(){
        getTelegram().click();
    }
    @Step("Переход на соц сеть \"Твиттер\"")
    public void openTwitter(){
        getTwitter().click();
    }
    @Step("Переход на соц сеть \"Facebook\"")
    public void openFacebook(){
        getFacebook().click();
    }

    @Step("Переход на  \"Яндекс\"")
    public void openYa(){
        getYa().click();
    }

    @Step("Открытие языковых настроек")
    public void openLangSettings(){
        getLangSettings().click();
    }

    @Step("Выбор английского языка")
    public void selectLangEnglish(){
        String script = "document.querySelector(\"[id='hl_langs_en']\").click();";
        ((JavascriptExecutor) baseHooks.getDriver()).executeScript(script);
    }

    @Step("Выбор русского языка")
    public void selectLangRussiah(){
        String script = "document.querySelector(\"[id='hl_langs_ru']\").click();";
        ((JavascriptExecutor) baseHooks.getDriver()).executeScript(script);
    }

    @Step("Сохранение языковых настроек")
    public void saveLangSettings(){
        getLangSettingsButton().click();
    }

}