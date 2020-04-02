package pages;

import helpers.BaseHooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorsPage extends BasePage{

    String pageUrl = baseUrl + "users/";

    public AuthorsPage() {
        PageFactory.initElements(BaseHooks.getDriver(), this);
    }

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

