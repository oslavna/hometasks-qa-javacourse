import helpers.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;


public class BookStoreWebCrawlerTest {

        @Test
        public void BookWebCrawler() throws IOException {
        Steps step = new Steps();
        MyFileWriter fw = new MyFileWriter();
        DriverManager.create();
        fw.createFile();
        step.openAudioBookPage();
        ArrayList<String> bookLinkList = new ArrayList<>(step.getUrlList());
        for (String url : bookLinkList) {
            fw.writeNewLine(step.getBookInfo(url));
        }

      DriverManager.quit();
    }

}
