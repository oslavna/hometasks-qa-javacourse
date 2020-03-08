package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalPage extends AbstractPage {

    public String getValueTextField(WebElement webElement){
        return webElement.getAttribute("value");
    }

    public PersonalPage(WebDriver driver) {
        super(driver);
    }


    public PersonalPage tabAboutMeOpen(){

        driver.get("https://otus.ru/lk/biography/personal/");
        return this;

    }

    public PersonalPage enterName(String name){
        driver.findElement(By.cssSelector("[name='fname']")).clear();
        driver.findElement(By.cssSelector("[name='fname']")).sendKeys(name);
        return this;
    }

    public PersonalPage enterLatinName(String name){
        driver.findElement(By.cssSelector("[name='fname_latin']")).clear();
        driver.findElement(By.cssSelector("[name='fname_latin']")).sendKeys(name);
        return this;
    }

    public PersonalPage enterSurname(String name){
        driver.findElement(By.cssSelector("[name='lname']")).clear();
        driver.findElement(By.cssSelector("[name='lname']")).sendKeys(name);
        return this;
    }

    public PersonalPage enterLatinSurname(String name){
        driver.findElement(By.cssSelector("[name='lname']")).clear();
        driver.findElement(By.cssSelector("[name='lname']")).sendKeys(name);
        return this;
    }

    public PersonalPage enterBlogName(String name){
        driver.findElement(By.cssSelector("[name='blog_name']")).clear();
        driver.findElement(By.cssSelector("[name='blog_name']")).sendKeys(name);
        return this;
    }
    public PersonalPage enterDateOfBirth(String date){
        driver.findElement(By.cssSelector("[name='date_of_birth']")).clear();
        driver.findElement(By.cssSelector("[name='date_of_birth']")).sendKeys(date);
        return this;
    }
    public PersonalPage selectCountry(String country){
        String selectCountryRussia = "document.querySelector(\"[name='country']\").click(); " +
                "+ document.querySelector(\"[title=" + country+"]\").click();";
        ((JavascriptExecutor)driver).executeScript(selectCountryRussia);
        return this;
    }

    public PersonalPage selectCityMoscow() throws InterruptedException {
        Thread.sleep(500);
        String selectCityMoscow = "document.querySelector(\"[name='city']\").click(); " +
                "+ document.querySelector(\"[title='Москва']\").click();";
        ((JavascriptExecutor)driver).executeScript(selectCityMoscow);
        return this;
    }
    public PersonalPage selectRemoteWork() {
        String script = "document.querySelector(\"[value='remote']\").click();";
        ((JavascriptExecutor)driver).executeScript(script);
        return this;
    }

    public PersonalPage openFirstCommunicationTypeList() {
        String script = "document.querySelector(\"[name='contact-0-service']\").click();";
        ((JavascriptExecutor)driver).executeScript(script);
        return this;
    }
    public PersonalPage selectCommunicationTypeFacebook() {
        driver.findElement(By.cssSelector("[title='Facebook']")).click();
        return this;
    }

    public PersonalPage enterValueForFirstCommunicationType(String value) {
        driver.findElement(By.cssSelector("[name='contact-1-value']")).clear();
        driver.findElement(By.cssSelector("[name='contact-1-value']")).sendKeys(value);
        return this;
    }
    public PersonalPage addSecondCommunicationType() {
        driver.findElement(By.cssSelector("[name='contact-1-service']")).click();
        return this;
    }

    public PersonalPage openSecondCommunicationTypeList() {
        String script = "document.querySelector(\"[name='contact-1-service']\").click();";
        ((JavascriptExecutor)driver).executeScript(script);
        return this;
    }

    public PersonalPage selectCommunicationTypeTelegram() {
        driver.findElement(By.cssSelector(":nth-child(3) > .container__col_ssm-12 button[title='Тelegram']")).click();
        return this;
    }

    public PersonalPage enterValueForSecondCommunicationType(String value) {
        driver.findElement(By.cssSelector("[name='contact-1-value']")).clear();
        driver.findElement(By.cssSelector("[name='contact-1-value']")).sendKeys(value);
        return this;
    }
    public PersonalPage saveChangesOnTheProfilePage(){
        driver.findElement(By.cssSelector("[class*='button_gray']")).click();
        return this;
    }

}