package helpers;

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

        BookPage bookPage = PageFactory.initElements(ChromeWebDriver.getDriver(), BookPage.class);
        ArrayList<String> lineBook = new ArrayList<>();
        ChromeWebDriver.getDriver().get(url);
        String bookLink = bookPage.getPageUrl();
        String bookName = bookPage.getBookName();
        String bookAuthor = bookPage.getBookAuthor();
        String paperBookPrice = bookPage.getPaperBookPrice();
        String eBookPrice = bookPage.getElectroBookPrice();
        String audioBookPrice = bookPage.getAudioBookPrice();
        String introLink = bookPage.getIntroContentLink();
        lineBook.add("\"" + bookLink + "\"" + "; " + "\"" + bookName + "\"" + "; " + "\"" + bookAuthor + "\"" + "; " + "\"" + paperBookPrice + "; " + "\"" + eBookPrice + "; " + "\"" + audioBookPrice + "\"" + "; " + "\"" + introLink + "\"" + "; ");
        return lineBook;
    }
}



