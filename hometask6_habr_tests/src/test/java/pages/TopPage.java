package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.BaseHooks;

public class TopPage {

    String pageUrl = "https://habr.com/ru/top/";
    BaseHooks baseHooks = new BaseHooks();

    public TopPage() {
        PageFactory.initElements(baseHooks.getDriver(), this);
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