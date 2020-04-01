package component.pages;

import component.utils.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MainPage {

    @Value("${mainUrl}")
    protected String mainUrl;

    public void init() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".header2_subheader-container__right [title='Рекрутерам']")
    protected WebElement recruiterSectionLink;

    @FindBy(xpath = "//a[@class='subtitle-new']")
    protected WebElement teachersTitle;

    @FindBy(xpath = "//div[contains(@class,'transitional-main__teachers')]//a[1]//div[2]")
    protected WebElement firstTeacher;


    public boolean teacherIsPresent(){
        return firstTeacher.isDisplayed();
    }

    public String getTitleOfTeachersContainer(){
        return teachersTitle.getText();
    }

    public void getAboutUsPage() {
        String script = "document.querySelector(\"[class='footer2__container container'] [title='О нас']\").click();";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script);
    }

    public void getFeedbackPage() {
        String script = "document.querySelector(\"[class='footer2__container container'] [title='Отзывы']\").click();";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script);
    }

    public void getContactPage() {
        String script = "document.querySelector(\"[class='footer2__container container'] [title='Контакты']\").click();";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script);
    }

    public WebElement getRecruiterLink() {
        return recruiterSectionLink;
    }

    public String getBaseUrl() {
        return mainUrl;
    }

    public void openMainPage(){
        Driver.getDriver().get(getBaseUrl());
    }

    public void moveToFacebookPage(){
        String script = "document.querySelector(\"[class='footer2__container container'] [class*='fb']\").click();";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script);
    }

    public void moveToRecruiterPage(){
        getRecruiterLink().click();
    }

}
