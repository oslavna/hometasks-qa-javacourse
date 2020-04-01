package component.pages;

import component.utils.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
public class RecruitersPage {

    public void init() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='new-button new-button_blue ri-header__button js-open-modal']")
    protected WebElement cooperateLink;

    @FindBy(xpath = "//div[@class='modal ri-modal js-modal-content']")
    protected WebElement cooperateForm;

    @FindBy(xpath = "//div[@class='modal__close2 ic ic-close-black js-close-modal']")
    protected WebElement closeCooperationForm;

    public WebElement getCooperateLink() {
        return cooperateLink;
    }

    public void openCooperateForm(){
        getCooperateLink().click();
    }

    public void getRecruiterPage(){
        Driver.getDriver().get("https://otus.ru/recruiters-invite/");
    }

    public boolean cooperateFormIsVisible(){
        Driver.getWait().until(ExpectedConditions.visibilityOf(cooperateForm));
        return cooperateForm.isDisplayed();
    }

    public void closeCooperateForm(){
        String script = "document.querySelector(\"[class='modal__close2 ic ic-close-black js-close-modal']\").click();";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script);

    }

}
