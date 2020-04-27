package pages;

import org.openqa.selenium.WebDriver;


public class MainPage extends AbstractPage {
    protected String mainPageUrl = "https://otus.ru/";
    protected String learningPageUrl ="https://otus.ru/learning/";


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        driver.get(mainPageUrl);
        return this;
    }

    public MainPage openPersonalPage() {
       driver.get(learningPageUrl);
        return this;
    }
}
