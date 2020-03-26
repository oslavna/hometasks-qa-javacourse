package pages;

import helpers.BaseHooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaniesPage {

    String pageUrl = "https://habr.com/ru/companies/";
    BaseHooks baseHooks = new BaseHooks();

    public CompaniesPage() {
        PageFactory.initElements(baseHooks.getDriver(), this);
    }

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


