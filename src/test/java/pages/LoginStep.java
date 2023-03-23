package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ConfigReader;
import java.time.Duration;
public class LoginStep {
    WebDriver driver;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "loginButton")
    WebElement login_button;

    @FindBy(id = "username")
    WebElement login_username;

    @FindBy(id = "password")
    WebElement login_password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement login_submit_btn;

    @FindBy(xpath = "//span[@class='fw-bold']")
    public WebElement login_email;

    @FindBy(linkText = "Account Management")
    WebElement login_Account_mng;

    @FindBy(xpath = "//h5[@class]")
    public WebElement Authorized;

    @FindBy(xpath = "//div//a//img[@class]")
    public WebElement logo;

    @FindBy(id = "divCollapseUncollapse")
    public WebElement hamburger;

    @FindBy(linkText = "Dashboard")
    public WebElement hamburger_check;

    @FindBy(xpath = "//a[.='gm3wa-a3m-client']")
    public WebElement ignorePage;

    public void driverGet(String text){
        driver.get(text);
    }

    public void typeUsername(String email) {login_username.sendKeys(email);
    }

    public void typePassword(String password) {login_password.sendKeys(password);
    }

    public void clickLogin() {
        login_button.click();
    }

    public void clickSubBtn() {
        login_submit_btn.click();
    }

    public void clickprofile() {
        login_email.click();
    }

    public void clickAccount_mng() {
        login_Account_mng.click();
    }
    public void click(WebElement a){
        a.click();
    }

    public void AssertTrue(boolean a){
        Assert.assertTrue(a);
    }
    public String get_Config(String a ){
        return ConfigReader.getProperty(a);

    }

    public String GetText(WebElement a){
        return a.getText();

    }

}
