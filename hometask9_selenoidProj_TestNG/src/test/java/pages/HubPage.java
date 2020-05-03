package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HubPage extends BasePage {

    private WebDriver driver;

    public HubPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    String pageUrl = baseUrl + "hubs/";

    @FindBy(xpath = "//a[@class='list-snippet__title-link']")
    protected WebElement topics;

    public WebElement getTopics() {
        return topics;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean topicsIsPresent() {
        return getTopics().isDisplayed();
    }
}