package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {
    protected String mainPageUrl = "https://otus.ru/";
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open(){
        driver.get(mainPageUrl);
        return this;
    }

    public MainPage openPersonalPage(){
        driver.findElement(By.xpath("//div[@class='inline-block-promo']")).click();
        return this;

    }

}
