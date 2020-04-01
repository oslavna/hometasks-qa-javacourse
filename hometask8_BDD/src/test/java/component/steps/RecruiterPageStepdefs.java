package component.steps;

import component.pages.RecruitersPage;
import component.utils.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


public class RecruiterPageStepdefs {
    @Autowired
    protected RecruitersPage recruitersPage;

    public String currentUrl(){
        return Driver.getDriver().getCurrentUrl();
    }

    @Given ("I see a cooperate form")
    public void iOpenCooperateForm() {
        recruitersPage.init();
        recruitersPage.getRecruiterPage();
        recruitersPage.openCooperateForm();
    }

    @When("I click 'cooperate' link")
    public void iClickCooperateLink() {
        recruitersPage.init();
        recruitersPage.openCooperateForm();
    }

    @When("I click close cooperation form")
    public void iClickCloseForm() {
        recruitersPage.init();
        recruitersPage.closeCooperateForm();
    }

    @Then("I see a recruiter page")
    public void recruiterPageIsOpened() {
        recruitersPage.init();
        Assert.assertEquals("https://otus.ru/recruiters-invite/", currentUrl());
    }

    @Then("I see a cooperation form")
    public void iSeeCooperateForm() {
        recruitersPage.init();
        Assert.assertTrue(recruitersPage.cooperateFormIsVisible());

    }

}





