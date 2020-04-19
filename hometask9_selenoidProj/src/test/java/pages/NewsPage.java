package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage extends BasePage{

    private WebDriver driver;

    public NewsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

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



