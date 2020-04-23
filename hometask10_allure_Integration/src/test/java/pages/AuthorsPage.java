package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorsPage extends BasePage{

    String pageUrl = baseUrl + "users/";

    @FindBy(xpath = "//a[@class='list-snippet__fullname']")
    protected WebElement user;

    public WebElement getUser() {
        return user;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean usersIsPresent() {
        return getUser().isDisplayed();
    }
}

