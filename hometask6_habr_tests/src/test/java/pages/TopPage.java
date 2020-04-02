package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.BaseHooks;

public class TopPage extends BasePage {

    String pageUrl = baseUrl + "top/";

    public TopPage() {
        PageFactory.initElements(BaseHooks.getDriver(), this);
    }

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