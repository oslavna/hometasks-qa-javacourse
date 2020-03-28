package helpers.pages;

import helpers.ChromeWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    public static String mainPageUrl = "https://www.mann-ivanov-ferber.ru/";

    protected By booksInList = By.cssSelector(".c-continuous-list .lego-book");

    @FindBy(css = ".c-continuous-list .lego-book")
    protected List<WebElement> bookList;

    @FindBy(css = ".page-loader div")
    protected WebElement pageLoader;

    public WebElement getLoaderOfPage() {
        return pageLoader;
    }

    public static String getMainPageUrl(){
        return mainPageUrl;
    }

    public void openAudioBookPage() {

        ChromeWebDriver.getDriver().get(AudioBookPage.audioBookUrl);

    }

    public List<WebElement> getBookList(){
        return bookList;
    }

    public String getBookURL(WebElement webElement) {
        return webElement.findElement(By.cssSelector("[href]")).getAttribute("href");
    }

    public By getBooksInList() {
        return booksInList;
    }

}
