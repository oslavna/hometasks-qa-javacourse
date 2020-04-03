package pages;
import helpers.WebDriverFactory;
import org.jsoup.Connection;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import helpers.BaseHooks;

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

    public void openDevThread(){
        getDevThreads().click();
    }

    public void openScienceThread(){
        getScienceThreads().click();
    }

    public void openAdminThread(){
        getAdminThreads().click();
    }

    public void openDesignThread(){
        getDesignThreads().click();
    }

    public void openMarketingThread(){
        getMarketingThreads().click();
    }

    public String getTitleOfThread(){
        return getHeaderOfThread().getText();
    }

    public void openHubrMainPage(){
        baseHooks.getDriver().get(getHubrMainUrl());
    }


    public void openNewsPage() {
        try {
            getNewsButton().click();
        } catch (NoSuchElementException e) {
            baseHooks.cleanUp();
            openHubrMainPage();
            getNewsButton().click();
        }
    }

    public void openHubsPage(){
        getHubsButton().click();
    }

    public void openPublicationsPage(){
        getPublications().click();
    }

    public void openAuthorsPage(){
        getAuthors().click();
    }

    public void openCompaniesPage(){
        getCompaniesButton().click();
    }

    public void openVKPage(){
        getVK().click();
    }

    public void openTelegram(){
        getTelegram().click();
    }

    public void openTwitter(){
        getTwitter().click();
    }

    public void openFacebook(){
        getFacebook().click();
    }

    public void openYa(){
        getYa().click();
    }

    public void openLangSettings(){
        getLangSettings().click();
    }

    public void selectLangEnglish(){
        String script = "document.querySelector(\"[id='hl_langs_en']\").click();";
        ((JavascriptExecutor) baseHooks.getDriver()).executeScript(script);
    }

    public void selectLangRussiah(){
        String script = "document.querySelector(\"[id='hl_langs_ru']\").click();";
        ((JavascriptExecutor) baseHooks.getDriver()).executeScript(script);
    }

    public void saveLangSettings(){
        getLangSettingsButton().click();
    }

}