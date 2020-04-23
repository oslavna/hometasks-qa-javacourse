package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompaniesPage extends BasePage{

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


