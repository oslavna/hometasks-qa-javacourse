package component.steps;

import component.pages.MainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import component.utils.Driver;
import java.util.ArrayList;


public class MainPageStepdefs {

    @Autowired
    protected MainPage mainPage;

    public void moveToNextTab(){
        Driver.getDriver().switchTo().window( new ArrayList<>(Driver.getDriver().getWindowHandles()).get(1));
    }

    public String currentUrl(){
        return Driver.getDriver().getCurrentUrl();
    }

    @Given("Im in the main page")
    public void imOnTheMainPage() {
        mainPage.init();
        mainPage.openMainPage();
    }

    @Given("I'm in the recruiters page")
    public void imOnTheRecruitersPage() {
        mainPage.init();
        mainPage.openMainPage();
        mainPage.moveToRecruiterPage();
    }

    @When("I click 'Facebook' link")
    public void iClickFacebookLink() {
        mainPage.moveToFacebookPage();
    }

    @When ("I click 'About as'")
    public void iClickAboutUsButton(){
        mainPage.getAboutUsPage();
    }

    @When ("I click 'Feedback'")
    public void iClickFeedbackButton(){
        mainPage.getFeedbackPage();
    }

    @When ("I click 'Contacts'")
    public void iClickContactsButton(){
        mainPage.getContactPage();
    }

    @Then("I see Facebook page")
    public void iSeeFacebookPage() {
        moveToNextTab();
        Assert.assertEquals("https://www.facebook.com/otusru/", currentUrl());
    }

    @Then("I see teachers of courses")
    public void iSeeTeachersOnThePage() {
        Assert.assertEquals("Преподаватели", mainPage.getTitleOfTeachersContainer());
        Assert.assertTrue(mainPage.teacherIsPresent());
    }

    @Then("I see the main page")
    public void mainPageIsOpened() {
        Assert.assertEquals("https://otus.ru/", currentUrl());
    }

}
