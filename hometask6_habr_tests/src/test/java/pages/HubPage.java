package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.BaseHooks;

public class HubPage extends BasePage {

    String pageUrl = baseUrl + "hubs/";

    public HubPage() {
        PageFactory.initElements(BaseHooks.getDriver(), this);
    }

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