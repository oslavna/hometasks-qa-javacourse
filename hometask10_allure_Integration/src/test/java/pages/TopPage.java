package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopPage extends BasePage {

    String pageUrl = baseUrl + "top/";

    @FindBy(xpath = " //a[@class='post__title_link']")
    protected WebElement upperPublication;

    public WebElement getUpperPublication(){
        return upperPublication;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean topicsIsPresent() {
        return getUpperPublication().isDisplayed();
    }
}