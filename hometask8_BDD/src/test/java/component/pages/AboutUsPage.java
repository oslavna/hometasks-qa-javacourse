package component.pages;

import component.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class AboutUsPage {

    public void init() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//h1[@class='about-header__title']")
    protected WebElement aboutHeader;

    @FindBy (xpath = "//a[@class='header2__logo-img']")
    protected WebElement logoHeader;

    @FindBy (xpath = "//div[@class='about-license']//div[@class='about__title']")
    protected WebElement licenseTitle;

    public WebElement getLogoHeader(){
        return logoHeader;
    }

    public String getAboutHeaderText() {
        return aboutHeader.getText();
    }

    public String getLicenseTitle() {
        return licenseTitle.getText();
    }

}