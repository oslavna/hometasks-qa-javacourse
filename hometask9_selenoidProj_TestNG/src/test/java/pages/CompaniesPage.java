package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaniesPage extends BasePage{

    private WebDriver driver;

    public CompaniesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    String pageUrl = baseUrl + "companies/";


    @FindBy(xpath = "//a[@class='list-snippet__title-link']")
    protected WebElement companies;

    public WebElement getCompanies() {
        return companies;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean companyListIsPresent() {
        return getCompanies().isDisplayed();
    }
}


