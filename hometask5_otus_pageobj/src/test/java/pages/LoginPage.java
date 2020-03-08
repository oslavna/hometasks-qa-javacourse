package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private static final String URL = "https://otus.ru/";
    private By search = By.xpath("//input[@name='q']");
    WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openMainPage(){//
        driver.get(URL);
        return this;
    }

    public LoginPage login(String login, String password) {
        driver.get(URL);
        driver.findElement(By.xpath("//span[@class='header2__auth-reg']")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='new-button new-button_full new-button_blue new-button_md']")));
        WebElement form = driver.findElement(By.xpath("//form[@class='new-log-reg__form js-login']"));
        form.findElement(By.cssSelector("input[name=email]")).sendKeys(login);
        form.findElement(By.cssSelector("input[type=password]")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='new-button new-button_full new-button_blue new-button_md']")).submit();

        return this;
    }

}