package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.BaseHooks;

public class NewsPage extends BasePage{

    String pageUrl = baseUrl + "news/";

    public NewsPage() {
        PageFactory.initElements(BaseHooks.getDriver(), this);
    }

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



