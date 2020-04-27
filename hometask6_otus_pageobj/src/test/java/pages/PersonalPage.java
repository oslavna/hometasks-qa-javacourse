package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class PersonalPage extends AbstractPage {

    public String getText(WebElement w){
        return w.getAttribute("value");
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

    public String getName() {
        return  getText(driver.findElement(By.cssSelector("[name='fname']")));
    }

    public PersonalPage enterLatinName(String name){
        driver.findElement(By.cssSelector("[name='fname_latin']")).clear();
        driver.findElement(By.cssSelector("[name='fname_latin']")).sendKeys(name);
        return this;
    }

    public String getLatinName() {
        return  getText(driver.findElement(By.cssSelector("[name='fname_latin']")));
    }

    public PersonalPage enterSurname(String name){
        driver.findElement(By.cssSelector("[name='lname']")).clear();
        driver.findElement(By.cssSelector("[name='lname']")).sendKeys(name);
        return this;
    }
    public String getSurname() {
        return  getText(driver.findElement(By.cssSelector("[name='lname']")));
    }

    public PersonalPage enterLatinSurname(String name){
        driver.findElement(By.cssSelector("[name='lname_latin']")).clear();
        driver.findElement(By.cssSelector("[name='lname_latin']")).sendKeys(name);
        return this;
    }

    public String getLatinSurname() {
        return  getText(driver.findElement(By.cssSelector("[name='lname_latin']")));
    }

    public PersonalPage enterBlogName(String name){
        driver.findElement(By.cssSelector("[name='blog_name']")).clear();
        driver.findElement(By.cssSelector("[name='blog_name']")).sendKeys(name);
        return this;
    }

    public String getBlogName() {
        return  getText(driver.findElement(By.cssSelector("[name='blog_name']")));
    }

    public PersonalPage enterDateOfBirth(String date){
        driver.findElement(By.cssSelector("[name='date_of_birth']")).clear();
        driver.findElement(By.cssSelector("[name='date_of_birth']")).sendKeys(date);
        return this;
    }

    public String getDateOfBirth() {
        return  getText(driver.findElement(By.cssSelector("[name='date_of_birth']")));
    }

    public PersonalPage selectCountry(String country){
        String selectCountryRussia = "document.querySelector(\"[name='country']\").click(); " + "+ document.querySelector(\"[title=" + country+"]\").click();";
        ((JavascriptExecutor)driver).executeScript(selectCountryRussia);
        return this;
    }


    public PersonalPage selectCity(String city) throws InterruptedException {
        Thread.sleep(500);
        String selectCityMoscow = "document.querySelector(\"[name='city']\").click(); " + "+ document.querySelector(\"[title="+ city +"]\").click();";
        ((JavascriptExecutor)driver).executeScript(selectCityMoscow);
        return this;
    }
    public PersonalPage selectRemote() {
        String script = "document.querySelector(\"[value='remote']\").click();";
        ((JavascriptExecutor)driver).executeScript(script);
        return this;
    }

    public PersonalPage openFirstContact() {
        String script = "document.querySelector(\"[name='contact-0-service']\").click();";
        ((JavascriptExecutor)driver).executeScript(script);
        return this;
    }

    public PersonalPage selectContactVk() {
        driver.findElement(By.cssSelector("[title='VK']")).click();
        return this;
    }


    public PersonalPage enterVkID(String url) {
        driver.findElement(By.cssSelector("[name='contact-0-value']")).clear();
        driver.findElement(By.cssSelector("[name='contact-0-value']")).sendKeys(url);
        return this;
    }

    public String getVKContact(){
        return  getText(driver.findElement(By.cssSelector("[name='contact-0-value']")));
    }

    public PersonalPage openSecondContact() {
        driver.findElement(By.cssSelector(".js-formset > button")).click();
        String script = "document.querySelector(\"[name='contact-1-service']\").click();";
        ((JavascriptExecutor)driver).executeScript(script);
        return this;
    }

    public PersonalPage selectContactSkype() {
        driver.findElement(By.cssSelector(":nth-child(3) > .container__col_ssm-12 button[title='Skype']")).click();
        return this;
    }

    public String getSkypeContact(){
        return  getText(driver.findElement(By.cssSelector("[name='contact-1-value']")));
    }

    public PersonalPage enterSkypeName(String value) {
        driver.findElement(By.cssSelector("[name='contact-1-value']")).clear();
        driver.findElement(By.cssSelector("[name='contact-1-value']")).sendKeys(value);
        return this;
    }
    public PersonalPage selectMaleOrFemale() {
        driver.findElement(By.cssSelector("[id='id_gender']")).click();
        driver.findElement(By.cssSelector("[value='f']")).click();
        return this;
    }

    public String getFemaleOrMale(){
        return  getText(driver.findElement(By.cssSelector("[id='id_gender']")));
    }

    public PersonalPage enterCompany(String company) {
        driver.findElement(By.cssSelector("[name='company']")).clear();
        driver.findElement(By.cssSelector("[name='company']")).sendKeys(company);
        return this;
    }
    public String getCompany(){
        return  getText(driver.findElement(By.cssSelector("[name='company']")));
    }

    public PersonalPage save(){
        driver.findElement(By.cssSelector("[class*='button_gray']")).click();
        return this;
    }

}