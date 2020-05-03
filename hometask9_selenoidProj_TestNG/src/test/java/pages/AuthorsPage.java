package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorsPage extends BasePage{
    private WebDriver driver;

    public AuthorsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

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

