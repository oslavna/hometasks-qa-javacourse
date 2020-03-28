package helpers.pages;

import helpers.ChromeWebDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AudioBookPage {

    public static String audioBookUrl = MainPage.getMainPageUrl() + "books/allbooks/?booktype=audiobook";

    @FindBy(xpath = "//h1[@class='header active p-sky-title']//span")
    protected WebElement bookName;

    @FindBy(xpath = "//div[@class='l-book-description position-top']//span[@class='author active']")
    protected WebElement bookAuthor;

    @FindBy(css = ".l-book-buy-panel-top [data-type='book']")
    protected WebElement paperBookPrice;

    @FindBy(css = ".l-book-buy-panel-top [data-type='e-book']")
    protected WebElement eBookPrice;

    @FindBy(css = ".l-book-buy-panel-top [data-type='audiobook']")
    protected WebElement audioBookPrice;

    @FindBy(xpath = "//div[@class='nkk-other position-top']//a[@class='ng-binding']")
    protected WebElement introContentLink;

    @FindBy(xpath = "//div[@class='nkk-other position-top']//a[@class='nkk-file-download__link']")
    protected WebElement introContentLinkReserve;

    public String getAudioBookUrl() {
        return audioBookUrl;
    }

    public String getPageUrl() {
        return ChromeWebDriver.getDriver().getCurrentUrl();
    }

    public String getBookName() {
        return bookName.getAttribute("innerText");
    }

    public String getBookAuthor(){
        return bookAuthor.getAttribute("innerText");
    }

    public String getPaperBookPrice(){
        return paperBookPrice.getAttribute("data-price");
    }

    public String getElectroBookPrice(){
        try{
            return eBookPrice.getAttribute("data-price");
        }
        catch (NoSuchElementException e){

            return "Недоступно в электронном виде";
        }
    }

    public String getAudioBookPrice(){
        return audioBookPrice.getAttribute("data-price");
    }

    public String getIntroContentLink() {
        try{
            return introContentLink.getAttribute("href");
        }
        catch (NoSuchElementException e){

            try{
                return introContentLinkReserve.getAttribute("href");

            }catch (NoSuchElementException e1){

                return "Нет ознакомительного контента";
            }
        }
    }

}
