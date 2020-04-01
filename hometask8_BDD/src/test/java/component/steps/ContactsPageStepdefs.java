package component.steps;

import component.pages.ContactPage;
import component.utils.Driver;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;


public class ContactsPageStepdefs {
    @Autowired
    protected ContactPage contactPage;

    @Then("I see the page with correct email")
    public void iSeeThatEmailIsCorrect(){
        contactPage.init();
        Assert.assertEquals("help@otus.ru", contactPage.getEmail());
    }

    @Then("I see the page with Requisites")
    public void iSeeRequisites(){
        contactPage.init();
        Assert.assertEquals("Реквизиты", contactPage.getRequisites());
    }
    }





