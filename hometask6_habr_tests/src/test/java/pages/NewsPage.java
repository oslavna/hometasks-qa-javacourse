package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.BaseHooks;

public class NewsPage {

    String pageUrl = BaseHooks.getBaseUrl() + "news/";
    BaseHooks baseHooks = new BaseHooks();

    public NewsPage() {
        PageFactory.initElements(baseHooks.getDriver(), this);
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



