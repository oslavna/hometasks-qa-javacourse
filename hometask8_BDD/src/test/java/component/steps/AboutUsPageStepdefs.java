package component.steps;

import component.pages.AboutUsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;


public class AboutUsPageStepdefs {

     @Autowired
     protected AboutUsPage aboutUsPage;

     @When("I click logo Otus")
     public void clickOtusLogo(){
        aboutUsPage.init();
        aboutUsPage.getLogoHeader().click();
    }

     @Then ("I see the page with title 'About us'")
     public void iSeeAboutUsTitle() {
         aboutUsPage.init();
         aboutUsPage.getAboutHeaderText();
         Assert.assertEquals("О КОМПАНИИ\n" +
                 "OTUS", aboutUsPage.getAboutHeaderText());
     }

     @Then ("I see the License")
     public void iSeeLicenseOnThePage() {
         aboutUsPage.init();
         aboutUsPage.getLicenseTitle();
          Assert.assertEquals("ОБРАЗОВАТЕЛЬНАЯ ЛИЦЕНЗИЯ", aboutUsPage.getLicenseTitle());
         }
}





