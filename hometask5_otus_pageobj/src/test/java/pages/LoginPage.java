package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private static final String URL = "https://otus.ru";
    private By search = By.xpath("//span[@class='header2__auth-reg']");
    WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(URL);

        return this;
    }

    public void login(){
        driver.findElement(By.xpath("//span[@class='header2__auth-reg']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='new-button new-button_full new-button_blue new-button_md']")));
        WebElement form = driver.findElement(By.cssSelector("form.new-log-reg_form.js-login"));
        //form.findElement(By.cssSelector("input[name=email]")).sendKeys("");
        //form.findElement(By.cssSelector("input[type=password]")).sendKeys("");
        //return new LoginPage(driver);
    }

//    public SearchPage search(String text) {
//        driver.findElement(search).sendKeys(text);
//        driver.findElement(search).sendKeys(Keys.ENTER);
//
//        return new SearchPage(driver);
//    }

}
