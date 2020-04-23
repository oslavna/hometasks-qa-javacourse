package pages;

import helpers.BaseHooks;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    String baseUrl = "https://habr.com/ru/";
    BaseHooks baseHooks = new BaseHooks();

    public BasePage() {
        PageFactory.initElements(BaseHooks.getDriver(), this);
    }
}
