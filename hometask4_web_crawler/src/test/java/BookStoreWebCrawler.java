import helpers.ChromeWebDriver;
import helpers.MyFileWriter;
import helpers.pages.MainPage;
import helpers.Steps;
import java.io.IOException;
import java.util.ArrayList;


public class BookStoreWebCrawler {
    public static void main (String args []) throws IOException {

    Steps step = new Steps();
    MainPage mainPage = new MainPage();
        MyFileWriter fw = new MyFileWriter();
        ChromeWebDriver.create();
        fw.createFile();
        mainPage.openAudioBookPage();

        ArrayList<String> bookLinkList = new ArrayList<>(step.getUrlList());

        for (String url : bookLinkList) {

            fw.writeNewLine(step.getBookInfo(url));
        }

        ChromeWebDriver.quit();
    }

}
