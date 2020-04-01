package component.steps;

import component.utils.Driver;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;


public class FeedbackPageStepdefs {

    public String currentUrl() {
        return Driver.getDriver().getCurrentUrl();
    }

    @Then("I see the page 'Feedback'")
    public void iSeeTitleWithFeedback() {
        Assert.assertEquals("https://otus.ru/reviews/", currentUrl());
    }
}






