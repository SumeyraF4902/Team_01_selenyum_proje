package pages;


import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.function.Function;

public class CompanyPage {

    WebDriver driver;

    public CompanyPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath="//li[@id='link2']")
    public WebElement companyButton;

    @FindBy (xpath="//h5[@class='card-title']")
    public WebElement companyVisible;

    @FindBy (xpath="//button[@class='btn btn-outline-dark']")
    public WebElement editbutonunaTik;

    @FindBy (xpath="//input[@name='name']")
    public WebElement name;

    @FindBy (xpath="//input[@name='email']")
    public WebElement email;

    @FindBy (xpath="//button[@class='btn btn-info text-white px-3']")
    public WebElement save;

    @FindBy (xpath="//div/span[contains(text(),'Please enter a name for company')]")
    public WebElement textUyari;

    @FindBy (xpath="//label[@id='name']")
    public WebElement guncelname;

    @FindBy (xpath="//")
    public WebElement cancelButton;


    public void companyClick(){
        companyButton.click();
    }

    public void companyVisibleDisplay(){
        Assert.assertTrue(companyVisible.isDisplayed());
    }

    public void editbutonunaTiklar() {
        editbutonunaTik.click();
    }

    public void clearemailandname(){
        name.click();
        name.sendKeys(Keys.CONTROL+"A");
        name.sendKeys(Keys.DELETE);
        email.click();
        email.sendKeys(Keys.CONTROL+"A");
        email.sendKeys(Keys.DELETE);
    }

    public void saveTiklar() {
        save.click();
    }

    public void gorunurligiDogrula() {
        Assert.assertTrue(textUyari.isDisplayed());
    }

    public void cancelButtonTiklar() {
        companyButton.click();
    }

    public void nameVeEmailTextboxDegistir() {
        sleep(9000);
        name.click();
        name.sendKeys("aaaaa");
        save.click();
        email.click();
        email.sendKeys("aaaaa");
        save.click();
    }

    public void degisimDogrulanir() {
        sleep(9000);
        Assert.assertTrue(guncelname.getText().contains("aaa"));
    }


    public static void sleep(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
