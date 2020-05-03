package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopPage extends BasePage {

    private WebDriver driver;

    public TopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

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