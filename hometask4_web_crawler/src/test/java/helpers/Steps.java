package helpers;

import helpers.pages.AudioBookPage;
import helpers.pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Steps {

    private static final Logger logger = LogManager.getLogger(Steps.class);


    public ArrayList<String> getUrlList()   {

        MainPage mainPage = PageFactory.initElements(ChromeWebDriver.getDriver(), MainPage.class);
        ArrayList<String> urls = new ArrayList<>();

        while (true) {
            List<WebElement> list2 = ChromeWebDriver.getDriver().findElements(mainPage.getBooksInList());
            ChromeWebDriver.getAction().moveToElement(mainPage.getLoaderOfPage()).perform();
            List<WebElement> list1 = mainPage.getBookList();
            if (list1.size() == list2.size()) {
                logger.info("Amount of books is "+list1.size());
                for (WebElement webElement : list1) {
                    String url = mainPage.getBookURL(webElement);
                    urls.add(url);
                }
                logger.info("Process starting...");
                break;
            }
        }
        return urls;
    }

    public ArrayList<String> getBookInfo(String url) {

        AudioBookPage audioBookPage = PageFactory.initElements(ChromeWebDriver.getDriver(), AudioBookPage.class);
        ArrayList<String> lineBook = new ArrayList<>();
        ChromeWebDriver.getDriver().get(url);
        String bookLink = audioBookPage.getPageUrl();
        String bookName = audioBookPage.getBookName();
        String bookAuthor = audioBookPage.getBookAuthor();
        String paperBookPrice = audioBookPage.getPaperBookPrice();
        String eBookPrice = audioBookPage.getElectroBookPrice();
        String audioBookPrice = audioBookPage.getAudioBookPrice();
        String introLink = audioBookPage.getIntroContentLink();
        lineBook.add("\"" + bookLink + "\"" + "; " + "\"" + bookName + "\"" + "; " + "\"" + bookAuthor + "\"" + "; " + "\"" + paperBookPrice + "; " + "\"" + eBookPrice + "; " + "\"" + audioBookPrice + "\"" + "; " + "\"" + introLink + "\"" + "; ");
        return lineBook;
    }
}



