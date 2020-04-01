package component.pages;

import component.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class ContactPage {

    public void init() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='contacts__email']//a")
    protected WebElement email;

    @FindBy(xpath = "//div[contains(@class,'contacts__cols')]//div[2]//div[1]")
    protected WebElement requisites;

    public String getEmail() {
        return email.getText();
    }

    public String getRequisites() {
        return requisites.getText();

    }
}