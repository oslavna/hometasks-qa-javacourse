package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends BasePage{

    String pageUrl = baseUrl + "news/";

    @FindBy(xpath = "//a[@class='post__title_link']")
    protected WebElement upperPost;

    public WebElement getUpperPost() {
        return upperPost;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean firstPostIsPresent() {
       return getUpperPost().isDisplayed();
    }
}



